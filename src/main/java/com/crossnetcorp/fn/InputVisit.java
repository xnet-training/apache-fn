package com.crossnetcorp.fn;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputVisit {
  public String id;
  public int weigth;
  public int volume;
  public double lat;
  public double lng;

  @JsonCreator
  public InputVisit() {}

  @JsonCreator
  public InputVisit(@JsonProperty("id") String id, 
		  @JsonProperty("weigth") int weigth, 
		  @JsonProperty("volume") int volume,
		  @JsonProperty("lat") double lat,
		  @JsonProperty("lng") double lng) {
    this.id = id;
    this.weigth = weigth;
    this.volume = volume;
    this.lat = lat;
    this.lng = lng;
  }
}
