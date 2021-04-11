package week4.Day1.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);				

		WebElement findElement = driver.findElement
				(By.xpath("//div[@id='leftNavMenuRevamp']/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]"));
		WebElement sport = driver.findElement(By.xpath("//div[@id='category6Data']/div//p[2]"));		
		Actions action = new Actions(driver);
		action.moveToElement(findElement).moveToElement(sport).click().perform();
		//span[text()='Sports Shoes']
		
		
		String count = driver.findElement(By.className("category-count")).getText();
		
		String replaceAll = count.replaceAll("[^0-9]", "");
		int sCount = Integer.parseInt(replaceAll);
		
		System.out.println("Total number of shoes "+sCount);
		
		driver.findElement(By.xpath("//a[@class='child-cat-node dp-widget-link hashAdded']/div[text()='Training Shoes']")).click();
		
		driver.findElement(By.className("sort-selected")).click();
	/*	WebElement lToH = driver.findElement(By.xpath("//li[@class='search-li']/span"));
		action.moveToElement(lToH).click().perform();
		//driver.findElement(By.xpath("//li[@class='search-li']/span")).click();
		*/
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		Thread.sleep(2000);
		
		String rs = driver.findElement(By.xpath("//span[@class='lfloat product-price']")).getText();
		System.out.println(rs);
		
		String first = rs.replaceAll("[^0-9]", "");
		first.replaceAll(" ", "");
		System.out.println(first);
		int parseInt = Integer.parseInt(first);
		
		String rs1 = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[2]")).getText();
		System.out.println(rs1);
		
		String second = rs1.replaceAll("[^0-9]", "");
		second.replaceAll(" ", "");
		int parseInt2 = Integer.parseInt(second);
		
		if(parseInt<parseInt2)
		{
			System.out.println("sorted");
		}
		else
			System.out.println("not sorted");
	
		WebElement blue = driver.findElement(By.xpath("//a[@class='dp-widget-link noUdLine']/p[contains(text(),'Rock Blue')]"));
		
		WebElement quick = driver.findElement(By.xpath("//a[@class='dp-widget-link noUdLine']/p[contains(text(),'Rock Blue')]/preceding::div[@class='clearfix row-disc']"));
		action.moveToElement(blue);
		action.moveToElement(quick);
		System.out.println("moved");
		action.click().perform();
		
		
		File snap = driver.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(snap,new File( "./snapshot/output.jpg"));
		
		String cost = driver.findElement(By.className("payBlkBig")).getText();
		System.out.println("Cost of the shoe "+cost);
		
		String disc = driver.findElement(By.xpath("(//div[@class='product-price pdp-e-i-PAY-l clearfix']/span)[2]")).getText();
		System.out.println("Cost of the shoe "+disc);
		
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		
		driver.close();

	}

}
