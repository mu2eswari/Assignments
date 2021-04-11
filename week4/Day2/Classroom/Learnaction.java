package week4.Day2.Classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learnaction {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		WebElement selenium = driver.findElement(By.xpath("//section[@class='innerblock']/div[6]//option[text()='Selenium']"));
		
		WebElement load = driver.findElement(By.xpath("//section[@class='innerblock']/div[6]//option[text()='Loadrunner']"));
		
		Actions action = new Actions(driver);
		
		action.keyDown(Keys.CONTROL).click(selenium).click(load).keyUp(Keys.CONTROL).perform();
		
	}

}
