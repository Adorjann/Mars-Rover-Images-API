package com.adorjanpraksa.web.controller;

import com.adorjanpraksa.service.ImageService;
import com.adorjanpraksa.web.dto.ImagesRequestParam;
import com.adorjanpraksa.web.mapper.ImagesMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/images", produces = MediaType.APPLICATION_JSON_VALUE)
public class ImagesController {

    private final ImageService imageService;

    private final ImagesMapper imagesMapper;

    public ImagesController(ImageService imageService, ImagesMapper imagesMapper) {
        this.imageService = imageService;
        this.imagesMapper = imagesMapper;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<String>>> getImages(@Valid ImagesRequestParam imagesRequestParam) {

        var images = imageService.getImages(imagesRequestParam.getRover(), imagesRequestParam.getCamera());

        return ResponseEntity.ok(imagesMapper.mapToResponseBody(images));
    }

}
