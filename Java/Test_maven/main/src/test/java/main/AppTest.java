package main;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.Test;



public class AppTest 
{    
    @Test
    public void test_transaction()
    {
        FBTransaction testing = new FBTransaction();
        assertNull(testing.transactionTime());
        assertSame(testing.transactionTime(),testing.transactionTime());
    }
    
    @Test
    public void test_setTransactionName()
    {
        FBTransaction testing = new FBTransaction();
        testing.setTransactionName("Apple");
        //The name should change
        assertEquals("Apple",testing.transactionName());

        // test when null name enter, transactionName should stay the same
        String null_name = null;
        testing.setTransactionName(null_name);
        assertEquals("Apple",testing.transactionName());
        
    }

    @Test
    public void test_setTransactionValue()
    {
        FBTransaction testing1 = new FBTransaction();
        FBTransaction testing2 = new FBTransaction();
        FBTransaction testing3 = new FBTransaction();
        BigDecimal test_value_1 = new BigDecimal(1);
        BigDecimal test_value_0 = new BigDecimal(0);
        BigDecimal test_value_n1 = new BigDecimal(-1);

        testing1.setTransactionValue(test_value_1);
        assertEquals(test_value_1,testing1.transactionValue());

        testing2.setTransactionValue(test_value_0);
        assertEquals(null,testing2.transactionValue());

        testing3.setTransactionValue(test_value_n1);
        assertEquals(null,testing3.transactionValue());

    }

    @Test
    public void test_setTransactionCategory()
    {
        FBTransaction testing1 = new FBTransaction();
        FBTransaction testing2 = new FBTransaction();
        int test_value_neg = -10;
        int test_value_pos = 10;
        testing1.setTransactionCategory(test_value_neg);
        //check when negative int is inserted
        assertEquals(0,testing1.transactionCategory());

        testing2.setTransactionCategory(test_value_pos);
        //check when positive int is inserted
        assertEquals(test_value_pos,testing2.transactionCategory());
    }

    @Test
    public void test_setTransactionTime()
    {
        FBTransaction testing1 = new FBTransaction();
        FBTransaction testing2 = new FBTransaction();
        Date test_date_null = new Date();
        test_date_null = null;
        Date test_date = new Date();
        testing1.setTransactionTime(test_date_null);
        assertNull(testing1.transactionTime());
        testing2.setTransactionTime(test_date);
        assertEquals(test_date, testing2.transactionTime());
    }

    @Test
    public void test_toString()
    {
        FBTransaction testing = new FBTransaction();
        testing.setTransactionName("Apple");
        testing.setTransactionValue(new BigDecimal(100));
        assertEquals("Apple - £100", testing.toString());
    }
}
