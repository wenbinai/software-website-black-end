package edu.nefu.softwarewebsite.service;


import edu.nefu.softwarewebsite.pojo.Article;
import edu.nefu.softwarewebsite.util.ResponseResult;

public interface ArticleService {
    ResponseResult getArticle(String articleId);

    ResponseResult postArticle(Article article);

    ResponseResult deleteArticle(String articleId);

    ResponseResult listArticle();
}
