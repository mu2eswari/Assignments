package week3.Day1.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void NoOfBuses(ChromeDriver driver, String type) throws InterruptedException//why it asked me to change method to static
	{
	Thread.sleep(2000);
	String Buses = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
	String count = Buses.replaceAll("[^0-9]","");
	System.out.println(count + type);
	}


	public static void main(String[] args) throws InterruptedException {
	
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		ChromeDriver driver = new ChromeDriver(options);
				
		driver.get("https://www.redbus.in/");
		
		driver.manage().window().maximize();
		
				//Selecting From station
		driver.findElement(By.xpath("//div[@class='fl search-box clearfix']/div/input")).sendKeys("c");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='fl search-box clearfix']/div/input")).sendKeys(Keys.DOWN,Keys.ENTER);
		
		//Selecting To station
		driver.findElement(By.xpath("//div[@class='fl search-box']//input")).sendKeys("B");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='fl search-box']//input")).sendKeys(Keys.TAB);
		
		//Selecting 1st day in next month
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		driver.findElement(By.xpath("//tr[@class='rb-monthHeader']/td[3]/button")).click();
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']//tr[3]/td[text()='1']")).click();
		
		//Finding the buses
		driver.findElement(By.id("search_btn")).click();
		
		//Total Number of buses
		NoOfBuses(driver," buses in this route");
		Thread.sleep(3000);
		//Close corona popup
		driver.findElement(By.xpath("//div[@class='overlay-container']//i")).click();
		
		//Select sleeper buses
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		
		NoOfBuses(driver," Sleeper buses in this route");
		
		//Select AC - Sleeper buses
		driver.findElement(By.xpath("//label[@for='bt_AC']")).click();
		
		NoOfBuses(driver," AC - Sleeper buses in this route");
		
		
		//Costly Bus
		//driver.findElement(By.xpath("//div[@class='sort-sec clearfix onward ']//a[text()='Fare']")).click();
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='sort-sec clearfix onward ']//a[text()='Fare']"));
		actions.doubleClick(elementLocator).perform();
		
		String text = driver.findElement(By.xpath("(//div[@class='column-two p-right-10 w-30 fl']/div)[1]")).getText();
		System.out.println("The costliest bus is "+text);
		
		driver.close();
	}

}



