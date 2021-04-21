import java.util.Scanner;

public class Generator {
	boolean IncludeUpper = false;
	boolean IncludeLower = false;
	boolean IncludeNum = false;
	static boolean IncludeSym = false;
	Alphabet alphabet;
	
	public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym)
	{
		alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
	}
	
	public Password GeneratePassword(int length)
	{
		final StringBuilder pass = new StringBuilder("");
		
		final int alphabetLength = alphabet.getAplhabet().length();
		
		int max = alphabetLength - 1;
		int min = 0;
		int range = max - min + 1;
		
		for(int i = 0; i < length; i++)
		{
			int index = (int) (Math.random() * range) + min;
			pass.append(alphabet.getAplhabet().charAt(index));
		}
		return new Password(pass.toString());
	}
	
	public static void printUsefullInfo()
	{
		System.out.println();
		System.out.println("Use a minimum password length of 8 or more characters if permitted");
		System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
		System.out.println("Generate passwords randomly where feasible");
		System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
		System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences,\nusernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).");
		System.out.println("Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user");
		System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
	}
	
	public static void requestPassword()
	{
		boolean IncludeUpper = false;
		boolean IncludeLower = false;
		boolean IncludeNum = false;
		boolean IncludeSym = false;
		String Input;
		final Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Hello Welcome to Password Generator :) answer"
				+ "the Following Question by Yes or No\n");
		
		while(true)
		{
			System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
			Input = in.nextLine();
			
			if(Input.equals("YES") || Input.equals("Yes") || Input.equals("yes"))
			{
				IncludeLower = true;
			}
			else
			{
				if(!(Input.equals("NO")) && (!Input.equals("No")) && (!Input.equals("no")))
				{
					PasswordRequestError();
					break;
				}
			}
			System.out.println("Do you want UpperCase letters \"ABCD...\" to be used? ");
			Input = in.nextLine();
			
			if(Input.equals("YES") || Input.equals("Yes") || Input.equals("yes"))
			{
				IncludeUpper = true;
			}
			else
			{
				if(!(Input.equals("NO")) && (!Input.equals("No")) && (!Input.equals("no")))
				{
					PasswordRequestError();
					break;
				}
			}
			System.out.println("Do you want Numbers \"1234...\" to be used? ");
			Input = in.nextLine();
			
			if(Input.equals("YES") || Input.equals("Yes") || Input.equals("yes"))
			{
				IncludeNum = true;
			}
			else
			{
				if((Input.equals("NO") == false) && (Input.equals("NO") == false) && (Input.equals("no") == false))
				{
					PasswordRequestError();
					break;
				}
			}
			System.out.println("Do you want symbols \"!@#$...\" to be used? ");
			Input = in.nextLine();
			
			if(Input.equals("YES") || Input.equals("Yes") || Input.equals("yes"))
			{
				IncludeSym = true;
			}
			else
			{
				if((Input.equals("NO") == false) && (Input.equals("No") == false) && (Input.equals("no") == false))
				{
					PasswordRequestError();
					break;
				}
			}
			
			//No pool Selected
			if(!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym)
			{
				System.out.println("You have selected no characters to generate your password at least one of your answers shpuld be yes ");
				break;
			}
			
			System.out.println("Great! Now Enter the length of the password ");
			int length = in.nextInt();
			
			final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
			
			final Password userPass = generator.GeneratePassword(length);
			
			System.out.println(userPass);
			
			in.close();
			break;
		}
	}
	public static void PasswordRequestError()
	{
		System.out.println("You have Entered Something incorrect let's go over it again\n");
	}
	
	public static void checkPassword()
	{
		String input;
		final Scanner in = new Scanner(System.in);
		
		System.out.println("\n Enter your Password: ");
		input = in.nextLine();
		
		final Password p = new Password(input);
		
		System.out.println(p.calculateScore());
		
		in.close();
	}
	
	public static void printMenu()
	{
		System.out.println();
		System.out.println("Enter 1 - Password Generator");
		System.out.println("Enter 2 - Password Strength Check");
		System.out.println("Enter 3 - useful Information");
		System.out.println("Enter 4 - Quit");
		System.out.println("choice: ");
	}
	
	public static void main(String[] args)
	{
		String Input;
		final Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Ziz Password Service : ");
		printMenu();
		while(in.hasNextLine())
		{
			Input = in.nextLine();
			
			if(Input.equals("1"))
			{
				requestPassword();
				printMenu();
			}
			else if (Input.equals("2"))
			{
				checkPassword();
				printMenu();
			}
			else if(Input.equals("3"))
			{
				printUsefullInfo();
				printMenu();
			}
			else if(Input.equals("4"))
			{
				break;
			}
			else
			{
				System.out.println();
				System.out.println("Kindly select one of the available commands ");
				printMenu();
			}
		}
		in.close();
	}
	

}
