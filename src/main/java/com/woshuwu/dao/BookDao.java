package com.woshuwu.dao;

import com.woshuwu.model.Book;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-22
 * Time: 下午10:55
 */
public interface BookDao {

    public Book queryBookById(long id);
}
