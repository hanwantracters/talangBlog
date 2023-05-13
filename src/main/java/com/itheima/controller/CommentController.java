package com.itheima.controller;

import com.itheima.domain.Comment;
import com.itheima.service.CommentService;
import com.itheima.util.GetByIdAndComment;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * (Comment)表控制层
 *
 * @author makejava
 * @since 2023-05-12 20:19:27
 */
@RestController
@RequestMapping("/comments")
public class CommentController
{
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;
    @GetMapping
    public Result getAll(Integer ArticleId)
    {
        ArticleId= GetByIdAndComment.articleId;
        return new Result(Code.GET_OK,commentService.getAllByArtId(ArticleId),"获取所有评论成功");
    }
    @PostMapping
    public Result save(@RequestBody Comment comment)
    {
        comment.setCommentArticleId(GetByIdAndComment.articleId);
        comment.setCommentUsername(GetByIdAndComment.username);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2023-05-12 20:55:05
        Date date = new Date(System.currentTimeMillis());
        comment.setCommentCreateTime(date);
        boolean flag=commentService.save(comment);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,null,"发布成功");
    }
}

