package com.crossnetcorp.fn;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Output {
	public String solution;
	@JsonCreator
	public Output(@JsonProperty("solution") String solution) {
		this.solution = solution;
	}
}
