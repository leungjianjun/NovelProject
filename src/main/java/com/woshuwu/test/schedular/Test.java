package com.woshuwu.test.schedular;

import org.apache.log4j.BasicConfigurator;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jianjun_liang
 * Date: 13-2-22
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static Map<String,String> cnBetas = new HashMap<String, String>();

    public static void main(String args[]) throws SchedulerException {
        //BasicConfigurator.configure();
        Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
        sched.start();
        JobDetail job = JobBuilder.newJob(Sljx.class).withIdentity("job1", "group1").build();
        job.getJobDataMap().put("ArticleList",cnBetas);

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0/50 25-40 13 * * ?")).build();
        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
    }
}
