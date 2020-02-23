package org.saculo.crawler.adapter.provider;

import lombok.RequiredArgsConstructor;
import org.saculo.crawler.domain.Article;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class ProviderClient {
    private final List<Provider> providers;
    private final ProviderManager providerManager;

    public List<CompletableFuture<List<Article>>> run() {
        return providerManager.runProviders(providers);
    }
}
