package com.woshuwu.model;

/**
 * 分类，分类包括多级分类，也就是有子分类。一级分类（跟目录）8位，二级分类16位，最多四级，也就是32位，更好是int。
 * 一级目录的第一个0x0000 0001 0000 0000 0000 0000 0000 0000，二级目录第一个0x0000 0001 0000 0001 0000 0000 0000 0000
 * Author: ljj
 * Date: 12-9-12
 * Time: 下午11:38
 */
public class Category {

    private long id;

    /**
     * varchar max(20)
     */
    private String name;
}
