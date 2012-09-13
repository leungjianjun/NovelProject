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
     */
    private int id;

    /**
     * varchar max(200)
     */
    private String name;

    /**
     *  text
     */
    private String introduction;

    private int sortOrder;

    private Calendar createTime;

    private List<Chapter> chapters;
}
