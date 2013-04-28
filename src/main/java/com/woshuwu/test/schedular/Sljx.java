package com.woshuwu.test.schedular;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.util.ArrayList;
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

    List<String> htmlList = new ArrayList<String>();

    private void ifPrint(String html){
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
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            /*doc = Jsoup.connect("http://www.njsljy.com:8080/Main.aspx")
                    .cookie("ASP.NET_SessionId", "c02lgqncj0trh3qdvckrtg4c").timeout(600000).get();
            ifPrint(doc.html());
            doc = Jsoup.connect("http://www.njsljy.com:8080/TouchAppoint/JiaoLianPinJia.aspx")
                    .cookie("ASP.NET_SessionId", "c02lgqncj0trh3qdvckrtg4c").timeout(600000).get();
            ifPrint(doc.html());*/
            Document doc = Jsoup.connect("http://www.njsljy.com:8080/TouchAppoint/Appoint_Exec.aspx")
                    .cookie("ASP.NET_SessionId", "c02lgqncj0trh3qdvckrtg4c").timeout(600000).get();
            ifPrint(doc.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws JobExecutionException {
        Sljx sljx = new Sljx();
        sljx.execute(null);
    }
}
