package com.aps.aps.ResponseModel;

import java.util.List;

public class LatestMeasurementResponse {
    public MetaResponse meta;
    public List<MeasurementsResult> results;

    public List<MeasurementsResult> getResults() {
        return results;
    }

}
