
public class Alphabet {
	public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE_LETTERS = "abcedfghijklmnopqrstuvwxyz";
	public static final String NUMBERS = "1234567890";
	public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
	
	private StringBuilder pool;
	
	public Alphabet(boolean uppercaseIncluded, boolean lowercaseInculded, boolean numbersIncluded, boolean specialCharacterIncluded)
	{
		pool = new StringBuilder();
		
		if(uppercaseIncluded)
		{
			pool.append(UPPERCASE_LETTERS);
		}
		
		if(lowercaseInculded)
		{
			pool.append(LOWERCASE_LETTERS);
		}
		if(numbersIncluded)
		{
			pool.append(NUMBERS);
		}
		if(specialCharacterIncluded)
		{
			pool.append(SYMBOLS);
		}	
	}
	
	public String getAplhabet()
	{
		return pool.toString();
	}

}
