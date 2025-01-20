import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		String name = "Jossy";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Type the name
		driver.findElement(By.id("name")).sendKeys(name);
		//Click on the Alert button
		driver.findElement(By.id("alertbtn")).click();
		String messageAlert1 = driver.switchTo().alert().getText();
		System.out.println(messageAlert1);
		//Click on the OK button
		driver.switchTo().alert().accept();
		//Click on the Confirm button
		driver.findElement(By.id("confirmbtn")).click();
		String messageAlert2 = driver.switchTo().alert().getText();
		System.out.println(messageAlert2);
		//Click on the Cancel button
		driver.switchTo().alert().dismiss();
	}
}
