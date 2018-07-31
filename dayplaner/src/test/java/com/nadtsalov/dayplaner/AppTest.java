package com.nadtsalov.dayplaner;

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
    public void testGui()
    {
        new MainGui().startApp();
    }

    @Test
    public void testA(){
        new EnterTask().openEnterArea();
    }
}
