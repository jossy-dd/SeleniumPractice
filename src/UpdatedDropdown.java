import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//driver.get("https://www.spicejet.com/");
		
		//Checkbox
		//Verify the checkbox is NOT selected
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		//Verify if the checkbox is selected
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//Count and print number of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//Radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//Verify if the second calendar now is enabled
		//driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled();
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1"))
		{
			System.out.println("Its enabled");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		//dropdown list
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		int i = 1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click(); //plus button
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}
}
