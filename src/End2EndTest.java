import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class End2EndTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Select From dropdown list
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//Select To dropdown list
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		//Select de Depart date in the calendar
	    driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
	    //Verify the Return date calendar is disabled
	    if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"))
		{
			System.out.println("It is disabled");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	    //Select check box
	    driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
	    //Insert 5 passengers
	    driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		int i = 0;
		while(i<4) {
			driver.findElement(By.id("hrefIncAdt")).click(); //plus button
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		//Click on the Search button
		driver.findElement(By.cssSelector("input[id*='FindFlights']")).click();
	    
	}

}
