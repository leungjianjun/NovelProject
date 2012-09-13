package com.woshuwu.model;

import java.util.Calendar;

/**
 * 章节类
 * Author: ljj
 * Date: 12-9-12
 */
public class Chapter {

    /**
     * primary key,auto increment
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
}
