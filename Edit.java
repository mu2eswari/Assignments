package week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {

	public static void main(String[] args) throws InterruptedException {
		// This program is to launch the chromedriver
		
		// Downloading the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launching chrome Browser		
		ChromeDriver driver = new ChromeDriver();
				
		//Hitting the url
		
		driver.get("http://www.leafground.com/pages/Edit.html");
		
		//Maximising the windows
		
		driver.manage().window().maximize();
		
		// Enter your email id
		driver.findElement(By.id("email")).sendKeys("mu2eswari@gmail.com");
		
		//Append the text
		WebElement append = driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));
		append.sendKeys("added");
		append.sendKeys(Keys.TAB);
		
				
		//Get default text
		System.out.println(driver.findElement(By.name("username")).getAttribute("value"));
		
		//Clear the text
		driver.findElement(By.xpath("(//input[@name=\"username\"])[2]")).clear();
		
		//Check edit field is disabled
		if(!(driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).isEnabled()))
		{
			System.out.println("Field is Disabled");
		}
		else
			System.out.println("Field is enabled");
	}

}
