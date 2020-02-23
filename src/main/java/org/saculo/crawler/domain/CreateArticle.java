package org.saculo.crawler.domain;

import lombok.RequiredArgsConstructor;
import org.saculo.crawler.domain.dto.CreatedArticle;
import org.saculo.crawler.domain.port.ArticleRepository;

@RequiredArgsConstructor
class CreateArticle {
    private final ArticleRepository articleRepository;

    Article create(CreatedArticle createdArticle) {
        return articleRepository.save(Article.create(createdArticle));
    }
}
