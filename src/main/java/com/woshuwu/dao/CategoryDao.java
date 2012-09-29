package com.woshuwu.dao;

import com.woshuwu.model.Category;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-23
 * Time: 上午12:30
 */
public interface CategoryDao {
    public Category queryCategoryById(long id);
}
