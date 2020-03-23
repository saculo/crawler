package org.saculo.crawler.adapter.provider.reactor;

import io.vavr.collection.List;
import io.vavr.collection.Stream;
import org.saculo.crawler.adapter.provider.Provider;
import org.saculo.crawler.adapter.provider.codecouple.CodeCoupleProvider;
import org.saculo.crawler.domain.dto.CreatedArticle;
import org.saculo.crawler.domain.port.ProviderClient;
import reactor.core.publisher.Flux;


public class ReactorManager implements ProviderClient {
    private static final int PAGES_AMOUNT = 2;
    private final List<CodeCoupleProvider> providers = List.of(new CodeCoupleProvider());

    @Override
    public Stream<CreatedArticle> getArticles () {
        return Stream.ofAll(Flux.fromIterable(providers)
                   .flatMap(this::extractFromAllPages)
                   .toStream());
    }

    private Flux<CreatedArticle> extractFromAllPages (Provider provider) {
        return Flux.fromIterable(setListOfPagesNumbers())
                   .flatMap(page -> extractFromSinglePage(page, provider));
    }

    private Flux<CreatedArticle> extractFromSinglePage (Integer pageNumber, Provider provider) {
        return Flux.fromIterable(provider.extractElements(pageNumber))
                   .map(provider::extractArticle)
                   .distinct();
    }

    private List<Integer> setListOfPagesNumbers () {
        return Stream.range(1, PAGES_AMOUNT + 1).toList();
    }
}
