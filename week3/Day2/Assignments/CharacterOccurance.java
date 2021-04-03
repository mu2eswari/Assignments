package week3.Day2.Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class CharacterOccurance {

	public static void main(String[] args) {
		
		String input = "Mutheswari Muthuraj";
		
		char[] charArray = input.toCharArray();
		
		HashMap<Character, Integer> occuranceMap = new HashMap<Character, Integer>();
		
		for(char c : charArray)
		{
			if(occuranceMap.containsKey(c))
			{
				occuranceMap.put(c, occuranceMap.get(c)+1);
			}
			
			else
			{
				occuranceMap.put(c, 1);
			}
		}
		
		for (Entry<Character, Integer> entry : occuranceMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
	}

}
