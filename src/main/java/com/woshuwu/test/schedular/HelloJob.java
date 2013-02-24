package com.woshuwu.test.schedular;

import org.quartz.*;

/**
 * Created with IntelliJ IDEA.
 * User: jianjun_liang
 * Date: 13-2-22
 * Time: 下午9:32
 * To change this template use File | Settings | File Templates.
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //Every job has its own job detail
        JobDetail jobDetail = context.getJobDetail();
        // The name is defined in the job definition
        String jobName = jobDetail.getDescription();//任务名称
        JobDataMap dataMap = jobDetail.getJobDataMap();//任务所配置的数据映射表
        System.out.println("Hello!  HelloJob is executing.");
    }
}
