package org.saculo.crawler.infrastructure;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupConnector {
    private Document document;

    public Document connectToUrl (String url) {
        try {
            document = Jsoup.connect(url).timeout(50000).get();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
