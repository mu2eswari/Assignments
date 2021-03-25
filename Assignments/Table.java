package week2.Assignments;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) throws InterruptedException {
				
			

				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://leafground.com/pages/table.html");
				
				List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
				//find the number of rows in the webtable
				System.out.println(rows.size());
				
				//declare an empty array 
				int[] nums = new int[rows.size()-1];
				
				//to start from 2nd row to 5th row
				for (int i = 2; i <= rows.size(); i++) {
					
					
					//driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[3]/input")).click();
					
					
					
					  String text = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText(); //System.out.println(text.replace("%", ""));
					  
					  //to remove the characters except numbers 
					  String textPercentage = text.replaceAll("\\D", "");
					  
					  //to convert the string into Integer 
					  int parseInt = Integer.parseInt(textPercentage);
					  
					  //add the values into array 
					  nums[i-2] = parseInt;
					 
					
				}
				
				
				  //to sort the data in the array 
				  Arrays.sort(nums);
				  System.out.println("*******Least Value**********");
				  System.out.println(nums[0]);
				  driver.findElement(By.xpath("//td[contains(text(),'"+nums[0]+"')]/following-sibling::td/input")).click();
				 
			}

			
		}
/****My trial failures***/		
		
	/*	for(WebElement colname : columns)
		{
			String colName = colname.getText();
			if(colName.equals("Progress"));
			for(WebElement row : rows)
			{
				String rowval = row.getText();
				if(rowval.equals("Learn to interact using Keyboard, Actions"))
					System.out.println(row.findElement(By.xpath(row)));
			}
		}
		//Rows based on tag name
		
		
		
		/*for(WebElement mentorname : rows)
		{
			System.out.println(mentorname.getText());
		}*/
		
		



/*	WebElement table = driver.findElement(By.xpath("//table"));

//columns based on tag name
List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table_id']//tr/th"));

System.out.println("No.of Columns "+columns.size());
List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
System.out.println("No.of Rows "+rows.size());


for (int i = 1; i < rows.size(); i++)
{
	WebElement findElement = rows.get(i);//.findElement(By.tagName("td"));
	String rowHeader = findElement.findElement(By.tagName("td")).getText();
	//System.out.println(rowHeader);
	if(rowHeader.equals("Learn to interact with Elements"))
	{
		System.out.println(driver.findElement(By.xpath(findElement+i+"/td[2]")));//.getText());
	}
	
	
	*/
	

