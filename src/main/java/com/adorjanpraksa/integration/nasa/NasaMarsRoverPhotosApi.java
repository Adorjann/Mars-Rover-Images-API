package com.adorjanpraksa.integration.nasa;

import com.adorjanpraksa.integration.model.Photos;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Component
public class NasaMarsRoverPhotosApi {


    private static final String baseUrl = "https://api.nasa.gov/mars-photos/api/v1/rovers/";
    private static final String apiKey = "yP6pplmf2bQsJJ0aeGpCF5b1KlKMB7uDv6Hw3WtA";

    private static final List<String> rovers = List.of("curiosity");

    private static final List<String> cameras = List.of("NAVCAM");

    public List<Photos.Photo> makeApiCallForImages(LocalDate date, String rover, String camera) {

        RestTemplate restTemplate = new RestTemplate();

        Photos photosResponse = restTemplate.getForObject(
                baseUrl.concat(rover).concat("/photos?earth_date=")
                        .concat(date.toString()).concat("&camera=").concat(camera)
                        .concat("&api_key=").concat(apiKey),
                Photos.class);

        if (nonNull(photosResponse)) {
            return photosResponse.photos;
        }
        return new ArrayList<>();
    }

}
