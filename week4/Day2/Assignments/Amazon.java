package week4.Day2.Assignments;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//1) Go to https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//2. Type "one plus 7 pro mobiles" in Search Box and Enter
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 7 pro mobiles",Keys.ENTER);
		
		//3. Print the price of the first resulting mobile
		System.out.println(driver.findElement(By.xpath("(//span[@class='a-price-symbol']/following-sibling::span)[1]")).getText());
		
		//4. Click on the Mobile (First resulting) image
		driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();
		
		//5. Switch to the new window
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> mobile = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(mobile.get(1));
		
		//6. Print the number of customer ratings
		System.out.println("No.of customers rated this product "+driver.findElement(By.xpath("(//span[@id='acrCustomerReviewText'])[1]")).getText());
		
		//7. Click 'Add to Cart'
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//8. Confirm "Added to Cart" text message appeared
		Thread.sleep(2000);
		try
		{
		boolean displayed = driver.findElement(By.xpath("(//h4[text()='Added to Cart'])[2]")).isDisplayed();
		if(displayed)
		{
			System.out.println("item is added to the cart successfully");
		}
		
		}
		catch(Exception e)
		{
			System.out.println("In exception : Item not added");
		}
		
		//9. Click on Proceed to checkout		
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-checkout-button']/span/input")).click();
		
		
		//10. Confirm the title is "Amazon Sign In"
		if(driver.getTitle().contains("Amazon Sign In"))
		{
			System.out.println("Title verified");
		}
		else
		{
			System.out.println("Title is wrong");
		}
		
		
		//11. Click Continue (without entering mobile number/email)
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		
		//12. Verify the error message: Enter your email or mobile phone number
		if(driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]")).getText().contains("Enter your email or mobile phone number"))
		{
			System.out.println("Error message displayed");
		}
		else
		{
			System.out.println("Error message not displayed");
		}
		
		//13. Close both browsers
		driver.quit();
	}

}
