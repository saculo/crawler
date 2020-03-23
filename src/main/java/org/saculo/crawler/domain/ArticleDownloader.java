package org.saculo.crawler.domain;

import io.vavr.collection.Stream;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.saculo.crawler.domain.dto.CreatedArticle;
import org.saculo.crawler.domain.port.ProviderClient;

@RequiredArgsConstructor
class ArticleDownloader {
    private final ProviderClient providerClient;

    Stream<CreatedArticle> download() {
        return providerClient.getArticles();
    }
}
