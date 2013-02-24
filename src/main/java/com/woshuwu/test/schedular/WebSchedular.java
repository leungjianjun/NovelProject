package com.woshuwu.test.schedular;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 13-2-24
 * Time: 下午10:23
 */
public class WebSchedular {

    private static Scheduler schedular;

    public static void startup(){
        try {
            schedular = StdSchedulerFactory.getDefaultScheduler();
            schedular.start();
            JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?")).build();
            schedular.scheduleJob(job, trigger);
            /*job = JobBuilder.newJob(HelloJob.class).withIdentity("job2", "group1").build();
            schedular.scheduleJob(job, trigger);
            job = JobBuilder.newJob(HelloJob.class).withIdentity("job3", "group1").build();
            schedular.scheduleJob(job, trigger);*/
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static Scheduler getSchedular(){
        return schedular;
    }
}
