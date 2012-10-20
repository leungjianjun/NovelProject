package com.woshuwu.dao.impl;

import com.woshuwu.dao.CategoryDao;
import com.woshuwu.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-23
 * Time: 上午12:31
 */
@Repository
public class CategoryDaoImpl extends JdbcDaoSupport implements CategoryDao {

    @Autowired
    public CategoryDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Category queryCategoryById(long id) {
        Category category = _queryCategoryById(id);
        long[] ids = category.getParentCategoryIds();
        Category[] parentCategories = new Category[ids.length];
        for(int i = 0; i < ids.length; i++){
            parentCategories[i] = _queryCategoryById(ids[i]);
        }
        category.setParentCategories(parentCategories);
        return category;
    }

    private Category _queryCategoryById(long id){
        Category category = (Category)this.getJdbcTemplate().queryForObject(
                "SELECT * FROM category WHERE id = ?",
                new Object[]{id},
                new RowMapper(){

                    @Override
                    public Object mapRow(ResultSet rs, int i) throws SQLException {
                        Category category = new Category();
                        category.setId(rs.getLong("id"));
                        category.setName(rs.getString("name"));
                        return category;
                    }

                });
        return category;
    }
}
