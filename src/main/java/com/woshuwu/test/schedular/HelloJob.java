package com.woshuwu.test.schedular;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created with IntelliJ IDEA.
 * User: jianjun_liang
 * Date: 13-2-22
 * Time: 下午9:32
 * To change this template use File | Settings | File Templates.
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("Hello!  HelloJob is executing.");
    }
}
