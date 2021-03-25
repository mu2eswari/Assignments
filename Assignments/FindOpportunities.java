package week2.Assignments;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOpportunities {

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
		
		driver.findElement(By.xpath("//ul[@class='sectionTabBar']/li[7]//a")).click();
		
		driver.findElement(By.linkText("Find Opportunities")).click();
		
		List<WebElement> table = driver.findElements(By.xpath("//div[@class='x-grid3-scroller']//table"));
		System.out.println(table.size());
		
		for (int i = 1; i <= table.size(); i++)
		{
			System.out.println(driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr/td/div[contains(@class,'OpportunityId')]/a)["+i+"]")).getText());
			
		}
		
}

}

/*

		//driver.findElement(By.xpath("//div[@class='x-grid3-scroller']//table//tr/td//a"));
		
	/*	WebElement table = driver.findElement(By.xpath("//div[@class='x-grid3-body']//tbody"));
		
		List<WebElement> findElement = table.findElements(By.tagName("div"));
		
		for (int i = 0; i <findElement.size(); i++) {
			
			System.out.println(findElement);
			
		}
		driver.close();
		
		for (int i = 0; i < table.size(); i++) 
		{
			
			
			System.out.println(table.get(i).getText());
			
		}
		
		System.out.println(table.size());*/









