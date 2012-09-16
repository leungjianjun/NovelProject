package com.woshuwu.model;

/**
 * 标签,一本书可以有多个标签,每个标签可以被多个书引用
 * Author: ljj
 * Date: 12-9-12
 * Time: 下午11:45
 */
public class Tag {

    /**
     * primary key, auto increment
     */
    private long id;

    /**
     * varchar max(10)
     */
    private String name;

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
}
