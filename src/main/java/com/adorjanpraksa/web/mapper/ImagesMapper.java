package com.adorjanpraksa.web.mapper;

import com.adorjanpraksa.model.DailyImages;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ImagesMapper {

    public Map<String, List<String>> mapToResponseBody(List<DailyImages> images) {

        var responseMap = new LinkedHashMap<String, List<String>>();

        images.forEach((dailyImages) -> {

            responseMap.put(dailyImages.getDate().toString(), dailyImages.getImages());
        });

        return responseMap;
    }

}
