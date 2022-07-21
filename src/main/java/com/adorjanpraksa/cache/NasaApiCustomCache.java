package com.adorjanpraksa.cache;

import com.adorjanpraksa.integration.model.Photos;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@Profile("custom-caching")
public class NasaApiCustomCache {

    private final Map<CacheKey, Photos> cachedResponse;

    public NasaApiCustomCache() {
        this.cachedResponse = new HashMap<>();
    }

    public void put(CacheKey cacheKey, Photos value) {

        cachedResponse.putIfAbsent(cacheKey, value);
    }

    public boolean contains(CacheKey cacheKey) {

        return cachedResponse.containsKey(cacheKey);
    }

    public Photos get(CacheKey cacheKey) {

        return cachedResponse.get(cacheKey);
    }

    public Set<CacheKey> getAllKeys() {

        return cachedResponse.keySet();
    }

    public void evict(CacheKey cacheKey) {

        cachedResponse.remove(cacheKey);
    }

    public record CacheKey(LocalDate date, String rover, String camera) {

    }

}
