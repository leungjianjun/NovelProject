package com.woshuwu.model;

import java.util.Calendar;

/**
 * 作者
 * Author: ljj
 * Date: 12-9-12
 * Time: 下午11:53
 */
public class Author extends User {

    /**
     * Personal real name in ID

     * varchar max(20)
     */
    private String realName;

    /**
     * Identify Card Number
     * varchar max(30)
     */
    private String idCard;

    /**
     * int
     */
    private AuthorType authorType;

    /**
     * the time when the author is authorized
     * datetime
     */
    private Calendar createDate;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public AuthorType getAuthorType() {
        return authorType;
    }

    public void setAuthorType(AuthorType authorType) {
        this.authorType = authorType;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

}
