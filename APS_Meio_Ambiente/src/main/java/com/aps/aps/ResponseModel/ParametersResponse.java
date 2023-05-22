package com.aps.aps.ResponseModel;

import java.util.List;

public class ParametersResponse {
    public MetaResponse meta;
    public List<ParametersResult> results;

    public List<ParametersResult> getResults() {
        return results;
    }
}
