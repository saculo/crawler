package org.saculo.crawler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
class Article {
    private String href;
    private String title;
    private String content;
}
