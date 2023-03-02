package africa.semicolon.yarnMeBlog.data.repository;

import africa.semicolon.yarnMeBlog.data.models.Article;


import java.util.List;

public interface ArticleRepository {
    Article save(Article article);

    Article findById(int id);

    long count();

    List<Article> findAll();

    void delete(Article article);

    void delete(int id);

    void deleteAll();
}
