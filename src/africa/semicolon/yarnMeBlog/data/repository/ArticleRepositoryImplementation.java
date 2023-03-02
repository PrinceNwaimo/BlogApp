package africa.semicolon.yarnMeBlog.data.repository;

import africa.semicolon.yarnMeBlog.data.models.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImplementation implements ArticleRepository{
    private List<Article>articles = new ArrayList<>();
    private int count;
    @Override
    public Article save(Article article) {
        boolean articleHasNotBeenSaved = article.getId() == 0;
        if (articleHasNotBeenSaved) saveNew(article);
        article.setId(generateArticleId());
        articles.add(article);
        count++;

        return article;
    }
    private void saveNew(Article article){
        article.setId(generateArticleId());
        articles.add(article);
    }

    private int generateArticleId() {
        return count + 1;
    }

    @Override
    public Article findById(int id) {
        for (Article article : articles)
            if (article.getId() == id) return article;
        return null;

    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public void delete(Article article) {
        for (Article article1 : articles) {
            articles.remove(article);
            count--;
            break;

        }
    }

        @Override
        public void delete ( int id){
            for (Article article : articles) {
                if (article.getId() == id) {
                    articles.remove(article);
                    count--;
                    break;
                }
            }
        }



    @Override
    public void deleteAll() {
        articles.clear();
        count = 0;
    }
}
