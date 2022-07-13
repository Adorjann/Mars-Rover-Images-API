package com.adorjanpraksa.integration.nasa;

import com.adorjanpraksa.integration.model.Photos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nasaFeignClient", url = "${nasa.baseUrl}")
public interface NasaClient {

    @GetMapping(value = "/rovers/{rover}/photos?api_key=" + "${nasa.key}")
    Photos getPhotos(@PathVariable("rover") String rover,
                     @RequestParam("earth_date") String date,
                     @RequestParam("camera") String camera);
}
