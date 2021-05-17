package main;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;


public class Test_App extends FBApp
{	

	private final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    public void setUpStream() //System.setOut tells System.out to send its output somewhere else.
    {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void cleanupStream()
    {
        System.setOut(originalOut);
    }
	

	@Test
	public void MainMethod_A_Test() 
	{
		String userInput = String.format("A\nTesco\n7.99"); // 
	    ByteArrayInputStream InContent = new ByteArrayInputStream(userInput.getBytes());
	    System.setIn(InContent);
	    FBApp.main(null);
	    String[] lines = outContent.toString().split(System.lineSeparator());
	    
		String actualOutput = lines[lines.length];
	    assertEquals("[Transaction added]", actualOutput);
		System.out.println("actualOutput");
	}

	@Test
	public void test_ChangeTransactionCategory()
	{
		// SETUP EXAMPLE DATA //
		UserCategories = new ArrayList<FBCategory>();
		UserTransactions = new ArrayList<FBTransaction>();

		FBCategory UnKnownCategory = new FBCategory("Unknown");
		UserCategories.add(UnKnownCategory);
		FBCategory BillsCategory = new FBCategory("Bills");
		BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
		UserCategories.add(BillsCategory);
		
		UserTransactions.add(new FBTransaction("Rent",new BigDecimal("850.00"),0));
		UserTransactions.add(new FBTransaction("Phone Bill", new BigDecimal("37.99"),1));
		
		for (int x = 0; x<UserTransactions.size(); x++) {
			FBTransaction temp = UserTransactions.get(x);
			int utCat = temp.transactionCategory();
			FBCategory temp2 = UserCategories.get(utCat);
			temp2.addExpense(temp.transactionValue());
			UserCategories.set(utCat, temp2);
		}
		// Setup end
		// Try moving rent to bill category
		// 1) Unknown(£0.00) - Est. £850.00 (£-850.00 remaining)  -- rent
		// 2) Bills(£120.00) - Est. £37.99 (£82.01 remaining)
		
		// 1) shoud equal 0 (Total (-) rent)
		// 2) shoud equal 887.99 (Total (+) rent)
        String input = "1\n" + "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

		BigDecimal tmp1, tmp2, tmp3, tmp4, tmp5, tmp6; 
		//(Total (+) rent)
		tmp1 = BillsCategory.CategorySpend();
		tmp2 = UserTransactions.get(0).transactionValue();//rent
		tmp3 = tmp1.add(tmp2);
		//(Total (+) rent)
		tmp4 = UnKnownCategory.CategorySpend(); 
		tmp5 = UserTransactions.get(0).transactionValue();
		tmp6 = tmp4.subtract(tmp5);

		FBApp.ChangeTransactionCategory();

		assertEquals(tmp6, UnKnownCategory.CategorySpend());
		assertEquals(tmp3, BillsCategory.CategorySpend());
		
	}

	@Test
	public void test_AddCategory()
	{
		// SETUP EXAMPLE DATA //
		UserCategories = new ArrayList<FBCategory>();
		UserTransactions = new ArrayList<FBTransaction>();

		FBCategory UnKnownCategory = new FBCategory("Unknown");
		UserCategories.add(UnKnownCategory);
		FBCategory BillsCategory = new FBCategory("Bills");
		BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
		UserCategories.add(BillsCategory);
		
		UserTransactions.add(new FBTransaction("Rent",new BigDecimal("850.00"),0));
		UserTransactions.add(new FBTransaction("Phone Bill", new BigDecimal("37.99"),1));
		
		for (int x = 0; x<UserTransactions.size(); x++) {
			FBTransaction temp = UserTransactions.get(x);
			int utCat = temp.transactionCategory();
			FBCategory temp2 = UserCategories.get(utCat);
			temp2.addExpense(temp.transactionValue());
			UserCategories.set(utCat, temp2);
		}
		// Setup end

		String input = "Test\n" + "999\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
		BigDecimal testBudget, testSpending;
		testBudget = new BigDecimal("999");
		testSpending = new BigDecimal("0.00");
		int maxOfArray = UserCategories.size();
		
		FBApp.AddCategory(); 

		assertNotNull(UserCategories.get(maxOfArray));
		assertEquals("Test" ,UserCategories.get(maxOfArray).CategoryName());
		assertEquals(testBudget,UserCategories.get(maxOfArray).CategoryBudget());
		assertEquals(testSpending, UserCategories.get(maxOfArray).CategorySpend());
	}
}
