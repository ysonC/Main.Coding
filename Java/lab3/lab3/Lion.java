package lab3;
public class Lion extends Animal
{
	@Override
	public String getName() 
	{ 
		return "I am a Lion"; 
	}

	@Override
	public String getNoise()
	{
		return "The Lion Roars!";
	}


	@Override
	public String getMovement()
	{
		return "The Lion prowls";
	}
}

