package com.crossnetcorp.fn;

import com.fnproject.fn.testing.*;
import org.junit.*;

import static org.junit.Assert.*;

import com.crossnetcorp.fn.Input;
import com.crossnetcorp.fn.Output;

public class OptaFunctionTest {

    @Rule
    public final FnTestingRule testing = FnTestingRule.createDefault();

    @Test
    public void shouldReturnGreeting() {
	testing.addSharedClass(Input.class);
	testing.addSharedClass(Output.class);
	testing.addSharedClass(InputVehicle.class);
	testing.addSharedClass(InputVisit.class);
        testing.givenEvent().withBody("{\"fleet\": [{\"id\": \"plate1\"}], \"visits\": [{\"id\":\"01\"}], \"params\": null}").enqueue();
        testing.thenRun(OptaFunction.class, "handleRequest");

        FnResult result = testing.getOnlyResult();
	System.out.println(result.getBodyAsString());
        assertEquals("{\"solution\":\"Demo\",\"routes\":[]}", result.getBodyAsString());
    }

}
