package com.aps.aps.ResponseModel;

public class ParametersResult {
    public long id;
    public String name;
    public String displayName;
    public String description;
    public String preferredUnit;
    public boolean isCore;
    public float maxColorValue;

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCore(boolean isCore){
        this.isCore = isCore;
    }

    public void setPreferredUnit(String preferredUnit){
        this.preferredUnit = preferredUnit;
    }

    public void setMaxColorValue(float maxColorValue){
        this.maxColorValue = maxColorValue;
    }

}
