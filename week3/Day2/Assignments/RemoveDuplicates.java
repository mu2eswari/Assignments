package week3.Day2.Assignments;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {

		String value = "PayPal India";
		
		char[] charArray = value.toCharArray();
		
		Set<Character> charSet = new HashSet<Character>();
		
		Set<Character> dupcharSet = new HashSet<Character>();
		
		for (int i = 0; i < charArray.length; i++) {
		
			if(!charSet.add(charArray[i]))
			{
				dupcharSet.add(charArray[i]);
			}
		}
		
		System.out.println(charSet);
		System.out.println(dupcharSet);
		
		charSet.removeAll(dupcharSet);
		System.out.println(charSet);
	}

}
