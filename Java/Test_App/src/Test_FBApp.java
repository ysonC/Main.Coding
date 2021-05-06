import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class Test_FBApp extends FBApp
{

	
	@Test
	void testChangeTransactionCategory() 
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
		FBApp.CategoryOverview();
		FBApp.ListTransactions();
		
		
	}

	@Test
	void testAddCategory() 
	{
		
	}

}
