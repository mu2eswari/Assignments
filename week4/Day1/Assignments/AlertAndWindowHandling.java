package week4.Day1.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAndWindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		
		//click ok on alert
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		
		//3. Click on FLIGHTS link             // New window
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
		//4. Go to the Flights tab
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> flight = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(flight.get(1));
		
		//System.out.println(driver.getTitle());
		
		//5. Print the customer care email id
		
		String flightCustCare = 
				driver.findElement(By.xpath("//a[@class='d-block font-weight-bold']")).getText();
		
		System.out.println("Customer care mail "+flightCustCare);
		
		//6. Close the First tab(Train ticket booking) alone
		driver.switchTo().window(flight.get(0));
		driver.close();
			
	}

}
