package com.adorjanpraksa.service.dao;

import com.adorjanpraksa.integration.model.Photos;
import com.adorjanpraksa.integration.nasa.NasaClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static com.adorjanpraksa.configuration.CachingConfiguration.CacheName.NASA_ROVER_IMAGES;

@Component
@Profile("spring-caching")
public class NasaDaoSpringCache implements NasaDao {

    private final NasaClient nasaClient;

    public NasaDaoSpringCache(NasaClient nasaClient) {
        this.nasaClient = nasaClient;
    }

    @Override
    @Cacheable(value = NASA_ROVER_IMAGES)
    public List<String> getDailyImages(LocalDate date, String rover, String camera) {

        return nasaClient.getPhotos(rover, date.toString(), camera).photos().stream()
                .map(Photos.Photo::img_src)
                .toList();

    }
}
