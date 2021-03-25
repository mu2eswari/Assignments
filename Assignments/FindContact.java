package week2.Assignments;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindContact {

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
		
		//Click on Find Contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Find Contacts
		driver.findElement(By.linkText("Find Contacts")).click();
		
		//Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		//Email address
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("mu2eswari@gmail.com");
		
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(1000);
		
		//select table
	   driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//tr/td/div/a")).click();
	   
	   //Get first Name
	   System.out.println(driver.findElement(By.id("viewContact_fullName_sp")).getText());
	   
	   //Click on Edit
	   driver.findElement(By.linkText("Edit")).click();
	   
	   //New marketing campaign
	   WebElement mktCampaign = driver.findElement(By.id("addMarketingCampaignForm_marketingCampaignId"));
		
	   Select marketing = new Select(mktCampaign);
	   
	   marketing.selectByValue("9000");
		
	   driver.findElement(By.xpath("(//input[@class='smallSubmit'])[2]")).click();
	   
	   driver.findElement(By.id("updateContactForm_departmentName")).sendKeys("Selenium Automation Testing");
	   
	   driver.findElement(By.xpath("//input[@value='Update']")).click();
	   
	   String value = driver.findElement(By.id("viewContact_marketingCampaigns_sp")).getText();
	   
	   if(value.contains("eCommerce Site Internal Campaign"))
	   {
		   System.out.println("Verified that the contact is updated");
	   }
	   	}

}
