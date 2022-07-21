package com.adorjanpraksa.configuration;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import java.time.Duration;
import java.util.List;

import static com.adorjanpraksa.configuration.CachingConfiguration.CacheName.NASA_ROVER_IMAGES;


@Configuration
@EnableCaching
public class CachingConfiguration {

    @Bean
    public CacheManager ehCacheManager() {
        var cacheManager = Caching.getCachingProvider().getCacheManager();

        cacheManager.createCache(NASA_ROVER_IMAGES, createCacheConfiguration(1, Duration.ofSeconds(60)));

        return cacheManager;
    }

    private javax.cache.configuration.Configuration<SimpleKey, List> createCacheConfiguration(int memoryInMb, Duration duration) {

        CacheConfigurationBuilder<SimpleKey, List> configuration =
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                                SimpleKey.class,
                                List.class,
                                ResourcePoolsBuilder
                                        .newResourcePoolsBuilder().offheap(memoryInMb, MemoryUnit.MB))
                        .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(duration));

        return Eh107Configuration.fromEhcacheCacheConfiguration(configuration);
    }

    public static class CacheName {
        public static final String NASA_ROVER_IMAGES = "nasa-rover-images";
    }
}
