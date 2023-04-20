package com.aps.aps.ResponseModel;

import java.util.List;

public class CitiesResponse {
    public MetaResponse meta;
    public List<CitiesResult> results;

    public List<CitiesResult> getResults() {
        return results;
    }
}
