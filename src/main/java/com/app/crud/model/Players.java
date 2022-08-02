package com.app.crud.model;

//  code resources: https://springframework.guru/processing-json-jackson/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//  Players - model of player info received from players api call
@JsonIgnoreProperties(ignoreUnknown=true)
public class Players {
    private int id;
    private String first_name;
    private int height_feet;
    private int height_inches;
    private String last_name;
    private String position;
    private int weight_pounds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getHeight_feet() {
        return height_feet;
    }

    public void setHeight_feet(int height_feet) {
        this.height_feet = height_feet;
    }

    public int getHeight_inches() {
        return height_inches;
    }

    public void setHeight_inches(int height_inches) {
        this.height_inches = height_inches;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getWeight_pounds() {
        return weight_pounds;
    }

    public void setWeight_pounds(int weight_pounds) {
        this.weight_pounds = weight_pounds;
    }

    @Override
    public String toString() {
        return "Players{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", height_feet=" + height_feet +
                ", height_inches=" + height_inches +
                ", last_name='" + last_name + '\'' +
                ", position='" + position + '\'' +
                ", weight_pounds=" + weight_pounds +
                '}';
    }
}
