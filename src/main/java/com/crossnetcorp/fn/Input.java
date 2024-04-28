package com.crossnetcorp.fn;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Input {
    public List<InputVehicle> fleet;
    public List<InputVisit> visits;
    public String params;
    
    public Input() {
    }

    @JsonCreator
    public Input(@JsonProperty("fleet") List<InputVehicle> fleet, 
		    @JsonProperty("visits") List<InputVisit> visits,
		    @JsonProperty("params") String params) {
	    this.fleet = fleet;
	    this.params = params;
	    this.visits = visits;
    }

}
