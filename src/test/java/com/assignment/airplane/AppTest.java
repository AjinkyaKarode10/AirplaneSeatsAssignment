package com.assignment.airplane;

import static org.junit.Assert.assertEquals;
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
    public void allPassengerSeatedTestCase1()
    {
    	//App airplaneApp = new App();
    	String input = "[[3,2], [4,3], [2,3], [3,4]]";
    	assertEquals(30,App.runApp(input, 30));
    }
    
    @Test
    public void allPassengerSeatedTestCase2()
    {
    	//App airplaneApp = new App();
    	String input = "[[3,3], [4,3], [2,3], [4,4]]";
    	assertEquals(36,App.runApp(input, 36));
    }
}
