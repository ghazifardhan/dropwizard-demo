package com.apidemo.dropwizarddemo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by markibid on 10/03/17.
 */
public class ResultModel {

    private boolean success;
    private String result;

    @JsonProperty
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @JsonProperty
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
