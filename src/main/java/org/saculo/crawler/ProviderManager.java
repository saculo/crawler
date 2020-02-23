package org.saculo.crawler;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ProviderManager {
    private static final int PAGES_AMOUNT = 2;
    private static final int THREADS_AMOUNT = 2;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

    List<CompletableFuture<List<SampleDTO>>> runProviders (List<Provider> providers) {
        return providers.stream()
                        .map(this::runProvider)
                        .collect(Collectors.toList());
    }

    private CompletableFuture<List<SampleDTO>> runProvider (Provider provider) {
        return waitForCompleted(extractArticlesFromAllPages(provider));
    }

    private CompletableFuture<List<SampleDTO>> waitForCompleted (
            List<CompletableFuture<List<SampleDTO>>> results) {
        var futureResultArray = results.toArray(
                new CompletableFuture[results.size()]
        );
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futureResultArray);
        return combinedFuture.thenApply(e -> results.stream()
                                                    .map(CompletableFuture::join)
                                                    .flatMap(List::stream)
                                                    .collect(Collectors.toList())
        );
    }

    private List<CompletableFuture<List<SampleDTO>>> extractArticlesFromAllPages (Provider provider) {
        return setListOfPagesNumbers().stream()
                                      .map(number -> extractAsync(number, provider))
                                      .collect(Collectors.toList());
    }

    private CompletableFuture<List<SampleDTO>> extractAsync (Integer number, Provider provider) {
        return CompletableFuture.supplyAsync(() -> extractDtoFromSinglePage(number, provider), executorService);
    }

    private List<SampleDTO> extractDtoFromSinglePage (Integer pageNumber, Provider provider) {
        return provider.extractElements(pageNumber)
                       .stream()
                       .map(provider::extractArticle)
                       .distinct()
                       .collect(Collectors.toList());
    }

    private List<Integer> setListOfPagesNumbers () {
        return IntStream.range(1, PAGES_AMOUNT + 1)
                        .boxed()
                        .collect(Collectors.toList());
    }

}
