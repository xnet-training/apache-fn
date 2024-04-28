package com.crossnetcorp.fn;

import com.crossnetcorp.optimizador.domain.VehicleRoutePlan;
import com.crossnetcorp.optimizador.solver.Solver;

public class OptaFunction {

    public Output handleRequest(Input input) {
	    System.out.println("Iniciando");
	    System.out.println(input);

	    Solver solver = new Solver();

	    // String problem = (input == null || input.isEmpty()) ? "{'problem': {}}"  : input;
	    // System.out.println("Optimizando problema"); 
	    // return "{ 'result': {" + problem + "}";
	    return new Output("Demo");
    }

}
