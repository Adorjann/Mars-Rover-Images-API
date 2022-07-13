package com.adorjanpraksa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailyImages {

    private LocalDate date;

    private List<String> images = new ArrayList<>();

    public DailyImages(LocalDate date) {
        this.date = date;
    }

    public DailyImages(LocalDate date, List<String> images) {
        this.date = date;
        this.images = images;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
