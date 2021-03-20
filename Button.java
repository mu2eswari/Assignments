package week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) throws InterruptedException {
		// This program is to launch the chromedriver
		
		// Downloading the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launching chrome Browser		
		ChromeDriver driver = new ChromeDriver();
				
		//Hitting the url
		
		driver.get("http://www.leafground.com/pages/Button.html");
		
		//Maximising the windows
		
		driver.manage().window().maximize();

		//Click button to go to home page
		driver.findElement(By.id("home")).click();
	
		//Going back to button
		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[2]/a")).click();
		
		//Get position of a button
		WebElement position = driver.findElement(By.id("position"));
		System.out.println(position.getLocation());
		
		//Colour of button
		System.out.println("The colour of button is " +
				driver.findElement(By.id("color")).getCssValue("background-color"));
		
		//Size of button
		System.out.println("The size of button is "+ 
				driver.findElement(By.id("size")).getSize());
		
		
	}
	
}
