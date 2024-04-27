package com.crossnetcorp.fn;

public class OptaFunction {

    public String handleRequest(String input) {
        String name = (input == null || input.isEmpty()) ? "world"  : input;

        System.out.println("Inside Java Hello World function"); 
        return "Hello, " + name + "!";
    }

}
