package Week5.Assignment;



import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class CreateLead extends BaseClass {

	@BeforeClass
	public void setFileName()
	{
		file = "CreateLead";
	}
	
	
	@Test(dataProvider = "data")
	public void runcreateLead(String company, String fname, String lname) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.name("submitButton")).click();
	}
}






