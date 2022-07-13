package com.adorjanpraksa.integration.model;

import java.util.List;

public class Photos {

    public List<Photo> photos;

    public Photos() {
    }

    public Photos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public static class Photo {

        public int id;
        public int sol;
        public Camera camera;
        public String img_src;
        public String earth_date;
        public Rover rover;

        public Photo() {
        }

        public Photo(int id, int sol, Camera camera, String img_src, String earth_date, Rover rover) {
            this.id = id;
            this.sol = sol;
            this.camera = camera;
            this.img_src = img_src;
            this.earth_date = earth_date;
            this.rover = rover;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSol() {
            return sol;
        }

        public void setSol(int sol) {
            this.sol = sol;
        }

        public Camera getCamera() {
            return camera;
        }

        public void setCamera(Camera camera) {
            this.camera = camera;
        }

        public String getImg_src() {
            return img_src;
        }

        public void setImg_src(String img_src) {
            this.img_src = img_src;
        }

        public String getEarth_date() {
            return earth_date;
        }

        public void setEarth_date(String earth_date) {
            this.earth_date = earth_date;
        }

        public Rover getRover() {
            return rover;
        }

        public void setRover(Rover rover) {
            this.rover = rover;
        }

        public class Camera {

            public int id;
            public String name;
            public int rover_id;
            public String full_name;

            public Camera() {
            }

            public Camera(int id, String name, int rover_id, String full_name) {
                this.id = id;
                this.name = name;
                this.rover_id = rover_id;
                this.full_name = full_name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getRover_id() {
                return rover_id;
            }

            public void setRover_id(int rover_id) {
                this.rover_id = rover_id;
            }

            public String getFull_name() {
                return full_name;
            }

            public void setFull_name(String full_name) {
                this.full_name = full_name;
            }
        }

        public class Rover {

            public int id;
            public String name;
            public String landing_date;
            public String launch_date;
            public String status;

            public Rover() {
            }

            public Rover(int id, String name, String landing_date, String launch_date, String status) {
                this.id = id;
                this.name = name;
                this.landing_date = landing_date;
                this.launch_date = launch_date;
                this.status = status;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLanding_date() {
                return landing_date;
            }

            public void setLanding_date(String landing_date) {
                this.landing_date = landing_date;
            }

            public String getLaunch_date() {
                return launch_date;
            }

            public void setLaunch_date(String launch_date) {
                this.launch_date = launch_date;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }

    }
}
