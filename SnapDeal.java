import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

// Set the chromedriver.exe file to JAVA class
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

//Set ChromeDriver to execute in silent mode
System.setProperty("webdriver.chrome.silentOutput", "true");

//Launch ChromeBrowser
ChromeDriver driver = new ChromeDriver();

//Maximize Browser
driver.manage().window().maximize();

//Implicit Wait
driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

//Get URL
driver.get("https://www.snapdeal.com/");

//Mouse over on Toys, Kids' Fashion & more and click on Toys
WebElement tar1 = driver.findElementByXPath("//span[text()=\"Toys, Kids' Fashion & more\"]");
Actions action = new Actions(driver);
action.moveToElement(tar1).perform();
driver.findElementByXPath("//span[text()='Educational Toys']").click();

//Click the Customer Rating 4 star and Up 
Thread.sleep(3000);
driver.findElementByXPath("//div[@data-name='avgRating']//label[@for='avgRating-4.0']").click();

//Click the offer as 40-50
Thread.sleep(3000);
driver.findElementByXPath("//div[@data-name='discount']//label[@for='discount-40%20-%2050']").click();

//Check the availability for the pincode
driver.findElementByXPath("//input[@placeholder='Enter your pincode']").sendKeys("600028");
Thread.sleep(3000);
driver.findElementByXPath("//input[@placeholder='Enter your pincode']/following-sibling::button").click();

//Click the Quick View of the first product 
Thread.sleep(3000);
WebElement tar2 = driver.findElementByXPath("(//p[@class='product-title'])[1]");
action.moveToElement(tar2).perform();
driver.findElementByXPath("//div[contains(text(),'Quick View')]").click();

//Click on View Details
Thread.sleep(3000);
driver.findElementByXPath("//a[contains(text(),'view details')]").click();

//Capture the Price of the Product and Delivery Charge
String price1 = driver.findElementByXPath("//span[@class='payBlkBig']").getText();
System.out.println("Price of 1st product:"+price1);
String deliveryCharge1 = driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText();
System.out.println(deliveryCharge1);
driver.findElementByXPath("//span[text()='add to cart']").click();
String youPay1 = driver.findElementByXPath("//div[@class='you-pay']/span").getText();
System.out.println(youPay1);

//Validate the You Pay amount matches the sum of (price+deliver charge)
int total1 = Integer.parseInt(price1) + Integer.parseInt(deliveryCharge1.replaceAll("\\D", ""));
if (Integer.parseInt(youPay1.replaceAll("\\D", ""))== total1 ) {
	System.out.println("You Pay amount matches the sum of (price+deliver charge)");
}else {
	System.out.println("You Pay amount does not match with the sum of (price+deliver charge)");
}

//Search for Sanitizer
driver.findElementByXPath("//input[@placeholder='Search products & brands']").sendKeys("Sanitizer",Keys.ENTER);

//Click on Product "BioAyurveda Neem Power Hand Sanitizer"
driver.findElementByXPath("//p[text()='BioAyurveda Neem Power  Hand Sanitizer 500 mL Pack of 1']").click();

//Capture the Price and Delivery Charge
Set<String> win = driver.getWindowHandles();
ArrayList<String> winlis = new ArrayList<String>(win);
driver.switchTo().window(winlis.get(1));
String price2 = driver.findElementByXPath("//span[@class='payBlkBig']").getText();
System.out.println("Price of 2nd product:"+price2);
String deliveryCharge2 = driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText();
System.out.println(deliveryCharge2);

//Click on Add to Cart
Thread.sleep(3000);
driver.findElementByXPath("(//span[text()='ADD TO CART'])[1]").click();
driver.navigate().refresh();
int total2 = Integer.parseInt(price2) + Integer.parseInt(deliveryCharge2.replaceAll("\\D", ""));
System.out.println(total2);

//Click on Cart 
driver.findElementByXPath("//span[text()='Cart']").click();
String youPay2 = driver.findElementByXPath("//input[@class='btn btn-xl rippleWhite cart-button']").getAttribute("value");
System.out.println(youPay2);

//Validate the Proceed to Pay matches the total amount of both the products
int total = Integer.parseInt(youPay2.replaceAll("\\D", ""));
if (total == (total1+total2)) {
	System.out.println("You Pay amount matches the sum of (price+deliver charge)");
}else {
	System.out.println("You Pay amount does not match with the sum of (price+deliver charge)");
}

//Close all the windows
driver.quit();
	}

}
