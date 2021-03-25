package week2.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		// This program is to automate the dropdown page of testleaf ground
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		//Selecting by index
		WebElement dd1 = driver.findElement(By.id("dropdown1"));
		
		Select index = new Select(dd1);
		index.selectByIndex(2);
		
		//Selecting by visible text
		WebElement dd2 = driver.findElement(By.name("dropdown2"));
		
		Select text = new Select(dd2);
		text.selectByVisibleText("Loadrunner");
		
		//Selecting by the value
		WebElement dd3 = driver.findElement(By.id("dropdown3"));
		
		Select value = new Select(dd3);
		value.selectByValue("1");
		
		//Count of elements in the dd
		WebElement dd4 = driver.findElement(By.className("dropdown"));
		
		Select count = new Select(dd4);
		List<WebElement> options = count.getOptions();
		System.out.println(options.size());
		
		
		driver.findElement(By.xpath("//section[@class='innerblock']/div[5]/select")).sendKeys("Selenium");
		
		//section[@class='innerblock']/div[6]/select
		
		WebElement dd5 = driver.findElement(By.xpath("//section[@class='innerblock']/div[6]/select"));
		
		Select multi = new Select(dd5);
		multi.selectByValue("1");
		multi.selectByIndex(3);
		
		
		driver.close();

	}

}
