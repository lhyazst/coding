package com.zeus.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 定时执行任务
 *
 * @author:fusheng
 * @date:2018/12/12 0012
 * @ver:1.0
 */
public class DeviceJob implements Job {
    private static Logger LOG = LoggerFactory.getLogger(DeviceJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.info("`come in DeviceJob.execute");
        /*
         * 定时任务执行内容
         *
         * */
    }

    public void doNothing() {
        LOG.info(new Date() + ": blank job do nothing");
    }
}
