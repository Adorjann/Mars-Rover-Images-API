package com.adorjanpraksa.model;

import java.time.LocalDate;
import java.util.List;

public record DailyImages(LocalDate date, List<String> images) implements Comparable<DailyImages> {


    @Override
    public int compareTo(DailyImages other) {
        if (this.date().isBefore(other.date())) {
            return 1;
        }
        return -1;
    }
}
