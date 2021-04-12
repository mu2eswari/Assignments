package Week5.Day2.Classroom.copy;



import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CreateLead extends BaseClass {

	
	@Test(dataProvider = "leadDetails")
	public void runcreateLead(String company, String fname, String lname) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.name("submitButton")).click();
	}
	
	
	@DataProvider
	public String[][] leadDetails() throws IOException
	{
			
		LearnExcel excel = new LearnExcel();
		//String[][] data = excel.excel();
		return excel.excel();
	}
}






