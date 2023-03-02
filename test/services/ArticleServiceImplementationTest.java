package services;

import data.models.Article;
import dto.request.CreateArticleRequest;
import dto.request.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleServiceImplementationTest {
    ArticleServices articleService;
    UserServices userService;
    Article savedArticle;
    CreateArticleRequest createArticleRequest;
    @BeforeEach
    public void setUp(){
        articleService = new ArticleServiceImplementation();
        CreateArticleRequest createArticleRequest = new CreateArticleRequest();
        createArticleRequest.setBody("My Body");
        createArticleRequest.setTitle("My Title");
        createArticleRequest.setAuthorId(1);
        userService = new UserServiceImplementation();
    }

    @Test
    public void saveNewArticle_NoOfArticleIsOneTest(){
        articleService = new ArticleServiceImplementation();
        RegisterRequest request = new RegisterRequest();
        userService.register(request);
        savedArticle = articleService.createNewArticle(createArticleRequest);
        assertEquals(1, articleService.count());
    }

    @Test
    public void shouldThrowException_ifAuthorIdIsInvalid(){
        CreateArticleRequest createArticleRequest = new CreateArticleRequest();
        createArticleRequest.setBody("Body");
        createArticleRequest.setTitle("Title");
        createArticleRequest.setAuthorId(1);
        try {
            articleService.createNewArticle(createArticleRequest);
        }catch (IllegalArgumentException ex){
            assertEquals("Author with id 1 does not exist", ex.getMessage());
        }
    }

}