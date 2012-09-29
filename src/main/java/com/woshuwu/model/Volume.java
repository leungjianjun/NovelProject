package com.woshuwu.model;

import java.util.Calendar;
import java.util.List;

/**
 * 卷.
 * Author: ljj
 * Date: 12-9-12
 * Time: 下午8:43
 */
public class Volume {

    /**
     *  primary key, auto increment
     *  卷根据id排序
     */
    private long id;

    /**
     * varchar max(200)
     */
    private String name;

    /**
     *  text
     */
    private String introduction;

    private Calendar createTime;

    private List<Chapter> chapters;

    //==========setter and getter method

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
