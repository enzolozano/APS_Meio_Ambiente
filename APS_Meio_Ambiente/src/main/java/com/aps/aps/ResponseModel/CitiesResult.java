package com.aps.aps.ResponseModel;

import java.util.Date;

public class CitiesResult {
    public String country;
    public String city;
    public long count;
    public int locations;
    public Date firstUpdated;
    public Date lastUpdated;
    public String[] parameters;

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public long getCount() {
        return count;
    }

    public int getLocations() {
        return locations;
    }

    public Date getFirstUpdated() {
        return firstUpdated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public String[] getParameters() {
        return parameters;
    }
}