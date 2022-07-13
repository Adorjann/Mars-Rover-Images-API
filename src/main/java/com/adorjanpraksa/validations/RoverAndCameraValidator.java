package com.adorjanpraksa.validations;

import com.adorjanpraksa.web.dto.ImagesRequestParam;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;

public class RoverAndCameraValidator implements ConstraintValidator<RoverAndCameraValidation, ImagesRequestParam> {

    @Value("#{${nasa.roverCameraSupport}}")
    private Map<String, List<String>> roverCameraSupport;

    private String errorMessage;
    private String property;


    @Override
    public boolean isValid(ImagesRequestParam requestParam, ConstraintValidatorContext context) {

        var rover = requestParam.getRover().toLowerCase();
        var camera = requestParam.getCamera().toUpperCase();

        var roversCameras =roverCameraSupport.get(rover);
        if (roversCameras == null){
            errorMessage = "Rover you have chosen is not supported.";
            property = "rover";

            setConstraintViolation(context);
            return false;
        }

        errorMessage = "Rover you have chosen doesn't support the camera you have chosen.";
        property = "camera";
        setConstraintViolation(context);

        return roversCameras.contains(camera);
    }

    private void setConstraintViolation(ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode(property)
                .addConstraintViolation();
    }
}
