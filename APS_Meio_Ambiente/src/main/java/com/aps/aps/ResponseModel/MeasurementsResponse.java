package com.aps.aps.ResponseModel;

import java.util.List;

public class MeasurementsResponse {
    public MetaResponse meta;
    public List<MeasurementResult> results;

    public List<MeasurementResult> getResults() {
        return results;
    }
}
