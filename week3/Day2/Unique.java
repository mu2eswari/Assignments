package week3.Day2;

import java.util.HashSet;
import java.util.Set;

public class Unique {

	public static void main(String[] args) {

		String companyName = "TESTLEAF";
		
		char[] charArray = companyName.toCharArray();
		
		Set<Character> unique = new HashSet<Character>();
		
		for (int i = 0; i < charArray.length; i++) 
		{
			if(unique.add(charArray[i]))
			{
				System.out.print(charArray[i]);
			}
		}
	}

}
