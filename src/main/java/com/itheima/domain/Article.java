package com.itheima.domain;

import java.io.Serializable;

/**
 * (Article)实体类
 *
 * @author makejava
 * @since 2023-05-11 13:41:03
 */
public class Article implements Serializable {
    private static final long serialVersionUID = -57690329786295356L;
    /**
     * 文章ID
     */

    private Integer articleId;
    private String username;
    private String articleTitle;
    private String articleContent;

    public Integer getArticleId()
    {
        return articleId;
    }

    public String getUsername()
    {
        return username;
    }

    public String getArticleTitle()
    {
        return articleTitle;
    }

    public String getArticleContent()
    {
        return articleContent;
    }

    public void setArticleId(Integer articleId)
    {
        this.articleId = articleId;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setArticleTitle(String articleTitle)
    {
        this.articleTitle = articleTitle;
    }

    public void setArticleContent(String articleContent)
    {
        this.articleContent = articleContent;
    }
}

