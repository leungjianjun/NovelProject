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

    private int id;

    private String name;

    private String introduction;

    private Calendar createDate;

    private List<Volume> volumes;

    private Category category;

    private List<Tag> tags;


}
