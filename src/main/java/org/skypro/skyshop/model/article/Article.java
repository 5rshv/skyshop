package org.skypro.skyshop.model.article;


import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class Article implements Searchable {
    private String article;
    private String articleText;
    private final UUID id;

    public Article(String article, String articleText, UUID id) {
        this.article = article;
        this.articleText = articleText;
        this.id = id;
    }

    @Override
    public String toString() {
        return article + '\n' + articleText;
    }

    @Override
    public String getSearchTerm() {
        return this + " " + getTypeContent();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return article + "\n" + getTypeContent();
    }

    public String getArticle() {
        return article;
    }

    public String getArticleText() {
        return articleText;
    }
}
