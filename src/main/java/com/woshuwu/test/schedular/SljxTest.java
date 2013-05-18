package com.woshuwu.test.schedular;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jianjun_liang
 * Date: 13-5-3
 * Time: 下午1:11
 * To change this template use File | Settings | File Templates.
 */
public class SljxTest {

    static List<String> htmlList = new ArrayList<String>();

    public static void main(String args[]) throws SchedulerException {
        //BasicConfigurator.configure();
        Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
        sched.start();
        JobDetail job = JobBuilder.newJob(Sljx.class).withIdentity("job1", "group1").build();
        job.getJobDataMap().put("htmlList",htmlList);

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0/50 * 8-20 * * ?")).build();
        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
    }
}
