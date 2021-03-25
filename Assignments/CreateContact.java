package week2.Assignments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException, IOException {
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
		
				
		//Click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on Create Lead
		driver.findElement(By.linkText("Create Contact")).click();
		
		//Enter First Name
		driver.findElement(By.id("firstNameField")).sendKeys("Mutheswari");
		
		//Enter Last Name
		driver.findElement(By.id("lastNameField")).sendKeys("Muthuraj");
		
		//Enter First Name(local)
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Muthu");
		
		//Enter Last Name(local)
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("eswari");
				
		//Enter department
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("ECE");
		
		//createContactForm_description
		driver.findElement(By.id("createContactForm_description")).sendKeys("My contact");
		
		//createContactForm_primaryEmail
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("mu2eswari@gmail.com");
		
		//Selecting NewYork
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		
		Select province = new Select(state);
		province.selectByVisibleText("New York");
		
		//Click create contact
		
		driver.findElement(By.className("smallSubmit")).click();
		
		//Snapshot
		File snap = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(snap,new File( "./snapshot/output.jpg"));
		
		//Click on edit
		driver.findElement(By.linkText("Edit")).click();
		
		//clear description
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		//importanct note
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("important note");
		
		//click on update
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		//Title of newly loaded page
		System.out.println(driver.getTitle());
				
		
		
		Thread.sleep(1000);
		
		driver.quit();

	}

}
