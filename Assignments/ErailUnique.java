package week3.Day2.Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		// Downloading the chrome browser
		WebDriverManager.chromedriver().setup();
				
		//Launching chrome Browser		
		ChromeDriver driver = new ChromeDriver();
						
		//Hitting the url
		driver.get("https://erail.in/");
			
		//Maximising the windows
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(5000);
		//Uncheck sort date check box
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("chkSelectDateOnly"))));
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		//clear and type in the source station
		WebElement sourceStation = driver.findElement(By.id("txtStationFrom"));
		sourceStation.clear();
		sourceStation.sendKeys("MAS",Keys.ENTER);
		
		//clear and type in the destination station
		WebElement destStation = driver.findElement(By.id("txtStationTo"));
		destStation.clear();
		destStation.sendKeys("VPT",Keys.ENTER);
		Thread.sleep(2000);
		
		//Find all the train names using xpath and store it in a list
		List<WebElement> trainNames = driver.findElements(By.xpath
				("//table[@class='DataTable TrainList TrainListHeader']/tbody/tr"));

		//Declare List and Set
		List<String> trainName = new ArrayList<String>();;
		Set<String> tname = new HashSet<String>();
		
		for (int i = 1; i <= trainNames.size(); i++) {
			String name = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']/tbody/tr["+i+"]/td[2]")).getText();
			trainName.add(name);
		}
		
		int noOfTrains = trainName.size();
		
		System.out.println(noOfTrains);
		
		for (int i = 0; i < trainName.size(); i++) {
			tname.add(trainName.get(i));	
		}

		System.out.println(tname.size());	
		
	}

}
