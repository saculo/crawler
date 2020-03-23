package org.saculo.crawler.adapter.provider.reactor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DownloadError {
    DOWNLOAD_ERROR("Error during downloading", 400);

    private final String message;
    private final int httpCode;
}
