package org.saculo.crawler.domain.port;

import io.vavr.control.Option;
import org.saculo.crawler.domain.Article;

import java.util.UUID;

public interface ArticleRepository {
    Option<Article> findById(UUID id);
    Option<Article> findByTitle(String title);
    Article save(Article article);
}
