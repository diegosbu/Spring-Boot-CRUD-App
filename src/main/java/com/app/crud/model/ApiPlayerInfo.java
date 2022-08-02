package com.app.crud.model;

//  code resources: https://springframework.guru/processing-json-jackson/

import java.util.Arrays;
import java.util.Map;

//  ApiPlayerInfo - model of data + metadata received from players api call
public class ApiPlayerInfo {
    private Players[] data;
    private Map<String, String> meta;

    public Players[] getData() {
        return data;
    }

    public void setData(Players[] data) {
        this.data = data;
    }

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "data=" + Arrays.toString(data) +
                ", meta=" + meta +
                '}';
    }
}
