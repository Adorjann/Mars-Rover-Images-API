package com.adorjanpraksa.service.dao;

import com.adorjanpraksa.integration.model.Photos;
import com.adorjanpraksa.integration.nasa.NasaClient;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class NasaDao {

    private final NasaClient nasaClient;

    public NasaDao(NasaClient nasaClient) {
        this.nasaClient = nasaClient;
    }

    public List<String> getDailyImages(LocalDate date, String rover, String camera) {

        var responseModel = nasaClient.getPhotos(rover, date.toString(), camera).getPhotos();

        return responseModel.stream()
                .map(Photos.Photo::getImg_src)
                .toList();
    }

}
