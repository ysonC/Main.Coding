import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
	
public class Main
{
	public static int add(int x, int y)
	{
		return x + y;
	}

	public static void main(String[] args) 
	{
		System.out.println(add(1,2));
	}

	@Test
	public void testadd()
	{
		assertEquals(25, add (24,1));
		assertEquals(4, add(4,1));
	}
}