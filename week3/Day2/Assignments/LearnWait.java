package week3.Day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWait {

	public static void main(String[] args) {
		// Downloading the chrome browser
		WebDriverManager.chromedriver().setup();
				
		//Launching chrome Browser		
		ChromeDriver driver = new ChromeDriver();
						
		//Hitting the url
		driver.get("http://www.leafground.com/pages/disapper.html");
			
		//Maximising the windows
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement disapper = driver.findElement(By.id("btn"));
		wait.until(ExpectedConditions.invisibilityOf(disapper));
		System.out.println("The element disappeared");
		WebElement findElement = driver.findElement(By.id("show"));
		if(findElement.getText().contains("Button is disappeared!"))
		{
			System.out.println("Verified that the text appeared");
		}
}

}
