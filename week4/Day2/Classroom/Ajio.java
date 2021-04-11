package week4.Day2.Classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();	
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().window().maximize();
		
		//2) Enter Bags in the Search field and Select Women Handbags 
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("Bags",Keys.ENTER);
		driver.findElement(By.xpath("//label[@for='Women']")).click();
		
		//3) Click on five grid and Select SORT BY as "What's New" 
		driver.findElement(By.className("five-grid")).click();
		driver.findElement(By.xpath("//div[@class='filter-dropdown']//option[@value='newn']")).click();
		
		//4) Click Price on the side menu and Enter Price Range Min as 2000 and Max as 5000 
		driver.findElement(By.xpath("//div[@class='facet-head ']/span[contains(text(),'price')]")).click();
		driver.findElement(By.id("minPrice")).sendKeys("3000");
		driver.findElement(By.id("maxPrice")).sendKeys("5000",Keys.ENTER);
		
		//5) Click on the first product  
		driver.findElement(By.xpath("//div[@class='imgHolder']//img")).click();
		
		//6) Get the actual price, coupon code and discount price
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		
		System.out.println("The actual price is "+driver.findElement(By.className("prod-sp")).getText());
		String text = driver.findElement(By.className("promo-discounted-price")).getText();
		String discount = text.replaceAll("[^0-9]", "");
		System.out.println("The discount price is "+discount);
		
		String useCodeSPECIAL = driver.findElement(By.xpath("//div[@class='promo-title']")).getText();
		String replaceAll = useCodeSPECIAL.replaceAll("\n", "");
		String offer = replaceAll.replaceAll("Use Code", "");
		System.out.println(offer);
		
		//7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available 
		driver.findElement(By.xpath("//div[@class='edd-pincode-msg-container']/span[contains(text(),'Enter Pin')]")).click();
		driver.findElement(By.className("edd-pincode-modal-text")).sendKeys("560043");
		driver.findElement(By.className("edd-pincode-modal-submit-btn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='edd-message-success-container']/ul/li")).getText());
		
		//8) Click on Other Informations under Product Details and Print the Customer Care details 
		driver.findElement(By.className("ic-angle-down")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='mandatory-list']/div[contains(text(),'mail')]")).getText());
		
		//9)Click on ADD TO BAG and then GO TO BAG
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='popup-blk cart-blk']//div")).click();
		
		//10) Check the Order Total before apply coupon
		String rs = driver.findElement(By.xpath("//div[@class='net-price best-price-strip']")).getText();
		System.out.println(rs);
		
		//Enter coupon
		driver.findElement(By.id("couponCodeInput")).sendKeys(offer);
		
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
	/*	Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("//span[@class='voucher-error error-message info']")).getText();
		if(text2.equalsIgnoreCase("Invalid coupon"))
		{
			System.out.println("invalid coupon");
		}
		else
		{
			System.out.println("coupon applied");
		}*/
		
		driver.findElement(By.className("delete-btn")).click();
		driver.findElement(By.xpath("//div[@class='card-delet']//div/div[@class='delete-btn']")).click();
		Thread.sleep(2000);
		driver.quit();
		
	}

}
