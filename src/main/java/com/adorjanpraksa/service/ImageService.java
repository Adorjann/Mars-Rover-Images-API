package com.adorjanpraksa.service;

import com.adorjanpraksa.configuration.NasaConfiguration;
import com.adorjanpraksa.model.DailyImages;
import com.adorjanpraksa.service.dao.NasaDao;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    private final NasaDao nasaDao;
    private final NasaConfiguration nasaConfiguration;

    public ImageService(NasaDao nasaDao, NasaConfiguration nasaConfiguration) {
        this.nasaDao = nasaDao;
        this.nasaConfiguration = nasaConfiguration;
    }

    public List<DailyImages> getImages(String rover, String camera) {

        var requestedDailyImages = new ArrayList<DailyImages>();
        var today = LocalDate.now();

        for (var currentDate = LocalDate.now();
             currentDate.isAfter(LocalDate.now().minusDays(nasaConfiguration.getNumberOfDays()));
             currentDate=currentDate.minusDays(1)) {

            var images = nasaDao.getDailyImages(currentDate, rover, camera).stream()
                    .limit(nasaConfiguration.getNumberOfImages())
                    .toList();

            DailyImages dailyImages = new DailyImages(currentDate, images);

            requestedDailyImages.add(dailyImages);
        }

        return requestedDailyImages;
    }


}
