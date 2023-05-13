package com.itheima.service;

import com.itheima.domain.Comment;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2023-05-12 20:19:29
 */
public interface CommentService
{
    List<Comment>getAllByArtId(int commentArticleId);
    boolean save(Comment comment);

}
