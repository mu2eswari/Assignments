package week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// This program is to launch the chromedriver
		
		// Downloading the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launching chrome Browser		
		ChromeDriver driver = new ChromeDriver();
				
		//Hitting the url
		
		driver.get("http://leaftaps.com/opentaps");
		
		//Maximising the windows
		
		driver.manage().window().maximize();
		
		// type the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//type the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click login button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Get the title value
		System.out.println(driver.getTitle());
		
		//Click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("My company");
		
		//Enter First Name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Mutheswari");
		
		//Enter First Name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Muthuraj");
		
		//Click on Create lead
		driver.findElement(By.className("smallSubmit")).click();
		
		//Title of newly loaded page
		System.out.println(driver.getTitle());
				
		
		
		Thread.sleep(1000);
		
		driver.quit();

	}

}
