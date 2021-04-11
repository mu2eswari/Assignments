package week4.Day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PepperFry {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//1) Go to https://www.pepperfry.com/
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		//2) Mouseover on Furniture and click Office Chairs under Chairs
		WebElement furniture = driver.findElement(By.xpath("//div[@class='menu_wrapper transition pf-navbar lazy-load']//li/a[text()='Furniture']"));

		Actions action = new Actions(driver);
		action.moveToElement(furniture).perform();
		Thread.sleep(1000);
		action.
		moveToElement(driver.findElement(By.xpath("//div[@class='hvr-col']/div[text()='Chairs']/following::div/div/a[text()='Office Chairs']"))).click().perform();

		//3) click Executive Chairs
		driver.findElement(By.xpath("//div[@class='cat-wrap-ttl']/h5[text()='Executive Chairs']")).click();
		
		//4) Change the minimum Height to 50 in under Dimensions
		WebElement min = driver.findElement(By.xpath("//li/div[text()='Height']/following::div/following::div/input"));
		
		min.clear();
		min.sendKeys("50",Keys.TAB);
		
		
		//5) Add "Galician High Back Executive Chair In Black Colour" chair to Wishlist
		Thread.sleep(2000);
		driver.findElement(By.xpath(
		"//div[@class='clip-prd-hrt pf-col xs-2']"
		+ "/a[@data-productname='Galician High Back Executive Chair in Black Colour']")).click();
		
		//6) Mouseover on Bedroom and Click Study tables
		WebElement bedroom = driver.findElement(By.xpath("//div[@class='menu_wrapper transition pf-navbar lazy-load']//li/a[text()='Bedroom']"));
		action.moveToElement(bedroom).perform();
		Thread.sleep(1000);
		action.
		moveToElement(driver.findElement(By.xpath("(//div[@class='hvr-col']/div[text()='Tables']/following::div/div/a[text()='Study Tables'])[3]"))).click().perform();
		
		//7) Select Spacewood as Brand
		driver.findElement(By.xpath("//input[@id='brandsnameSpacewood']/following::label")).click();

		Thread.sleep(3000);
		//8) Select Price as 7000 to 8000
		//driver.findElement(By.xpath("((//div[@class='clip__filter-title']//h2)[3]/following::input[@name='price']/following-sibling::label)[2]")).click();
		
		//driver.findElement(By.xpath("//li[@data-search='7000-8000']")).click();
		//9) Add "SOS Carter Study Table In Lorraine Walnut & Silver Grey Finish" to Wishlist

		driver.findElement(By.xpath("//a[@data-productname='SOS Carter Study Table in Lorraine walnut & silver grey Finish']")).click();
		
		String count = driver.findElement(By.xpath("//div[@class='header-nav-item wishlist']//span/span")).getText();
		int wishcount = Integer.parseInt(count);
		if(wishcount==2)
		{
			System.out.println("both are matching");
		}
		else
			System.out.println("not matching");
		
		//12) Move Table only to Cart from Wishlist
		driver.findElement(By.xpath("//div[@class='header-nav-item wishlist']//span/span")).click();
		
		driver.findElement(By.xpath("//a[text()='SOS Carter Study Table in Lorraine walnut & silver grey...']/following::div//a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Proceed to pay securely ']")).click();
		
		//issues in step 9 and from 12
	}

}
