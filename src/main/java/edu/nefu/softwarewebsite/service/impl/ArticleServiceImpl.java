package edu.nefu.softwarewebsite.service.impl;

import edu.nefu.softwarewebsite.dao.ArticleDao;
import edu.nefu.softwarewebsite.pojo.Article;
import edu.nefu.softwarewebsite.service.ArticleService;
import edu.nefu.softwarewebsite.util.Constants;
import edu.nefu.softwarewebsite.util.ResponseResult;
import edu.nefu.softwarewebsite.util.SnowflakeIdWorker;
import edu.nefu.softwarewebsite.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private SnowflakeIdWorker idWorker;

    @Override
    public ResponseResult getArticle(String articleId) {
        if (articleId == null) {
            return ResponseResult.failResponse()
                    .setMessage("文章Id不存在");
        }
        Article article = articleDao.findOneById(articleId);
        if (article == null) {
            return ResponseResult.failResponse()
                    .setMessage("文章不存在");
        }
        return ResponseResult.successResponse()
                .setData(article);
    }

    @Override
    public ResponseResult postArticle(Article article) {
        // 检验各种参数
        if (TextUtil.isEmpty(article.getArticleTitle())) {
            return ResponseResult.failResponse()
                    .setMessage("文章标题不能为空");
        }

        if (TextUtil.isEmpty(article.getArticleContent())) {
            return ResponseResult.failResponse()
                    .setMessage("文章内容不能为空");
        }

        if (TextUtil.isEmpty(article.getArticleCategory())) {
            return ResponseResult.failResponse()
                    .setMessage("文章分类不能为空");
        }
        // 补全数据
        //id
        String id = idWorker.nextId() + "";
        System.out.println("id-->" + id);
        article.setId(id);
        // 创建时间
        article.setCreateTime(new Date());
        // 更新时间
        article.setUpdateTime(new Date());
        // TODO 修改用户id
        article.setUserId("admin");
        // 文章类型
        article.setType(Constants.Article.PUBLISH);
        // 保存在数据库中
        articleDao.save(article);
        return ResponseResult.successResponse()
                .setMessage("发布文章成功");
    }

    @Override
    public ResponseResult deleteArticle(String articleId) {
        // 检验参数
        if (articleId == null) {
            return ResponseResult.failResponse()
                    .setMessage("文章Id不存在");
        }
        Article article = articleDao.findOneById(articleId);
        if (article == null) {
            return ResponseResult.failResponse()
                    .setMessage("文章不存在");
        }

        // 删除文章
        try {
            articleDao.deleteById(articleId);
            return ResponseResult.successResponse()
                    .setMessage("删除文章成功");
        } catch (Exception e) {
            return ResponseResult.failResponse()
                    .setMessage("删除文章失败");
        }
    }

    @Override
    public ResponseResult listArticle() {
        List<Article> all = new ArrayList<>();
        try {
            all = articleDao.findAll();
        } catch (Exception e) {
            return ResponseResult.failResponse()
                    .setMessage("获取所有文章失败");
        }
        return ResponseResult.successResponse()
                .setMessage("获取所有文章成功")
                .setData(all);
    }
}
