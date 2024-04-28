package com.crossnetcorp.fn;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OutputRoute {
   public String vehicleId;
   public List<OutputVisit> visits;

   @JsonCreator
   public OutputRoute() {}

   @JsonCreator
   public OutputRoute(@JsonProperty("vehicleId") String vehicleId, @JsonProperty("visits") List<OutputVisit> visits) {
      this.vehicleId = vehicleId;
      this.visits = visits;
   }
}
