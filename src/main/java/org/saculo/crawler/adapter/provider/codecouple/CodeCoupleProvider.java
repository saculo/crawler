package org.saculo.crawler.adapter.provider.codecouple;

import lombok.SneakyThrows;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.saculo.crawler.adapter.provider.Provider;
import org.saculo.crawler.domain.dto.CreatedArticle;
import org.saculo.crawler.infrastructure.JsoupConnector;

import java.net.URI;
import java.util.Optional;

public class CodeCoupleProvider implements Provider {
    private static final String URL = "https://codecouple.pl/page/%s/";
    private static final String PROVIDER = "Codecouple";
    private final JsoupConnector connector = new JsoupConnector();

    @Override
    public Elements extractElements(Integer page) {
        String nextPage = String.format(URL, page);
        return connector.connectToUrl(nextPage).getElementsByTag("article");
    }

    @Override
    public String extractHref(Element element) {
        return element.getElementsByClass("entry-title")
                      .first()
                      .getElementsByTag("a")
                      .attr("href");
    }

    @Override
    public String extractTitle(Element element) {
        return element.getElementsByClass("entry-title")
                      .first()
                      .getElementsByTag("a")
                      .text();
    }

    @Override
    public String extractBody(URI href) {
        return Optional.ofNullable(
                connector.connectToUrl(href.toString())
                          .getElementsByClass("entry-content")
                          .text()
        )
                       .orElse("");
    }

    @Override
    @SneakyThrows
    public CreatedArticle extractArticle(Element element) {
        final String href = extractHref(element);
        final String title = extractTitle(element);

        return CreatedArticle.builder()
                .href(href)
                .title(title)
                .build();
    }
}
