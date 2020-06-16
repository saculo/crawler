package org.saculo.crawler;

import io.vavr.collection.List;
import org.saculo.crawler.adapter.provider.Provider;
import org.saculo.crawler.adapter.provider.codecouple.CodeCoupleProvider;
import org.saculo.crawler.domain.ArticleConfiguration;
import org.saculo.crawler.domain.ArticleFacade;
import ratpack.server.RatpackServer;

import static ratpack.jackson.Jackson.json;

public class Main {
    public static void main (String[] args) throws Exception {
        List<Provider> providers = List.of(new CodeCoupleProvider());
        ArticleFacade articleFacade = ArticleConfiguration.articleFacade(providers);
        RatpackServer.start(server -> server.handlers(
                chain -> chain.post(
                        "article", ctx -> ctx.render(json(articleFacade.createArticles().toJavaList()))
                )
                            )
        );
    }
}
