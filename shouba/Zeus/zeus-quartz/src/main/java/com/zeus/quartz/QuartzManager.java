package com.zeus.quartz;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("quartzManager")
public class QuartzManager {

    private static final Logger LOG = LoggerFactory.getLogger(QuartzManager.class);


    private Scheduler scheduler;

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * 功能： 添加一个定时任务
     *
     * @param jobName          任务名
     * @param jobGroupName     任务组名
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass         任务的类类型  eg:TimedMassJob.class
     * @param cron             时间设置 表达式，参考quartz说明文档
     */
    public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass, String cron, String items, String iotId) {
        LOG.info(String.format("jobName:[%s],  jobGroupName [%s],  triggerName [%s],  triggerGroupName [%s],  jobClass  [%s],  cron  [%s],  items  [%s], iotId  [%s]", jobName, jobGroupName, triggerName, triggerGroupName, jobClass.getName(), cron, items, iotId));
        try {
            // 任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            // 触发器

            JSONObject jsonObject = (JSONObject) JSONUtil.parse(items);
            jobDetail.getJobDataMap().put("data", jsonObject);
            jobDetail.getJobDataMap().put("iotId", iotId);
            jobDetail.getJobDataMap().put("items", items);
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 功能：修改一个任务的触发时间
     *
     * @param jobName
     * @param jobGroupName
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param cron             时间设置，参考quartz说明文档
     */
    public void modifyJobTime(String jobName, String jobGroupName, String triggerName, String triggerGroupName, String cron) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                triggerBuilder.startNow();
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
                // 创建Trigger对象
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 功能: 移除一个任务
     *
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     */
    public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            // 停止触发器
            scheduler.pauseTrigger(triggerKey);
            // 移除触发器
            scheduler.unscheduleJob(triggerKey);
            // 删除任务
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 功能: 修改一个任务
     *
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     */
    public void modifyJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass, String cron, String items, String iotId) {
        removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
        addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron, items, iotId);
    }


    /**
     * 功能：启动所有定时任务
     */
    public void startJobs() {
        try {
            scheduler.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 功能：关闭所有定时任务
     */
    public void shutdownJobs() {
        try {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}