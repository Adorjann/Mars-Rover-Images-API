package com.adorjanpraksa.service.dao;

import java.time.LocalDate;
import java.util.List;

public interface NasaDao {
    List<String> getDailyImages(LocalDate date, String rover, String camera);
}
