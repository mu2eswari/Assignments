package week3.Day2.Assignments;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Appear {

	public static void main(String[] args) {
	
		// Downloading the chrome browser
				WebDriverManager.chromedriver().setup();
				
				//Launching chrome Browser		
				ChromeDriver driver = new ChromeDriver();
						
				//Hitting the url
				
				driver.get("http://www.leafground.com/pages/appear.html");
				
				//Maximising the windows
				
				driver.manage().window().maximize();
				
				WebDriverWait wait = new WebDriverWait(driver,10);
				
			//	List<WebElement> findElements = 
				//		driver.findElements(By.xpath("//div[@class='flex']/button"));		
				WebElement magic = driver.findElement(By.id("btn"));
				
				wait.until(ExpectedConditions.visibilityOf(magic));
				System.out.println("found");
	}

}
