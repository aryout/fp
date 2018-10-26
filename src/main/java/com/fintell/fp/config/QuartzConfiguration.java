package com.fintell.fp.config;

import com.fintell.fp.utils.QuartzTaskService;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import org.springframework.scheduling.Trigger;
*/

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 10:15 2018/10/25
 **/
@Configuration
public class QuartzConfiguration {

    /**
     *
     * @return JobDetail 用于指定定时任务具体的类
     * @author chen dao peng
     * @date 2018/10/25
     */
    @Bean
    public JobDetail quartzTaskServiceJobDetail() {
        return JobBuilder.newJob(QuartzTaskService.class).withIdentity("quartzTaskService").storeDurably().build();
    }

    /**
     *
     * @return Trigger 用于指定定时任务触发的机制
     * @author chen dao peng
     * @date 2018/10/25
     */
    @Bean
    public Trigger quartzTaskServiceTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(quartzTaskServiceJobDetail())
                .withIdentity("quartzTaskService")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
