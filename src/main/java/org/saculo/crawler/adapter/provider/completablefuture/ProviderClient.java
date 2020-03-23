package org.saculo.crawler.adapter.provider.completablefuture;

import lombok.RequiredArgsConstructor;
import org.saculo.crawler.adapter.provider.Provider;
import org.saculo.crawler.domain.dto.CreatedArticle;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class ProviderClient {
    private final List<Provider> providers;
    private final ProviderManager providerManager;

    public List<CompletableFuture<List<CreatedArticle>>> run() {
        return providerManager.runProviders(providers);
    }
}
