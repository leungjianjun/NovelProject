package com.woshuwu.model;

import java.util.Calendar;

/**
 * 章节类
 * Author: ljj
 * Date: 12-9-12
 */
public class Chapter {

    //========== model field to be persisted =============

    /**
     * primary key,auto increment
     * 文章顺序根据章节id排序
     */
    private long id;

    /**
     * 文章标题
     * varchar max(200)
     */
    private String title;

    /**
     * 文章内容
     * mediumText
     */
    private String content;

    /**
     * 更新日期
     * datetime
     */
    private Calendar updateTime;

    //======= define chapter status enum ========

    enum ChapterStatus {

    }

    //===============  util method ================
    public String updateTime4Display(){
        return updateTime.get(Calendar.YEAR)+"-"+updateTime.get(Calendar.MONTH)+
                "-"+updateTime.get(Calendar.DATE)+" "+updateTime.get(Calendar.HOUR_OF_DAY)+":"+
                updateTime.get(Calendar.MINUTE)+":"+updateTime.get(Calendar.SECOND);

    }


    //============= setter and getter method =======

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Calendar updateTime) {
        this.updateTime = updateTime;
    }
}
