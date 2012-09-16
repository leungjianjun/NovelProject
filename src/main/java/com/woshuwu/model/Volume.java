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
    private int id;

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
}
