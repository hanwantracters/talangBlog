package com.itheima.controller;

import com.itheima.domain.Article;
import com.itheima.service.ArticleService;
import com.itheima.util.GetByIdAndComment;
import com.itheima.util.GetByIdAndUpdate;
import com.itheima.util.IdentifyBroadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Article)表控制层
 *
 * @author makejava
 * @since 2023-05-11 12:27:38
 */
@RestController
@RequestMapping("/articles")
public class ArticleController
{
    @Autowired
    private ArticleService articleService;
    @PostMapping
    public Result save(@RequestBody Article article)
    {
        article.setUsername(IdentifyBroadcast.GetIdentifyBroadcast());
        boolean flag=articleService.save(article);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,null,"发布成功");
    }
    @GetMapping
    public Result GetAll()
    {
        List<Article> allArticles = articleService.GetAll();
        return new Result(Code.GET_OK,allArticles,"获取所有文章成功");
    }
    @GetMapping({"/GetByIdForComment/{articleId}","/GetByIdForComment/"})
    public Result GetByIdForComment(@PathVariable(required = false) Integer articleId)
    {
        Article article;
        if(articleId!=null
        )
        {
            article = articleService.getById(articleId);
            GetByIdAndUpdate.articleId=articleId;
        }
        else
        {
            article = articleService.getById(GetByIdAndUpdate.articleId);
        }
        GetByIdAndComment.articleId=article.getArticleId();
        GetByIdAndComment.username=article.getUsername();
        return new Result(Code.GET_OK,article,"获取文章成功");
    }
    @GetMapping({"/GetByIdForUpdate/{articleId}"})
    public Result GetByIdForUpdate(@PathVariable Integer articleId)
    {
        Article article = articleService.getById(articleId);
        GetByIdAndUpdate.articleId=articleId;
        GetByIdAndUpdate.username=article.getUsername();
        return new Result(Code.GET_OK,article,"获取文章成功");
    }


    @DeleteMapping("/{articleId}")
    public Result DeleteById(@PathVariable Integer articleId)
    {
        boolean flag = articleService.deleteById(articleId);
        if (flag)
        {
            return new Result(Code.DELETE_OK,null,"删除成功");
        }
        else
        {
            return new Result(Code.DELETE_ERR,null,"删除失败,该文章不存在");
        }

    }
    @PostMapping("/update")
    public Result UpdateById(@RequestBody Article article)
    {
        article.setArticleId(GetByIdAndUpdate.articleId);
        article.setUsername(GetByIdAndUpdate.username);
        articleService.updateById(article);
        return new Result(Code.UPDATE_OK,null,"更新成功");
    }

}

