package lab3;
public class Bear extends Animal
{
	@Override
	public String getName() 
	{ 
		return "I am a bear"; 
	}

	@Override
	public String getNoise()
	{
		return "The bear GROWLs";
	}
	
	@Override
	public String getMovement()
	{
		return "The bear runs";
	}
}
