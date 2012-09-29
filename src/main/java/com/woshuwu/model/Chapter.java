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

    private ChapterStatus chapterStatus;

    /**
     * 章节所属于的卷
     */
    private Volume volume;

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

    public ChapterStatus getChapterStatus() {
        return chapterStatus;
    }

    public void setChapterStatus(ChapterStatus chapterStatus) {
        this.chapterStatus = chapterStatus;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }
}
