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

    public Chapter queryChapterById(long id);
}
