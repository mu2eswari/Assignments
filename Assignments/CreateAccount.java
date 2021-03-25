package week2.Assignments;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		// This program is to launch the chromedriver
		
		// Downloading the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launching chrome Browser		
		ChromeDriver driver = new ChromeDriver();
				
		//Hitting the url
		
		driver.get("http://leaftaps.com/opentaps");
		
		//Maximising the windows
		
		driver.manage().window().maximize();
		
		// type the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//type the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click login button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Get the title value
		System.out.println(driver.getTitle());
		
		//Click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on Create Account
		driver.findElement(By.linkText("Create Account")).click();
		
		//Create Account
		driver.findElement(By.id("accountName")).sendKeys("Training Account 100");//Account Name
		
		driver.findElement(By.name("parentPartyId")).sendKeys("Sales");//Parent Account

		driver.findElement(By.id("groupNameLocal")).sendKeys("Eswari");//Local Name
		
		driver.findElement(By.id("officeSiteName")).sendKeys("Chennai");//Site Name
		
		driver.findElement(By.id("annualRevenue")).sendKeys("100000");//annualRevenue
		
		//Selecting currency
		WebElement currency = driver.findElement(By.id("currencyUomId"));
		Select currency1 = new Select(currency);
		currency1.selectByVisibleText("BRR - Brazil");
		
		//Selecting Industry
		WebElement industry = driver.findElement(By.name("industryEnumId"));
		Select industry1 = new Select(industry);
		industry1.selectByVisibleText("Aerospace");
				
		driver.findElement(By.id("numberEmployees")).sendKeys("10000");//Number of Employees
		
		//Selecting Ownership
		WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
		Select owner = new Select(ownership);
		owner.selectByVisibleText("Sole Proprietorship");
		
		driver.findElement(By.id("sicCode")).sendKeys("2001");//SIC Code
		
		driver.findElement(By.id("tickerSymbol")).sendKeys("Camera");//Ticker symbol
		
		//Select Source
		WebElement eleSource = driver.findElement(By.name("dataSourceId"));
		Select source = new Select(eleSource);
		source.selectByVisibleText("Conference");
		
		//Select Marketing Campaign
		WebElement mkcamp = driver.findElement(By.name("marketingCampaignId"));
		Select marketing = new Select(mkcamp);
		marketing.selectByVisibleText("Automobile");
		
		//Select Initial Team
		WebElement initteam = driver.findElement(By.name("initialTeamPartyId"));
		Select initial = new Select(initteam);
		initial.selectByValue("DemoSalesTeam1");
		
		
		driver.findElement(By.name("description")).sendKeys("New Account");//description
		
		driver.findElement(By.name("importantNote")).sendKeys("Very important account");//importantNote
		
		//Contact information
		
		driver.findElement(By.id("primaryPhoneCountryCode")).sendKeys("91");//Country code
		
		driver.findElement(By.id("primaryPhoneAreaCode")).sendKeys("091");//Area code
		
		driver.findElement(By.id("primaryPhoneNumber")).sendKeys("8884793569");//Phone number
		
		driver.findElement(By.id("primaryPhoneExtension")).sendKeys("001");//Extension
		
		driver.findElement(By.id("primaryPhoneAskForName")).sendKeys("Muthu");//Person to ask for
		
		driver.findElement(By.id("primaryEmail")).sendKeys("mu2eswari@gmail.com");//mail id
		
		driver.findElement(By.id("primaryWebUrl")).sendKeys("https://mycompany.in");//Web Url
		
		//Primary Address
		
		driver.findElement(By.id("generalToName")).sendKeys("Arun");//To Name
		
		driver.findElement(By.id("generalAttnName")).sendKeys("Junai");//Attention Name
		
		driver.findElement(By.id("generalAddress1")).sendKeys("Anna Street");//Address line 1
		
		driver.findElement(By.id("generalAddress2")).sendKeys("Madipakkam");//Address line2
		
		driver.findElement(By.id("generalCity")).sendKeys("Chennai");//City
		
		driver.findElement(By.id("generalPostalCode")).sendKeys("600091");//PIN code
		
		driver.findElement(By.id("generalPostalCodeExt")).sendKeys("0000");//PIN Extension
		
		//Select Country
		WebElement country = driver.findElement(By.name("generalCountryGeoId"));
		Select geo = new Select(country);
		geo.selectByValue("IND");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Select Country
		WebElement state = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select province = new Select(state);
		province.selectByVisibleText("TAMILNADU");
		
		//Click on Create lead
		driver.findElement(By.className("smallSubmit")).click();
		
	}

}
