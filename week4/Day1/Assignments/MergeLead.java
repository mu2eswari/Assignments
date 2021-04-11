package week4.Day1.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//2. Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//type the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click login button
		driver.findElement(By.className("decorativeSubmit")).click();
				
		//Click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//click leads tab
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
				
		driver.findElement
		(By.xpath("//div[@class='frameSectionBody']//li/a[contains(text(),'Merge Leads')]")).click();
		
		driver.findElement
		(By.xpath("//input[@name='ComboBox_partyIdFrom']/following::img[@src='/images/fieldlookup.gif']")).click();
		
		Set<String> from = driver.getWindowHandles();
		
		List<String> fromLead = new ArrayList<String>(from);
		
		driver.switchTo().window(fromLead.get(1));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("id")).sendKeys("10325");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='10325']")).click();//10169
		
		driver.switchTo().window(fromLead.get(0));
		
		driver.findElement(By.xpath("//input[@name='ComboBox_partyIdTo']/following::img[@src='/images/fieldlookup.gif']")).click();
		
		Set<String> to = driver.getWindowHandles();
		
		List<String> toLead = new ArrayList<String>(to);
		
		driver.switchTo().window(toLead.get(1));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("id")).sendKeys("10318");//10319//10320
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='10318']")).click();
		
		driver.switchTo().window(toLead.get(0));
		
		driver.findElement(By.className("buttonDangerous")).click();
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
	//	WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='selected']"))));
		
		//driver.findElement(By.xpath("//a[@class='selected']")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();
		
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input")).sendKeys("10317");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		
		String text = driver.findElement(By.className("x-paging-info")).getText();
		
		if(text.contains("No records to display"))
		{
			System.out.println("Merged Leads");
		}
		else
			System.out.println("Not merged");
	}

}
