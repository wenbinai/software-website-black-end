package edu.nefu.softwarewebsite.dao;

import edu.nefu.softwarewebsite.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article, String> {

    Article findOneById(String articleId);
}
