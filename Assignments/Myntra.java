package week3.Day2.Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		// Downloading the chrome browser
		WebDriverManager.chromedriver().setup();

		// Launching chrome Browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		// Hitting the url
		driver.get("https://www.myntra.com/");

		// Maximising the windows
		driver.manage().window().maximize();

		// Selecting Jackets and coats from women
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[contains(text(),'Women')]")))
				.build().perform();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("//div[@data-group='women']/li[2]//li[10]"))).click();
		a.build().perform();

		/*
		 * 4) Find the total count of item 5) Validate the sum of categories count
		 * matches
		 */

		Thread.sleep(2000);

		//Check Coats
		driver.findElement(By.xpath("(//label[@class='common-customCheckbox vertical-filters-label'])[2]")).click();

		//Click +more under brand
		driver.findElement(By.className("brand-more")).click();

		//Type MANGO in the textbox 
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("MANGO");

		//Click the checkbox
		driver.findElement(By.className("FilterDirectory-count")).click();

		//click on close
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();

		List<WebElement> findElements = driver.findElements(By.xpath("//li[@class='product-base']"));

		System.out.println(findElements.size());
	
		a.moveToElement(driver.findElement(By.className("sort-sortBy"))).build().perform();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("(//label[@class='sort-label '])[3]"))).click();
		a.build().perform();

	}

}

/*****************************************************************************
 * 
 * 
 * for (int i = 0; i < 134; i++) { items =
 * driver.findElements(By.xpath("//ul[@class='results-base']/li"));
 * 
 * driver.findElement(By.className("pagination-arrowRight")).click();
 * 
 * 
 * 
 * 
 * 
 * // String noOfPages =
 * driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/div[2]/ul/li[1]/text()[4]")).getText();
 * // List<WebElement> items= null; // noOfPages.replace("[^0-9]", ""); //
 * System.out.println(noOfPages);
 * 
 * 
 * 
 * /* for (int i = 0; i < findElements.size(); i++) { String text =
 * findElements.get(i).getText(); if(!text.equalsIgnoreCase("MANGO")) {
 * System.out.println("wrong product "+ text); break; }
 * 
 * }
 */
