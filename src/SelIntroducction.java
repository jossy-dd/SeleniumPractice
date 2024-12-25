import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroducction{
	
	public static void main(String[] args) {
		
		//Invoking the Browser
		//Chrome -> ChromeDriver -> Methods
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl()); 
		driver.close();
	}
}
