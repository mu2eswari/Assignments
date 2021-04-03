package week3.Day2.Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortUsingCollection {

	public static void main(String[] args) {
		
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		
		int length = input.length;
		
		List<String> companies = new ArrayList<String>();
		
		for (int i = 0; i < length; i++)
		{
			
			companies.add(input[i]);
		}

		Collections.sort(companies);
		
		Collections.reverse(companies);
		
		System.out.println(companies);
	}

}
