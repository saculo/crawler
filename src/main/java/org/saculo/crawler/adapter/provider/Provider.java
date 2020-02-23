package org.saculo.crawler.adapter.provider;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.saculo.crawler.domain.Article;

import java.net.URI;

public interface Provider {
    Elements extractElements (Integer page);
    String extractHref (Element element);
    String extractTitle (Element element);
    String extractBody (URI href);
    Article extractArticle (Element element);
}

