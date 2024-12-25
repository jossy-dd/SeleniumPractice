import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		
		String name = "rahul";
		WebDriver driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("admin123");
		driver.findElement(By.className("signInBtn")).click();	
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Dinora");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("dinora@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("dinora@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("5417807965");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		String password = getPassword(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		System.out.println("You logged out");
		driver.quit();
	}
	
	public static String getPassword(String passwordText){
		String[] passwordArray = passwordText.split("'");
		String password = passwordArray[1].split("'")[0];
		return password;
	}
}
