package org.saculo.crawler.domain;

import io.vavr.collection.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleFacade {
    private final ArticleDownloader articleDownloader;
    private final ArticleCreator articleCreator;

    public Stream<Article> createArticles () {
        return articleDownloader.download()
                                .map(articleCreator::create);
    }
}
