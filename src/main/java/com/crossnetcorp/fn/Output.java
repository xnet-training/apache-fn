package com.crossnetcorp.fn;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Output {
   public String solution;
   public List<OutputRoute> routes;

   @JsonCreator
   public Output(@JsonProperty("solution") String solution) {
      this.solution = solution;
   }
}
