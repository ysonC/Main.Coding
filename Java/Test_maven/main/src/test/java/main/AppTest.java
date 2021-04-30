package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;


public class AppTest 
{
    // static private FBTransaction testing;

    // @BeforeAll
    // static void test_setup()
    // {
    //     testing = new FBTransaction();
    // }


    @Test
    public void test_transaction()
    {
        FBTransaction testing = new FBTransaction();
        assertNotNull(testing.transactionTime());
        assertSame(testing.transactionTime(),testing.transactionTime());
    }

    @Test
    public void test_setTransactionName()
    {
        FBTransaction testing = new FBTransaction();
        
    }

    @Test
    public void test_setTransactionValue()
    {

    }
}
