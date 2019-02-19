package com.zeus.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author:fusheng
 * desc:
 * date:2018/12/13
 * ver:1.0
 **/

public class InitJob  {
    private static  final Logger LOG = LoggerFactory.getLogger(InitJob.class);

   public void init(){
       LOG.info("come in InitJob.init");
   }
}
