package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Testrun 
{
    //change System.outis going to rather than to print out, 
    // we’ll create a place for it to go. Inside your test class, add the following variable
    private final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    // @BeforeEach
    // public void setUpStream() //System.setOut tells System.out to send its output somewhere else.
    // {
    //     System.setOut(new PrintStream(outContent));
    // }

    // @AfterEach
    // public void cleanupStream()
    // {
    //     System.setOut(originalOut);
    // }

    @Test
    public void testprinhello()
    {
        inoutsystem ios = new inoutsystem();
        ios.printhello();
        assertEquals("hello", outContent.toString());
    }

    @Test
    public void testwatitsay()
    {
        inoutsystem ios = new inoutsystem();
        String input = "hello2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ios.printwatitsay();

        assertEquals("hello2", outContent.toString());
    }

    @Test
    public void testtest()
    {
        String tmp2 = "10001111" + "222222";
        BigDecimal tmp = new BigDecimal(tmp2);
        System.out.println(tmp);
    }
}
