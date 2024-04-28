package com.crossnetcorp.fn;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputVehicle {
    public String id;
    public int capacity;
    public double lat;
    public double lng;
	    
    @JsonCreator
    public InputVehicle() {
    }

    @JsonCreator
    public InputVehicle(@JsonProperty("id") String id, 
		    @JsonProperty("capacity") int capacity,
		    @JsonProperty("lat") double lat,
		    @JsonProperty("lng") double lng) {
	this.id = id;
	this.capacity = capacity;
	this.lat = lat;
	this.lng = lng;
    }
}

