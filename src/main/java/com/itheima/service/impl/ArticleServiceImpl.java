package com.itheima.service.impl;

import com.itheima.controller.Code;
import com.itheima.dao.ArticleDao;
import com.itheima.domain.Article;
import com.itheima.exception.BusinessException;
import com.itheima.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Article)表服务实现类
 *
 * @author makejava
 * @since 2023-05-11 13:41:12
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService
{

    @Autowired
    private ArticleDao articleDao;
    public boolean save(Article article)
    {

        try
        {
            boolean flag = articleDao.save(article);
            return flag;
        }
        catch (Exception e)
        {
            throw new BusinessException(Code.BUSINESS_ERR, "标题或者文章内容大小超过限制");
        }
    }

    public List<Article> GetAll()
    {
        List<Article> allArtical = articleDao.getAll();
        return allArtical;
    }

    public Article getById(Integer articleId)
    {
        Article article = articleDao.getById(articleId);
        return article;
    }

    public boolean updateById(Article article)
    {
        boolean flag = articleDao.updateById(article);
        return flag;
    }

    public boolean deleteById(Integer articleId)
    {
            boolean flag = articleDao.deleteById(articleId);
            return flag;
    }
}
