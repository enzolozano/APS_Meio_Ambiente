package com.aps.aps.ResponseModel;

import java.util.List;

public class MeasurementsResult {
    public String location;
    public String city;
    public String country;
    public CoordenadasAPI coordinates;
    public List<MeasurementsList> measurements;

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public CoordenadasAPI getCoordinates() {
        return coordinates;
    }

    public List<MeasurementsList> getMeasurements() {
        return measurements;
    }
}
