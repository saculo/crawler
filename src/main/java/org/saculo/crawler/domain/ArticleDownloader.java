package org.saculo.crawler.domain;

import io.vavr.collection.Stream;
import lombok.RequiredArgsConstructor;
import org.saculo.crawler.domain.dto.CreatedArticle;
import org.saculo.crawler.domain.port.ProviderClient;

@RequiredArgsConstructor
class ArticleDownloader {
    private final ProviderClient providerClient;

    Stream<CreatedArticle> download() {
        return Stream.ofAll(providerClient.getArticles());
    }
}
