package com.adorjanpraksa.integration.model;

import java.util.List;

public record Photos(List<Photo> photos) {

    public record Photo(int id, int sol, Camera camera, String img_src, String earth_date, Rover rover) {

        private record Camera(int id, String name, int rover_id, String full_name) {
        }

        private record Rover(int id, String name, String landing_date, String launch_date, String status) {
        }
    }
}
