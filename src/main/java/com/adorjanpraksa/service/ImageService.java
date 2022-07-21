package com.adorjanpraksa.service;

import com.adorjanpraksa.configuration.NasaConfiguration;
import com.adorjanpraksa.model.DailyImages;
import com.adorjanpraksa.service.dao.NasaDao;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ImageService {
    private final NasaDao nasaDao;
    private final NasaConfiguration nasaConfiguration;

    public ImageService(NasaDao nasaDao, NasaConfiguration nasaConfiguration) {
        this.nasaDao = nasaDao;
        this.nasaConfiguration = nasaConfiguration;
    }

    public List<DailyImages> getImages(String rover, String camera) {

        return Stream.iterate(LocalDate.now(), date -> date.minusDays(1))
                .limit(nasaConfiguration.getNumberOfDays())
                .map(date -> new DailyImages(date, nasaDao.getDailyImages(date, rover, camera).stream()
                        .limit(nasaConfiguration.getNumberOfImages())
                        .toList()
                ))
                .toList();
    }
}
