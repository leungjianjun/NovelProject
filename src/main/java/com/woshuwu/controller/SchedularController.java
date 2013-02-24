package com.woshuwu.controller;

import com.woshuwu.test.schedular.WebSchedular;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 13-2-24
 * Time: 下午10:54
 */
@Controller
@RequestMapping(value = "/schedular")
public class SchedularController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home(ModelMap model){
        Scheduler scheduler = WebSchedular.getSchedular();
        List<JobKey> jobKeys = new ArrayList<JobKey>();
        try {
            for (String groupName : scheduler.getJobGroupNames()) {
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                    jobKeys.add(jobKey);
                    //String jobName = jobKey.getName();
                    //String jobGroup = jobKey.getGroup();
                    //get job's trigger
                    //List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                    //Date nextFireTime = triggers.get(0).getNextFireTime();
                }

            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        model.addAttribute("jobKeys", jobKeys);
        return "schedular";
    }
}
