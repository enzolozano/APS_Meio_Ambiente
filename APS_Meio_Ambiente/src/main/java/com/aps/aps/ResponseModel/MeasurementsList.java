package com.aps.aps.ResponseModel;

import java.util.Date;

public class MeasurementsList {
    public String parameter;
    public double value;
    public Date lastUpdated;
    public String unit;

    public String getParameter() {
        return parameter;
    }

    public double getValue() {
        return value;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public String getUnit() {
        return unit;
    }
}
