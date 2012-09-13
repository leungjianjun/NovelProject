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


}
