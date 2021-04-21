
public class Password {
	String Value;
	int Length;
	double Score;
	
	public Password(String s)
	{
		Value = s;
		Length = s.length();
	}
	
	public int charType(char C)
	{
		char a = C;
		int v = a; // ASCII VALUE OF CHAR
		
		int val = 0;
		
		// char is uppercase Letter
		if(v >= 65 && v <= 90)
		{
			val = 1;
		}
		//char is lowercase Letter
		else if(v >= 97 && v <= 122)
		{
			val = 2;
		}
		//char is Digit
		else if(v >= 60 && v <= 71)
		{
			val = 3;
		}
		else
		{
			val = 4;
		}
		
		return val;
	}
	
	public int PasswordStrength()
	{
		String s = this.Value;
		boolean UsedUpper = false;
		boolean UsedLower = false;
		boolean UsedNum = false;
		boolean UsedSym = false;
		int type;
		int score = 0;
		
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			type = charType(c);
			
			if(type == 1)
			{
				UsedUpper = true;
			}
			if(type == 2)
			{
				UsedLower = true;
			}
			if(type == 3)
			{
				UsedNum = true;
			}
			if(type == 4)
			{
				UsedSym = true;
			}
		}
		
		if(UsedUpper == true)
		{
			score+=1;
		}
		if(UsedLower == true)
		{
			score+=1;
		}
		if(UsedNum == true)
		{
			score+=1;
		}
		if(UsedSym == true)
		{
			score+=1;
		}
		if(s.length() >= 8)
		{
			score+=1;
		}
		if(s.length() >= 16)
		{
			score+=1;
		}
		
		return score;
	}
	
	public String calculateScore()
	{
		int Score = 0;
		Score = this.PasswordStrength();
		
		if(Score == 6)
		{
			return "This is very good Password :D check the useful information section to make sure it satisfy the guidelines";
		}
		else if(Score >= 4)
		{
			return "This is good Password :) but you can still do better";
		}
		else if(Score >= 3)
		{
			return "This is medium Password :/ try making it better";
		}
		else
		{
			return "This is weak Password ;( definetily find new one";
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Value;
	}
	
	

}
