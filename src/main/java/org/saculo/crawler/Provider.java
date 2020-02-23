package org.saculo.crawler;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URI;

public interface Provider {
    Elements extractElements (Integer page);
    String extractHref (Element element);
    String extractTitle (Element element);
    String extractBody (URI href);
    SampleDTO extractArticle (Element element);
}

