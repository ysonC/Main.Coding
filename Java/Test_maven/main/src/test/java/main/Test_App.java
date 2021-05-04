package main;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import java.util.*;


public class Test_App 
{
    private final FBApp testing = new FBApp();
    public static ArrayList<FBTransaction> UserTransactions;
	public static ArrayList<FBCategory> UserCategories;

	public static void ChangeTransactionCategory(Scanner in) {
    	System.out.println("Which transaction ID?");
    	in.nextLine();
    	int tID = Integer.parseInt(in.nextLine());
    	System.out.println("\t- "+UserTransactions.get(tID-1).toString());
    	System.out.println("Which category will it move to?");
    	FBApp.CategoryOverview();
    	int newCat = Integer.parseInt(in.nextLine());
    	FBTransaction temp = UserTransactions.get(tID);
    	temp.setTransactionCategory(newCat);
    	UserTransactions.set(tID, temp);
    	FBCategory temp2 = UserCategories.get(newCat);
    	temp2.addExpense(temp.transactionValue());
    	UserCategories.set(newCat, temp2);
    }
	
	@BeforeAll
	public static void testsetup() 
	{
		
	}
	
    @Test
    public void test_ChangeTransactionCategory()
    {
		System.out.println("Hello");
		ChangeTransactionCategory(null);
    }
}
