package com.ll.article;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.ll.Util.escape;

public class ArticleRepository {
    int lastId = 1;

    public int create(String subject, String content, int memberId) {
        String sql = String.format(
                "INSERT INTO article SET subject='%s', content='%s', memberId=%d, created_date=NOW(), modified_date=NOW()",
                escape(subject), escape(content), memberId
        );
        return Container.getDBConnection().insert(sql);
    }


    public List<Article> findAll() {
        List<Article> articleList = new ArrayList<>();

        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from article");

        for ( Map<String, Object> row : rows ) {
            Article article = new Article(row);

            articleList.add(article);
        }

        return articleList;
    }

    public Article findById(int id) {
        List<Article> articleList = this.findAll();

        for (Article item : articleList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void remove(Article article) {
        String sql = String.format("DELETE FROM article where id = %d", article.getId());
        Container.getDBConnection().delete(sql);
    }

    public void modify(Article article, String modifySubject, String modifyContent) {
        String sql = String.format("update article set subject='%s', content='%s' where id = %d", modifySubject, modifyContent, article.getId());
        Container.getDBConnection().update(sql);
    }
}
