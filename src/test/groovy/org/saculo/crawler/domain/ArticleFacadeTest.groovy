package org.saculo.crawler.domain


import spock.lang.Specification

class ArticleFacadeTest extends Specification {
    ArticleFacade articleFacade = ArticleConfiguration.articleFacade()

    def "should create articles from external page"() {
        when:
        def articles = articleFacade.createArticles()

        then:
        articles.size() == 20
    }
}
