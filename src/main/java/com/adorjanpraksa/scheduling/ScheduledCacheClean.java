package com.adorjanpraksa.scheduling;

import com.adorjanpraksa.cache.NasaApiCustomCache;
import com.adorjanpraksa.configuration.NasaConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Profile("custom-caching")
public class ScheduledCacheClean {

    private final NasaApiCustomCache caching;

    private final NasaConfiguration nasaConfiguration;

    public ScheduledCacheClean(NasaApiCustomCache caching, NasaConfiguration nasaConfiguration) {
        this.caching = caching;
        this.nasaConfiguration = nasaConfiguration;
    }

    @Scheduled(cron = "@midnight")
    public void cleanCache() {

        var keys = caching.getAllKeys();

        keys.stream()
                .filter(k -> k.date().isBefore(LocalDate.now().minusDays(nasaConfiguration.getNumberOfDays())))
                .forEach(caching::evict);
    }
}
