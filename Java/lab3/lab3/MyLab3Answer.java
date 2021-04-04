package lab3;

public class MyLab3Answer extends BaseClass 
{
	PGPText noises = new PGPText();
	PGPText movement = new PGPText();
	
	@Override
	public void createAnimals()
	{
		storeAnimal(new Lion());
		storeAnimal(new Bird());
		storeAnimal(new Fish());
		storeAnimal(new Mouse());
	}
	
	@Override
	public void recordMadeSound( String str )
	{
		System.out.println(str);
		noises.addLine(str);
	}
	
	@Override
	public void recordMoved( String str )
	{
		System.out.println(str);
		movement.addLine(str);
	}
	
	public void finish()
	{
		PGPFile file = new PGPFile();
		file.openWriteFile("output.txt");
		
		file.writeLine("List of noises made:");
		for (int i = 0; i < noises.getLineCount(); i++)
			file.writeLine(noises.getLine(i));
		
		file.writeLine("List of movement made:");
		for (int i = 0; i < noises.getLineCount(); i++)
			file.writeLine(movement.getLine(i));
		file.closeWriteFile();
	}
	
}
