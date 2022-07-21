package com.adorjanpraksa.web.mapper;

import com.adorjanpraksa.model.DailyImages;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ImagesMapper {

    public Map<String, List<String>> mapToResponseBody(List<DailyImages> images) {

        return images.stream()
                .collect(Collectors.toMap(
                        key -> key.date().toString(),
                        DailyImages::images
                ));

    }

}
