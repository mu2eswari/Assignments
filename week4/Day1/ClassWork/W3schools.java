package week4.Day1.ClassWork;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3schools {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
	
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));		
		driver.findElement(By.xpath("//button[@onClick='myFunction()']")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);
		
		if(text.equals("You pressed Cancel!"))
		{
			System.out.println("verified");
		}
		driver.close();
	}

}
