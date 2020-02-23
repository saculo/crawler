package org.saculo.crawler.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatedArticle {
    private String href;
    private String title;
    private String content;
}
