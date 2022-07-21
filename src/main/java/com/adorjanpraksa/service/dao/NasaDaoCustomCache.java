package com.adorjanpraksa.service.dao;

import com.adorjanpraksa.cache.NasaApiCustomCache;
import com.adorjanpraksa.integration.model.Photos;
import com.adorjanpraksa.integration.nasa.NasaClient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Profile("custom-caching")
public class NasaDaoCustomCache implements NasaDao {

    private final NasaApiCustomCache nasaApiCustomCache;
    private final NasaClient nasaClient;

    public NasaDaoCustomCache(NasaApiCustomCache nasaApiCustomCache, NasaClient nasaClient) {
        this.nasaApiCustomCache = nasaApiCustomCache;
        this.nasaClient = nasaClient;
    }

    @Override
    public List<String> getDailyImages(LocalDate date, String rover, String camera) {

        var response = nasaApiCustomCache.contains(new NasaApiCustomCache.CacheKey(date, rover, camera)) ?
                nasaApiCustomCache.get(new NasaApiCustomCache.CacheKey(date, rover, camera)) :
                nasaClient.getPhotos(rover, date.toString(), camera);

        nasaApiCustomCache.put(new NasaApiCustomCache.CacheKey(date, rover, camera), response);

        return response.photos().stream()
                .map(Photos.Photo::img_src)
                .toList();
    }


}
