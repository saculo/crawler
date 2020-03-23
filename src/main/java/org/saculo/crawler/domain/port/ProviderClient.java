package org.saculo.crawler.domain.port;

import org.saculo.crawler.domain.dto.CreatedArticle;

import java.util.stream.Stream;

public interface ProviderClient {
    Stream<CreatedArticle> getArticles();
}
