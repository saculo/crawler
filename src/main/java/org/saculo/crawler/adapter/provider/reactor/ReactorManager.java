package org.saculo.crawler.adapter.provider.reactor;

import org.saculo.crawler.adapter.provider.Provider;
import org.saculo.crawler.adapter.provider.codecouple.CodeCoupleProvider;
import org.saculo.crawler.domain.dto.CreatedArticle;
import org.saculo.crawler.domain.port.ProviderClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReactorManager implements ProviderClient {
    private static final int PAGES_AMOUNT = 2;
    private final List<Provider> providers = List.of(new CodeCoupleProvider());

    @Override
    public Stream<CreatedArticle> getArticles() {
        return Flux.fromIterable(providers)
                    .flatMap(this::extractFromAllPages)
                    .toStream();
    }

    private Flux<CreatedArticle> extractFromAllPages(Provider provider) {
        return Flux.fromIterable(setListOfPagesNumbers())
                   .flatMap(page -> extractFromSinglePage(page, provider));
    }

    private Flux<CreatedArticle> extractFromSinglePage (Integer pageNumber, Provider provider) {
        return Flux.fromIterable(provider.extractElements(pageNumber))
                       .map(provider::extractArticle)
                       .distinct();
    }

    private List<Integer> setListOfPagesNumbers () {
        return IntStream.range(1, PAGES_AMOUNT + 1)
                        .boxed()
                        .collect(Collectors.toList());
    }
}
