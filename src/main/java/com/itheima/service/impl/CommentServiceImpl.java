package com.itheima.service.impl;

import com.itheima.dao.CommentDao;
import com.itheima.domain.Comment;
import com.itheima.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2023-05-12 20:19:29
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService
{

    @Autowired
    private CommentDao commentDao;
    public List<Comment> getAllByArtId(int commentArticleId)
    {
        return commentDao.getAllByArtId(commentArticleId);
    }

    public boolean save(Comment comment)
    {
        return commentDao.save(comment);
    }
}
