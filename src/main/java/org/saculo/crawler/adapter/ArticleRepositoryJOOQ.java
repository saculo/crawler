package org.saculo.crawler.adapter;

import io.vavr.control.Option;
import org.jooq.DSLContext;
import org.saculo.crawler.domain.Article;
import org.saculo.crawler.domain.port.ArticleRepository;
import org.saculo.crawler.infrastructure.JOOQDriver;

import java.util.UUID;

public class ArticleRepositoryJOOQ implements ArticleRepository {
    private final DSLContext dsl = JOOQDriver.createContext();

    @Override
    public Option<Article> findById (final UUID id) {
        return null;
    }

    @Override
    public Option<Article> findByTitle (final String title) {
        return null;
    }

    @Override
    public Article save (final Article article) {
        return null;
    }
}
