package com.crossnetcorp.fn;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Input {
    public String fleet;
    public String params;
    public String visits;
    
    public Input() {
    }

    @JsonCreator
    public Input(@JsonProperty("fleet") String fleet, @JsonProperty("params") String params,@JsonProperty("visits") String visits) {
	    this.fleet = fleet;
	    this.params = params;
	    this.visits = visits;
    }
}
