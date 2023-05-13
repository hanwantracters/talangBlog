package com.itheima.dao;

import com.itheima.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Comment)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-12 20:19:27
 */
public interface CommentDao
{
    @Select("select comment_id AS commentId,\n" +
            "       comment_username AS commentUsername,\n" +
            "       comment_article_id AS commentArticleId,\n" +
            "       comment_content AS commentContent,\n" +
            "       comment_create_time AS commentCreateTime from comment where comment_article_id=#{commentArticleId}")
    List<Comment>getAllByArtId(int commentArticleId);
    @Insert("insert comment(comment_id, comment_username, comment_article_id, comment_content, comment_create_time) values(#{commentId},#{commentUsername},#{commentArticleId},#{commentContent},#{commentCreateTime})")
    boolean save(Comment comment);
}

