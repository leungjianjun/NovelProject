package com.woshuwu.test.schedular;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 13-2-24
 * Time: 下午12:58
 */
public class CnbetaCrawler implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("run jobs");
        Map<String,String> articleList = (Map<String, String>) context.getJobDetail().getJobDataMap().get("ArticleList");
        try {
            Document doc = Jsoup.connect("http://cnbeta.feedsportal.com/c/34306/f/624776/index.rss").get();
            for(Element e:doc.select("item")){
                String link = e.select("guid").first().text();
                if(!articleList.containsKey(link)){
                    System.out.println("Add article: "+link);
                    doc = Jsoup.connect(link).get();
                    String content = doc.select("#news_content").html();
                    articleList.put(link,content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        CnbetaCrawler cc = new CnbetaCrawler();
        cc.execute(null);
    }
}
