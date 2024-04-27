package com.crossnetcorp.fn;

public class OptaFunction {

    public Output handleRequest(Input input) {
	    System.out.println("Iniciando");
	    System.out.println(input);
	    // String problem = (input == null || input.isEmpty()) ? "{'problem': {}}"  : input;
	    // System.out.println("Optimizando problema"); 
	    // return "{ 'result': {" + problem + "}";
	    return new Output("Demo");
    }

}
