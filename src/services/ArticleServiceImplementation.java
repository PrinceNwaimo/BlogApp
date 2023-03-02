package services;

import data.models.Article;
import data.repository.ArticleRepository;
import data.repository.ArticleRepositoryImplementation;
import dto.request.CreateArticleRequest;
import utils.Mapper;

public class ArticleServiceImplementation implements ArticleServices {
    ArticleRepository articleRepository = new ArticleRepositoryImplementation();
    UserServices userService = new UserServiceImplementation();

    @Override
    public Article createNewArticle(CreateArticleRequest createArticleRequest) {
        try {
            var foundUser = userService.findUser(createArticleRequest.getAuthorID());
        } catch (NullPointerException ex) {
            throw new IllegalArgumentException(String.format("Author with id %s does not exist", createArticleRequest.getAuthorID()));
        }
        Article article = new Article();
        Mapper.map(createArticleRequest, article);
        return articleRepository.save(article);
    }

    @Override
    public Article findPost(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public long count() {
        return articleRepository.count();


    }
}