import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shoppingCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//products to add to the cart
		String[] shoppingList = {"Cucumber", "Brocolli", "Beetroot"};
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i = 0; i < products.size(); i++) {
			//format to get only the product name
			String productName = products.get(i).getText().split("-")[0].trim();
			//Check if the product is in the list
			List shopL = Arrays.asList(shoppingList);
			if(shopL.contains(productName)) {
				//click on Add to cart button
				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				if(j == shopL.size()) { break; }
			}
		}
	}

}
