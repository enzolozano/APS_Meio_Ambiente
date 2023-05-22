package com.aps.aps.ResponseModel;

public class MeasurementResult {
    public long locationId;
    public String location;
    public String parameter;
    public float value;
    public DataAPI date;
    public String unit;
    public CoordenadasAPI coordinates;
    public String country;
    public String city;
    public boolean isMobile;
    public boolean isAnalysis;
    public String entity;
    public String sensorType;

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setParameter (String parameter) {
        this.parameter = parameter;
    }
    public void setValue (float value) {
        this.value = value;
    }
    public void setDate (DataAPI date) {
        this.date = date;
    }
    public void setUnit (String unit) {
        this.unit = unit;
    }
    public void setCoordinates (CoordenadasAPI coordinates) {
        this.coordinates = coordinates;
    }
    public void setCountry (String country) {
        this.country = country;
    }
    public void setCity (String parameter) {
        this.parameter = parameter;
    }
    public void setMobile (boolean isMobile) {
        this.isMobile = isMobile;
    }
    public void setAnalysis (boolean isAnalysis) {
        this.isAnalysis = isAnalysis;
    }

    public void setSensorType (String sensorType) {
        this.sensorType = sensorType;
    }

    public long getLocationId() {
        return locationId;
    }
    public String getLocation() {
        return location;
    }
    public String getParameter() {
        return parameter;
    }
    public float getValue() {
        return value;
    }
    public DataAPI getDate() {
        return date;
    }
    public String getUnit() {
        return unit;
    }
    public CoordenadasAPI getCoordinates(){
        return coordinates;
    }
    public String getCountry(){
        return country;
    }
    public String getCity(){
        return city;
    }
    public boolean getMobile() {
        return isMobile;
    }
    public boolean getAnalysis() {
        return isAnalysis;
    }
    public String getEntity(){
        return entity;
    }
    public String getSensorType(){
        return sensorType;
    }
}
