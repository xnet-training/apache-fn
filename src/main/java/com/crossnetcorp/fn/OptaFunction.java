package com.crossnetcorp.fn;

public class OptaFunction {

    public static class Input {
	    public String fleet;
	    public String params;
	    public String visits;
    }

    public String handleRequest(String input) {
        String problem = (input == null || input.isEmpty()) ? "{'problem': {}}"  : input;

        System.out.println("Optimizando problema"); 
        return "{ 'result': {" + problem + "}";
    }

}
