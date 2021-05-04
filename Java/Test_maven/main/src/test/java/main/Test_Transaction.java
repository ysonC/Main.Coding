package main;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;



public class Test_Transaction 
{    

    static private FBTransaction testingDefault;
	static private FBTransaction testingMain;	
	static private String testName;
	static private BigDecimal testValue;
	static private int testCategory;
	
	@BeforeAll
	public static void testsetup() {	
		testingDefault = new FBTransaction();
		testName = "name";
		testValue = new BigDecimal("84.50");
		testCategory = 1;
		testingMain = new FBTransaction(testName, testValue, testCategory);
	}

	@Test
	public void test_defaultConstructor() {
		assertEquals(0,testingDefault.transactionCategory);	
		assertEquals("[Pending transaction]",testingDefault.transactionName);
		assertNull(testingDefault.transactionValue);
		assertNotNull(testingDefault.transactionTime);
	}
	
	@Test 
	public void test_mainConstructor() {
		assertEquals(testName, testingMain.transactionName);
		assertEquals(testValue, testingMain.transactionValue);
		assertEquals(testCategory, testingMain.transactionCategory);
	}
	
	@Test
	public void test_transactionName() {
		String givenName = testingMain.transactionName();
		assertEquals(testName, givenName);
	}

	@Test
	public void test_transactionValue() {
		BigDecimal givenValue = testingMain.transactionValue();
		assertSame(testValue, givenValue);
        System.out.println(testValue);
        System.out.println(givenValue);
        System.out.println("Hello");
        
	}

	@Test
	public void test_transactionCategory() {
		int givenCategory = testingMain.transactionCategory();
		assertEquals(testCategory, givenCategory);
	}
	
	@Test 
	public void test_transactionTime() {
		assertSame(testingMain.transactionTime, testingMain.transactionTime());
	}
	
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
