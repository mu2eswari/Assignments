package week4.Day1.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseWindow {


	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
	
		//Click on multiple window button
		driver.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]")).click();
		
		//Get all opened windows
		Set<String> windowHandles = driver.getWindowHandles();
		
		//Print the no.of windows
		System.out.println(windowHandles.size());
		
		
	//	List<String> windows = new ArrayList<String>(windowHandles);
		
		String originalHandle = driver.getWindowHandle();


	    for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }

	    driver.switchTo().window(originalHandle);
	}


}
