package org.saculo.crawler.domain;

import lombok.Builder;
import lombok.Getter;
import org.saculo.crawler.domain.dto.CreatedArticle;

import java.util.Objects;
import java.util.UUID;

@Getter
@Builder
public class Article {
    private UUID id;
    private String href;
    private Integer businessId;
    private String title;
    private String content;

    static Article create(CreatedArticle article) {
        return Article.builder()
                      .href(article.getHref())
                      .businessId(Objects.hash(article.getHref(), article.getTitle()))
                      .title(article.getTitle())
                      .content(article.getContent())
                      .build();
    }

}
