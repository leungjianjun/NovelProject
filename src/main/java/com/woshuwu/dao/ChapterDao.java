package com.woshuwu.dao;

import com.woshuwu.model.Book;
import com.woshuwu.model.Chapter;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-9-14
 * Time: 下午11:43
 */
public interface ChapterDao {

    /**
     * 查过ID查询章节
     * @param id
     * @return
     */
    public Chapter queryChapterById(long id);

    /**
     * 获取当前章节ID的上一个章节ID
     * @param id
     * @return 返回上一章的id，如果没有就返回-1
     */
    public long getPreviousChapterIdById(long id);

    /**
     * 获取当前章节ID的下一章节ID
     * @param id
     * @return 下一章的id。如果没有就返回-1
     */
    public long getNextChapterIdById(long id);
}
