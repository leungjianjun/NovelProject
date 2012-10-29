package com.woshuwu.dao;

import com.woshuwu.model.Book;
import com.woshuwu.model.Volume;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-22
 * Time: 下午10:55
 */
public interface BookDao {

    public Book queryBookById(long id);

    public List<Volume> queryBookContentById(long id);
}
