package week3.Day2.Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args) {
	
		// Downloading the chrome browser
				WebDriverManager.chromedriver().setup();
				
				//Launching chrome Browser		
				ChromeDriver driver = new ChromeDriver();
						
				//Hitting the url
				
				driver.get("http://leafground.com/pages/TextChange.html");
				
				//Maximising the windows
				
				driver.manage().window().maximize();
				
				WebDriverWait wait = new WebDriverWait(driver,10);
				
				//WebElement button = driver.findElement(By.xpath("//button[@id='btn']"));
				
				wait.until(ExpectedConditions.textToBe(By.xpath("//button[@id='btn']"), "Click ME!"));
				
				System.out.println(driver.findElement(By.xpath("//button[@id='btn']")).getText());
				
				
			//	String windowHandle = driver.getWindowHandle();
				driver.findElement(By.id("btn")).click();
				try {
					Alert alert = driver.switchTo().alert();
					System.out.println("Alert is present");
					alert.accept();
					driver.quit();
					}// try
					catch (Exception e) {
						String windowHandle2 = driver.getWindowHandle();
						System.out.println(windowHandle2);
					}// catch		
		
	}

}
