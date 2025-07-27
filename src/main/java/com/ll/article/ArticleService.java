package com.ll.article;

import com.ll.Session;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public int create(String subject, String content) {
        int memberId = Session.getLoggedInMember().getId(); // ✅ 로그인된 사용자 ID
        return articleRepository.create(subject, content, memberId);
    }


    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(int id) {
        return articleRepository.findById(id);
    }

    public void remove(Article article) {
        articleRepository.remove(article);
    }

    public void modify(Article article, String modifySubject, String modifyContent) {
        articleRepository.modify(article, modifySubject, modifyContent);
    }
}
