package org.saculo.crawler;

import lombok.extern.slf4j.Slf4j;
import org.saculo.crawler.domain.ArticleConfiguration;
import org.saculo.crawler.domain.ArticleFacade;
import ratpack.server.RatpackServer;

import static ratpack.jackson.Jackson.json;

public class Main {
    public static void main (String[] args) throws Exception {
        ArticleFacade articleFacade = ArticleConfiguration.articleFacade();
        RatpackServer.start(server -> server.handlers(
                chain -> chain.post(
                        "article", ctx -> ctx.render(json(articleFacade.createArticles().toJavaList()))
                )));
    }
}
