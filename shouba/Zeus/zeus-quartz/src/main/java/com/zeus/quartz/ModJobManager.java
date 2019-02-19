package com.zeus.quartz;

/**
 * @author:fusheng
 * @date:2018/12/13 0013
 * @ver:1.0
 */

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ModJobManager implements ApplicationListener<ContextRefreshedEvent> {
    protected static final Logger log = Logger.getLogger(ModJobManager.class);


    public void init() {
        log.info("start init");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

}