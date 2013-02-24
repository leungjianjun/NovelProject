package com.woshuwu.test.schedular;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: jianjun_liang
 * Date: 13-2-22
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String args[]) throws SchedulerException {
        Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
        sched.start();

        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0/5 48-49 16 * * ?")).build();
        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
    }
}
