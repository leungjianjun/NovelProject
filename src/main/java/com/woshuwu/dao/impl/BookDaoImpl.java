package com.woshuwu.dao.impl;

import com.woshuwu.dao.BookDao;
import com.woshuwu.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-22
 * Time: 下午10:56
 */
@Repository
public class BookDaoImpl extends JdbcDaoSupport implements BookDao {

    @Autowired
    public BookDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Book queryBookById(long id) {
        Book book = (Book)this.getJdbcTemplate().queryForObject(
                "SELECT * FROM book WHERE id = ?",
                new Object[]{id},
                new RowMapper(){

                    @Override
                    public Object mapRow(ResultSet rs, int i) throws SQLException {
                        Book book = new Book();
                        book.setBookStatus(BookStatus.values()[rs.getInt("book_status")]);
                        Category category = new Category();
                        category.setId(rs.getInt("category_id"));
                        book.setCategory(category);
                        Calendar createTime = Calendar.getInstance();
                        createTime.setTime(rs.getTimestamp("create_time"));
                        book.setCreateTime(createTime);
                        book.setId(rs.getLong("id"));
                        book.setIntroduction(rs.getString("introduction"));
                        book.setName(rs.getString("name"));
                        Calendar updateTime = Calendar.getInstance();
                        updateTime.setTime(rs.getTimestamp("update_time"));
                        book.setUpdateTime(updateTime);
                        return book;
                    }

                });
        return book;
    }

    @Override
    public List<Volume> queryBookContentById(long bookId) {
        List<Volume> volumes =  this.getJdbcTemplate().query("SELECT * FROM volume WHERE book_id = ?",
                new Object[]{bookId},
                new RowMapper<Volume>(){
                    @Override
                    public Volume mapRow(ResultSet rs, int i) throws SQLException {
                        Volume volume = new Volume();
                        Calendar createTime = Calendar.getInstance();
                        createTime.setTime(rs.getTimestamp("create_time"));
                        volume.setCreateTime(createTime);
                        volume.setId(rs.getLong("id"));
                        volume.setIntroduction(rs.getString("introduction"));
                        volume.setName(rs.getString("name"));
                        return volume;
                    }
                });
        for(Volume volume:volumes){
            volume.setChapters(queryChapterByVolumeId(volume.getId()));
        }
        return volumes;
    }

    private List<Chapter> queryChapterByVolumeId(long volumeId){
        return this.getJdbcTemplate().query("SELECT id,title FROM chapter WHERE volume_id = ?",
                new Object[]{volumeId},
                new RowMapper<Chapter>() {
                    @Override
                    public Chapter mapRow(ResultSet rs, int i) throws SQLException {
                        Chapter chapter = new Chapter();
                        chapter.setId(rs.getLong("id"));
                        chapter.setTitle(rs.getString("title"));
                        return chapter;
                    }
                });
    }
}
