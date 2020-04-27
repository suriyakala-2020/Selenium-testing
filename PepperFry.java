import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PepperFry {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

// Set the chromedriver.exe file to JAVA class
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

// Set ChromeDriver to execute in silent mode
System.setProperty("webdriver.chrome.silentOutput", "true");

// Launch ChromeBrowser
ChromeDriver driver =new ChromeDriver();

// Maximize browser
driver.manage().window().maximize();

// Implicit Wait
driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

// Get url
driver.get("https://www.pepperfry.com/");

// Mouse over on Furniture and click Office Chairs under Chairs
Actions action = new Actions(driver);
WebElement tar1 = driver.findElementByXPath("//ul/li/a[@rel='meta-furniture']");
action.moveToElement(tar1).perform();
driver.findElementByLinkText("Office Chairs").click();

// Click Executive Chairs
driver.findElementByXPath("//div/h5[text()='Executive Chairs']").click();

// Change the minimum Height as 50 in under Dimensions
driver.findElementByXPath("(//div/input[@class='clipFilterDimensionHeightValue'])[1]").sendKeys(Keys.CLEAR);
driver.findElementByXPath("(//div/input[@class='clipFilterDimensionHeightValue'])[1]").sendKeys("50",Keys.ENTER);

// Block pop-up
try {
	driver.findElementByXPath("//div[@class='popup-box gb-modal reg_modal']/a[@class='popup-close']").click();
} catch (NoSuchElementException e) {
	// TODO: handle exception
	System.out.println("");
}

// Add "Poise Executive Chair in Black Colour" chair to Wishlist
driver.findElementByXPath("//a[@data-productid='1499699']").click();

// Mouseover on Homeware and Click Pressure Cookers under Cookware
WebElement tar2 = driver.findElementByXPath("//ul/li/a[text()='Homeware']");
action.moveToElement(tar2).perform();
driver.findElementByXPath("//a[text()='Pressure Cookers']").click();

// Select Capacity as 1-3 Ltr
driver.findElementByXPath("//div/li/label[text()='1 Ltr - 3 Ltr']").click();
Thread.sleep(3000);

// Select Prestige as Brand
driver.findElementByXPath("//label[text()='Prestige']").click();
Thread.sleep(3000);

// Add "Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr" to Wishlist
driver.findElementByLinkText("Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr").click();
Set<String> wins1 = driver.getWindowHandles();
ArrayList<String> winlis1 = new ArrayList<String>(wins1);
driver.switchTo().window(winlis1.get(1));
driver.findElementByXPath("//div[@class='wishlist-right']/a/span").click();
Thread.sleep(3000);

// Verify the number of items in Wishlist
String count = driver.findElementByXPath("(//span[@class='count_alert'])[2]").getText();
if (Integer.parseInt(count) == 2) {
	System.out.println("Items added to Wishlist Successfully");
}else {
	System.out.println("Items not properly added to Wishlist");
}

// Navigate to Wishlist
driver.findElementByXPath("//a[@class='pf-icon pf-icon-heart header_tab wistlist_img pending_alert']").click();
Thread.sleep(3000);

// Move Pressure Cooker only to Cart from Wishlist
WebElement tar3 = driver.findElementByXPath("//a[@data-wishlistitem='1676140']");
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click()", tar3);
Thread.sleep(3000);

// Check for the availability for Pincode 600128
driver.findElementByXPath("//div[@class='pin_block']/input").sendKeys("600128");
driver.findElementByXPath("//div[@class='pin_block']/a").click();
Thread.sleep(3000);

// Click Proceed to Pay Securely
driver.findElementByXPath("//a[text()='Proceed to pay securely ']").click();

// Click Proceed to Pay
driver.findElementByXPath("(//a[text()='PLACE ORDER'])[1]").click();

// Capture the screenshot of the item under Order Item
driver.findElementByXPath("//span[text()='ORDER SUMMARY']").click();
Thread.sleep(3000);
WebElement ele = driver.findElementByXPath("//div[@class='slick-track']//li");
File source = ele.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(source, new File("./target/screenshots/ele.png"));

// Close browser
driver.quit();
	}

}
