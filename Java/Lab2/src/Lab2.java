
public class Lab2 
{
	
	static void changeString( StringBuffer copyOfWord )
	{
		StringBuffer word = new StringBuffer(copyOfWord);
		int len = copyOfWord.length();
		int i;
		for (i = 0; i < len / 2; i++) // Corrected from <= initially!!!
		{
			char temp = word.charAt(i);
			//message[i] = message[len - i - 1];
			word.setCharAt(i,word.charAt(i));
			//message[len - i - 1] = temp;
			word.setCharAt(len - i - 1, temp);
		}
	}
	public static void main(String[] args) 
	{
		if (args.length < 2) // Not enough command line arguments
		{
			System.out.print("You need to provide the word to decode on the command line.\n");
			//return 1; // Failure
		}
		// Create a copy of the word which we can actually modify
		// Remember room for terminal nul in C, so length + 1 in C
		
		//char* copyOfWord = (char*)malloc(strlen(argv[1]) + 1);
		StringBuffer copyOfWord = new StringBuffer();
		copyOfWord = args.toString();
		// Note: you will need to u	se new not malloc in java to create a new object
		// Copy input word into our editable buffer
		//strcpy(copyOfWord, argv[1]);
		//copyOfWord.replace(0, copyOfWord.length(), args);
		
		// reverse the word
		changeString(copyOfWord/*Word to change*/);
		
		// Output the word
		System.out.print("Reversed word is:");
		System.out.print(copyOfWord);
		// Java will do this for you - no need to free in java
		//free(copyOfWord);
		// Success
		//return 0;
	}

}
