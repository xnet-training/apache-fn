package com.crossnetcorp.fn;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OutputVisit {
	public String id;
	public double lat;
	public double lng;
	public LocalDateTime arrivalTime;
	public LocalDateTime departureTime;
	
	@JsonCreator
	public OutputVisit() {
	}

	@JsonCreator
	public OutputVisit(@JsonProperty("id") String id, 
			@JsonProperty("lat") double lat, 
			@JsonProperty("lng") double lng,
			@JsonProperty("arrivalTime") LocalDateTime arrivalTime,
			@JsonProperty("departureTime") LocalDateTime departureTime) {
			this.id = id;
			this.lat = lat;
			this.lng = lng;
			this.arrivalTime = arrivalTime;
			this.departureTime = departureTime;
	}

}
