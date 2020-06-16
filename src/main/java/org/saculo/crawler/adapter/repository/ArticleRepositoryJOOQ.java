package org.saculo.crawler.adapter.repository;

import io.vavr.control.Option;
import org.jooq.DSLContext;
import org.saculo.crawler.domain.Article;
import org.saculo.crawler.domain.port.ArticleRepository;
import org.saculo.crawler.infrastructure.JOOQDriver;

import java.util.UUID;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class ArticleRepositoryJOOQ implements ArticleRepository {
    private final DSLContext dsl = JOOQDriver.createContext();

    @Override
    public Option<Article> findById (final UUID id) {
        return Option.ofOptional(dsl.select()
                                    .from("article")
                                    .where(field("id").eq(id))
                                    .fetchInto(Article.class)
                                    .stream()
                                    .findFirst()
        );
    }

    @Override
    public Option<Article> findByTitle (final String title) {
        return Option.ofOptional(dsl.select()
                                    .from("article")
                                    .where(field("title").eq(title))
                                    .fetchInto(Article.class)
                                    .stream()
                                    .findFirst()
        );
    }

    @Override
    public Article save (final Article article) {
        final UUID uuid = UUID.randomUUID();
        dsl.insertInto(table("article"))
           .columns(field("id"), field("businessId"), field("href"), field("title"))
           .values(uuid, article.getBusinessId(), article.getHref(), article.getTitle())
           .execute();

        return article;
    }
}
