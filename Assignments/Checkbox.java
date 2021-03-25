package week2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {
		// This program is to automate the dropdown page of testleaf ground
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/checkbox.html");
		
		boolean selected = driver.findElement(By.xpath("//div[text()='SQL']")).isSelected();
		
		System.out.println("Is the checkbox selected "+selected);
		driver.close();

	}

}
