package main;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.jupiter.api.BeforeAll;
import java.util.*;


public class Test_App extends FBApp
{	

	@BeforeAll
	public static void testsetup() 
	{
		System.out.println("Hello");
		
	}
	
    @Test
    public void test_ChangeTransactionCategory()
    {
		FBApp testing = new FBApp();
		System.out.println("Hello");
		assertTrue(true);
		Scanner in = new Scanner("1");
		ListTransactionsForCategory(1);
	}

	@Test
	public void test_AddCategory()
	{
		Scanner in = new Scanner(System.in);
		FBApp.AddCategory(in);
	}

	@Test
	public void test_run()
	{
		// SETUP EXAMPLE DATA //
		UserCategories = new ArrayList<FBCategory>();
		UserTransactions = new ArrayList<FBTransaction>();

		UserCategories.add(new FBCategory("Unknown"));
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
	
		FBApp.CategoryOverview();
		FBApp.ListTransactions();
		Scanner in = new Scanner(System.in);

		FBApp.ChangeTransactionCategory(in);
		
	}
}
