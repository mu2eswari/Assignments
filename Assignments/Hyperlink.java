package week2.Assignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyperlink {

	public static void main(String[] args) throws InterruptedException {
		// This program is to launch the chromedriver
		
		// Downloading the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launching chrome Browser		
		ChromeDriver driver = new ChromeDriver();
				
		//Hitting the url
		
		driver.get("http://www.leafground.com/pages/Link.html");
		
		//Maximising the windows
		driver.manage().window().maximize();
		
		//Go to Home page
		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println("moved to Home page : "+driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[3]/a")).click();
		
		
		//Find page it is directing without clicking the link
		System.out.println(driver.findElement(By.linkText(
				"Find where am supposed to go without clicking me?")).getAttribute("href"));
		
		//Number of links in the page
		List<WebElement> findElementsByTagName = driver.findElementsByTagName("a");
		System.out.println(findElementsByTagName.size());
		
	}
	
}
