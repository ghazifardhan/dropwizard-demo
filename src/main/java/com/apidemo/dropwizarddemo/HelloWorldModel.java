package com.apidemo.dropwizarddemo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by markibid on 10/03/17.
 */
public class HelloWorldModel {

    private String firstName;
    private String lastName;

    public HelloWorldModel(){

    }

    public HelloWorldModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
