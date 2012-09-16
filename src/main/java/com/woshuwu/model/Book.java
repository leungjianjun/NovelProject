package com.woshuwu.model;

import java.util.Calendar;
import java.util.List;

/**
 * 书
 * Author: ljj
 * Date: 12-9-12
 * Time: 下午11:33
 */
public class Book {

    /**
     * primary id,auto increment
     */
    private long id;

    /**
     * varchar max(200)
     */
    private String name;

    /**
     * text
     */
    private String introduction;

    /**
     * the time and date when the book is created
     *
     * datetime
     */
    private Calendar createTime;

    /**
     * the time and date when the book is updated,usually the chapter
     *
     *  datetime
     */
    private Calendar updateTime;

    /**
     * the book contents many volumes
     * @relationship one-to-many
     */
    private List<Volume> volumes;

    /**
     * the category of the book
     * @relationship many-to-one
     */
    private Category category;

    /**
     * the tags which the book contains
     * @relationship many-to-many
     */
    private List<Tag> tags;

    /**
     * the status of the book,like finish,to be continue
     */
    private BookStatus bookStatus;

    //==================== setter and getter method ================

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

    public Calendar getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Calendar updateTime) {
        this.updateTime = updateTime;
    }

    public List<Volume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
