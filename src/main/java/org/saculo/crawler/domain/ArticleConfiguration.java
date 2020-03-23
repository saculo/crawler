package org.saculo.crawler.domain;

import org.saculo.crawler.adapter.provider.reactor.ReactorManager;
import org.saculo.crawler.adapter.repository.ArticleRepositoryJOOQ;
import org.saculo.crawler.domain.port.ArticleRepository;
import org.saculo.crawler.domain.port.ProviderClient;

public class ArticleConfiguration {
    public static ArticleFacade articleFacade() {
        ProviderClient providerClient = new ReactorManager();
        ArticleRepository articleRepository = new ArticleRepositoryJOOQ();
        ArticleCreator articleCreator = new ArticleCreator(articleRepository);
        ArticleDownloader articleDownloader = new ArticleDownloader(providerClient);

        return new ArticleFacade(articleDownloader, articleCreator);
    }
}
