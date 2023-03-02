package africa.semicolon.yarnMeBlog.services;

import africa.semicolon.yarnMeBlog.data.models.Article;
import africa.semicolon.yarnMeBlog.dto.request.CreateArticleRequest;

public interface ArticleServices {
        Article createNewArticle(CreateArticleRequest createArticleRequest);
        Article findPost(int id);
        long count();
}
