package com.fintell.fp.utils;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时任务业务处理类
 * @author chen dao peng
 * @program fp
 * @description
 * @date 10:13 2018/10/25
 **/
@Slf4j
@DisallowConcurrentExecution // 用于标记定时任务禁止并发执行
public class QuartzTaskService extends QuartzJobBean {

    /**
     * 该方法用于实现定时任务的具体逻辑
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("------------- 定时任务开始 -------------");
        try {
            // 休眠5秒钟，模拟定时任务执行过程
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("------------- 定时任务结束 -------------");
    }

}