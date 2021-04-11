package week4.Day2.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		
		//2. Enter text as Perfumes in Search Bar and press Enter
		driver.findElement(By.id("SearchInputBox")).sendKeys("perfumes",Keys.ENTER);
		
		String total = driver.findElement(By.className("page-title-search-result")).getText();
				
		String[] split = total.split(" ");
		
		int count = Integer.parseInt(split[1]);
		System.out.println(count);
		
		//3. Get The Names Of all the Perfumes Displayed 
		//4. Get The Price of all the Perfumes Displayed
		int largeVal = 0;
		WebElement large = null;
		for (int i = 1; i <= count; i++)
		{
			WebElement item = driver.findElement(By.xpath("(//div[@class='m-content__product-list__title']/h2)["+i+"]"));
			String itemname = item.getText();
			System.out.print(i+ ". "+itemname);
			
			System.out.print("\t");
			
			String text = driver.findElement(By.xpath(
					"(//div[@class='clearfix m-content__product-list__price']//span[2]/span)["+i+"]")).getText();
			String replaceAll = text.replaceAll("[^0-9]", "");
			int price = Integer.parseInt(replaceAll);
			System.out.println(price);
			
			if(largeVal<price)
			{
				largeVal=price;
				large = item;
			}
			
		}
		
		//5. Click on the Highest Price Perfume  
		large.click();
		
		//6. Click on Add To Bag
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> perfume = new ArrayList<String>(windowHandles);
		driver.switchTo().window(perfume.get(1));
		
		driver.findElement(By.xpath("//div[@class='pull-left']/div/button")).click();
		
		//8. Click on bag Icon
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("AddBagIcon")));
		
		driver.findElement(By.className("AddBagIcon")).click();
		
		//9. Get the Grand Total Value
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText());
		
		//10. Click on Proceed
		//driver.findElement(By.className("second-col")).click();
		driver.findElement(By.xpath("//div[@class='second-col']/button")).click();
		
		//11. Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
		//12. Fill all the Fields in Address 
		driver.findElement(By.xpath("//input[@placeholder='name']")).sendKeys("Muthu",Keys.TAB,"asdffff@gmail.com",Keys.TAB,"8884793569","600121","My address");
		
		//13. Click on Paynow
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed big']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn fill full big proceed']")).click();
		
		//14. Get the Error Message displayed in Red Color
		for (int i = 1; i <=3; i++) {
			System.out.println(driver.findElement(By.xpath("(//span[@class='field-error'])["+i+"]")).getText());
			
		}
		
		driver.close();
		
		
	}

}
