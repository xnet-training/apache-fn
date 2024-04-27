package com.crossnetcorp.fn;

import com.fnproject.fn.testing.*;
import org.junit.*;

import static org.junit.Assert.*;

public class OptaFunctionTest {

    @Rule
    public final FnTestingRule testing = FnTestingRule.createDefault();

    @Test
    public void shouldReturnGreeting() {
        testing.givenEvent().enqueue();
        testing.thenRun(OptaFunction.class, "handleRequest");

        FnResult result = testing.getOnlyResult();
        assertEquals("{ 'result': {{'problem': {}}}", result.getBodyAsString());
    }

}
