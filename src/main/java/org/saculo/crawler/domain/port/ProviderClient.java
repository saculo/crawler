package org.saculo.crawler.domain.port;

import io.vavr.collection.Stream;
import org.saculo.crawler.domain.dto.CreatedArticle;

public interface ProviderClient {
    Stream<CreatedArticle> getArticles();
}
