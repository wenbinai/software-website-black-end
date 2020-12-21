package edu.nefu.softwarewebsite.controller.admin;

import edu.nefu.softwarewebsite.pojo.Article;
import edu.nefu.softwarewebsite.service.ArticleService;
import edu.nefu.softwarewebsite.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/article")
public class ArticleAdminApi {
    @Autowired
    private ArticleService articleService;

    /**
     * 通过文章Id获取文章
     *
     * @return
     */
    @GetMapping("/{articleId}")
    public ResponseResult getArticle(@PathVariable("articleId") String articleId) {
        return articleService.getArticle(articleId);
    }

    /**
     * 发布文章
     * 需要管理员权限
     *
     * @return
     */
    @PreAuthorize("@permission.adminPermission()")
    @PostMapping
    public ResponseResult postArticle(@RequestBody Article article) {
        return articleService.postArticle(article);
    }

    /**
     * 删除文章
     * 需要管理员权限
     *
     * @param articleId
     * @return
     */
    @PreAuthorize("@permission.adminPermission()")
    @DeleteMapping("/{articleId}")
    public ResponseResult deleteArticle(@PathVariable("articleId") String articleId) {
        return articleService.deleteArticle(articleId);
    }

    /**
     * 返回所有文章列表
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listArticle() {
        return articleService.listArticle();
    }


}
