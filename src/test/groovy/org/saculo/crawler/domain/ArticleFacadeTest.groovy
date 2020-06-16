package org.saculo.crawler.domain

import io.vavr.collection.List
import org.saculo.crawler.adapter.provider.Provider
import org.saculo.crawler.adapter.provider.codecouple.CodeCoupleProvider
import spock.lang.Specification

class ArticleFacadeTest extends Specification {
    List<Provider> providers = List.of(new CodeCoupleProvider())
    ArticleFacade articleFacade = ArticleConfiguration.articleFacade(providers)

    def "should create articles from external page"() {
        when:
        def articles = articleFacade.createArticles()

        then:
        articles.size() == 20
    }
}
