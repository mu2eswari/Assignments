package week4.Day1.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://dev68594.service-now.com/");
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);				

		driver.switchTo().frame("gsft_main");
	
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		
		driver.findElement(By.id("sysverb_login")).click();
		
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		
		driver.findElement(By.cssSelector("ul#concourse_application_tree>li:nth-of-type(15)>ul>li:nth-of-type(6)>div>div>a>div>div")).click();
		
		driver.switchTo().frame("gsft_main");
		
		
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		
		
	}

}
