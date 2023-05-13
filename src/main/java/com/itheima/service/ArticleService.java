package com.itheima.service;

import com.itheima.domain.Article;

import java.util.List;


public interface ArticleService
{

    public boolean save(Article article);
    public List<Article> GetAll();
    public Article getById(Integer articleId);
    public boolean updateById(Article article);
    public boolean deleteById(Integer articleId);


}
