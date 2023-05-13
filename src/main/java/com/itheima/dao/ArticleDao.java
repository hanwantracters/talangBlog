package com.itheima.dao;

import com.itheima.domain.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-11 13:41:01
 */
public interface ArticleDao
{
    @Insert("insert into article (username,article_title,article_content) values(#{username},#{articleTitle},#{articleContent})")
    public boolean save(Article article);
    @Select("select article_id AS articleId,\n" +
            "       username AS username,\n" +
            "       article_title AS articleTitle from article order by article_id desc")
    public List<Article> getAll();
    @Select("select article_id AS articleId,\n" +
            "       username AS username,\n" +
            "       article_title AS articleTitle,\n" +
            "       article_content AS articleContent from article where article_id=#{articleId}")
    public Article getById(Integer articleId);
    @Update("update article set article_title=#{articleTitle},article_content=#{articleContent} where article_id=#{articleId}")
    public boolean updateById(Article article);
    @Delete("delete from article where article_id=#{articleId}")
    boolean deleteById(Integer articleId);



}

