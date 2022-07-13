package com.adorjanpraksa.web.dto;

import com.adorjanpraksa.validations.RoverAndCameraValidation;

@RoverAndCameraValidation
public class ImagesRequestParam {

    private String rover;
    private String camera;

    public ImagesRequestParam() {
    }

    public ImagesRequestParam(String rover, String camera) {
        this.rover = rover;
        this.camera = camera;
    }

    public String getRover() {
        return rover;
    }

    public void setRover(String rover) {
        this.rover = rover;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }
}
