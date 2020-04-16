import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
// Set the chromedriver.exe file to JAVA class
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

//Launch ChromeBrowser
ChromeDriver driver =new ChromeDriver();

//Maximize Browser
driver.manage().window().maximize();

//Open URL
driver.get("https://www.nykaa.com/");

//Mouse over on Brands 
Actions a = new Actions(driver);
WebElement brands = driver.findElementByXPath("//a[text()='brands']");
a.moveToElement(brands).perform();

//Mouse over on popular
WebElement popular = driver.findElementByXPath("//a[text()='Popular']");
a.moveToElement(popular).perform();
Thread.sleep(3000);

//Click on L'Oreal Paris
driver.findElementByXPath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']").click();

//Switch the control of window
Set<String> win = driver.getWindowHandles();
ArrayList<String>winlis = new ArrayList<String>(win);
driver.switchTo().window(winlis.get(1));

//Verify the title of new window
String title = driver.findElementByXPath("//a[@href='/brands/loreal-paris/c/595']").getText();
if (title.contains("L'Oreal Paris")) {
System.out.println(" Window title contains L'Oreal Paris");
}

//Select options under Category section
driver.findElementByXPath("//div[text()='Category']").click();
driver.findElementByXPath("//span[text()='Shampoo (21)']").click();
driver.findElementByXPath("//span[text()='Shampoo (16)']").click();
Thread.sleep(3000);

//Select options under Sort By section
driver.findElementByXPath("//span[@class='pull-right'] / i").click();
driver.findElementByXPath("//span[text()='customer top rated']").click();

//Verify filter field values
String text = driver.findElementByXPath("//li[text()='Shampoo']").getText();
if (text.contains("Shampoo")) {
	System.out.println("Filter is applied with Shampoo successfully");
	}
Thread.sleep(3000);

//Select product from display
driver.findElementByXPath("//h2[@title=\"L'Oreal Paris Colour Protect Shampoo\"]/span").click();

//Switch the control of window
Set<String> win1 = driver.getWindowHandles();
ArrayList<String>winlis1 = new ArrayList<String>(win1);
driver.switchTo().window(winlis1.get(2));
Thread.sleep(3000);

//Choose specification of the product
driver.findElementByXPath("//span[text()='175ml']").click();

//Print MRP of the product
String price = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
System.out.println("Price of L'Oreal Paris Colour Protect Shampoo 175 ml = "+ price);

//Adding product to Bag
driver.findElementByXPath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]").click();

//Verify product inside Bag and print its Grand Total
driver.findElementByXPath("//div[@class='AddBagIcon']").click();
Thread.sleep(3000);
String grandTotal = driver.findElementByXPath("(//div[@class='value'])[4]").getText();
System.out.println("Grand Total:"+grandTotal);

//Proceed for personal details
driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();

//Switch the control of window
Set<String> win2 = driver.getWindowHandles();
ArrayList<String>winlis2 = new ArrayList<String>(win2);
driver.switchTo().window(winlis2.get(2));

//Continue as Guest login
driver.findElementByXPath("//button[@class='btn full big']").click();
Thread.sleep(3000);

//Get Warning Message
String message = driver.findElementByXPath("//div[@class='message']").getText();
System.out.println("Warning Message:"+message);

//Close all windows
driver.quit();

	}

}
