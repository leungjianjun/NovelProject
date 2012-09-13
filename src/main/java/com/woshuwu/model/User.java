package com.woshuwu.model;

import java.util.Calendar;

/**
 * 注册用户
 * Author: ljj
 * Date: 12-8-28
 * Time: 下午6:51
 */
public class User {

    private  long id;

    /**
     * user's nick name, can repeat in database
     * varchar max(50)
     */
    private String nicename;

    /**
     * varchar max(50),unique
     */
    private String account;

    private Calendar createTime;

    private String email;

    private String mobile;

    public String getNicename() {
        return nicename;
    }

    public void setNicename(String nicename) {
        this.nicename = nicename;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
