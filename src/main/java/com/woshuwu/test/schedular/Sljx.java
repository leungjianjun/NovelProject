package com.woshuwu.test.schedular;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jianjun_liang
 * Date: 13-4-25
 * Time: 下午2:04
 * To change this template use File | Settings | File Templates.
 */
public class Sljx implements Job {

    private void ifPrint(String html,List<String> htmlList){
        for (String temp : htmlList){
            if (temp.equals(html)){
                return;
            }
        }
        htmlList.add(html);
        System.out.println(htmlList.size()+" "+new Date());
        System.out.println(html);
    }
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        appointment("bq10h5i002xwadnvcopr0koh",(List<String>)context.getJobDetail().getJobDataMap().get("htmlList"));
    }

    private void appointment(String session,List<String> htmlList){
        try {
            /*doc = Jsoup.connect("http://www.njsljy.com:8080/Main.aspx")
                    .cookie("ASP.NET_SessionId", "c02lgqncj0trh3qdvckrtg4c").timeout(600000).get();
            ifPrint(doc.html());
            doc = Jsoup.connect("http://www.njsljy.com:8080/TouchAppoint/JiaoLianPinJia.aspx")
                    .cookie("ASP.NET_SessionId", "c02lgqncj0trh3qdvckrtg4c").timeout(600000).get();
            ifPrint(doc.html());*/

            Calendar calendar=Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+8);//让日期加8
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DecimalFormat format=new DecimalFormat("00");

            Document doc = Jsoup.connect("http://www.njsljy.com:8080/TouchAppoint/Appoint_Exec.aspx")
                    .cookie("ASP.NET_SessionId", session).timeout(600000).get();
            ifPrint(doc.html(),htmlList);
            System.out.println("http://www.njsljy.com:8080/TouchAppoint/Appoint_Exec_Do.aspx?rq="
                    +year+"年"+format.format(month)+"月"+format.format(day)+"日&timesetp=08:00-11:00");
            doc = Jsoup.connect("http://www.njsljy.com:8080/TouchAppoint/Appoint_Exec_Do.aspx?rq="
                    +year+"年"+format.format(month)+"月"+format.format(day)+"日&timesetp=08:00-11:00")
                    .cookie("ASP.NET_SessionId", session).timeout(600000).get();
            ifPrint(doc.html(),htmlList);
            doc = Jsoup.connect("http://www.njsljy.com:8080/TouchAppoint/Appoint_Exec_Do.aspx?rq="
                    +year+"年"+format.format(month)+"月"+format.format(day)+"日&timesetp=11:00-14:00")
                    .cookie("ASP.NET_SessionId", session).timeout(600000).get();
            ifPrint(doc.html(),htmlList);
            doc = Jsoup.connect("http://www.njsljy.com:8080/TouchAppoint/Appoint_Exec_Do.aspx?rq="
                    +year+"年"+format.format(month)+"月"+format.format(day)+"日&timesetp=14:00-17:00")
                    .cookie("ASP.NET_SessionId", session).timeout(600000).get();
            ifPrint(doc.html(),htmlList);
            doc = Jsoup.connect("http://www.njsljy.com:8080/TouchAppoint/Appoint_Exec_Do.aspx?rq="
                    +year+"年"+format.format(month)+"月"+format.format(day)+"日&timesetp=17:00-19:00")
                    .cookie("ASP.NET_SessionId", session).timeout(600000).get();
            ifPrint(doc.html(),htmlList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws JobExecutionException {
        //Sljx sljx = new Sljx();
        //sljx.execute(null);
    }
}
