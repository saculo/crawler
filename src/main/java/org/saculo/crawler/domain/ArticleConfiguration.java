package org.saculo.crawler.domain;

import io.vavr.collection.List;
import org.saculo.crawler.adapter.provider.Provider;
import org.saculo.crawler.adapter.provider.reactor.ReactorManager;
import org.saculo.crawler.adapter.repository.ArticleRepositoryJOOQ;
import org.saculo.crawler.domain.port.ArticleRepository;
import org.saculo.crawler.domain.port.ProviderClient;

public class ArticleConfiguration {
    public static ArticleFacade articleFacade(List<Provider> providers) {
        ProviderClient providerClient = new ReactorManager(providers);
        ArticleRepository articleRepository = new ArticleRepositoryJOOQ();
        ArticleCreator articleCreator = new ArticleCreator(articleRepository);
        ArticleDownloader articleDownloader = new ArticleDownloader(providerClient);

        return new ArticleFacade(articleDownloader, articleCreator);
    }
}
