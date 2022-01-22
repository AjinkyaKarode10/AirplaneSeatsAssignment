package com.assignment.airplane;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
    	App airplaneApp = new App();
    	String input = "[[3,2], [4,3], [2,3], [3,4]]";
    	airplaneApp.parseInputStringData(input);
        assertTrue( true );
    }
}
