package africa.semicolon.yarnMeBlog.data.repository;

import africa.semicolon.yarnMeBlog.data.models.Article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryImplementationTest {
    private ArticleRepository articleRepository;
    private Article article;

    @BeforeEach
    public void setup() {
        articleRepository = new ArticleRepositoryImplementation();
        article = new Article();
        article.setId(1);
        article.setAuthorID(1);
        article.setBody("Flame");
        article.setTitle("Fire");
        article.setTimeCreated(LocalDateTime.now());

    }

    @Test
    public void saveArticleTest() {
        Article article = new Article();
        articleRepository.save(article);
        assertEquals(1, articleRepository.count());

    }

    @Test
    public void saveOneArticle_findArticleById() {
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
        Article foundArticle = articleRepository.findById(1);
        assertEquals(foundArticle, savedArticle);

    }
    @Test
    public void deleteArticlesByIDTest(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1,articleRepository.count());
        articleRepository.delete(1);
        assertEquals(0,articleRepository.count());
    }
    @Test
    public void deleteArticleTest(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1,articleRepository.count());
        articleRepository.delete(article);
        assertEquals(0,articleRepository.count());

    }
    @Test
    public void findAllArticles(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1,articleRepository.count());
        articleRepository.findAll();
        assertEquals(1,articleRepository.count());
    }
    @Test
    public void deleteAllArticles(){
        Article savedArticle = articleRepository.save(article);
        savedArticle = articleRepository.save(article);
        savedArticle = articleRepository.save(article);
        assertEquals(3,articleRepository.count());
        articleRepository.deleteAll();
        assertEquals(0,articleRepository.count());

    }
}