import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Set the chromedriver.exe file to JAVA class
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Set ChromeDriver to execute in silent mode
		System.setProperty("webdriver.chrome.silentOutput", "true");

		// To disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		//Open Chrome browser
		ChromeDriver driver = new ChromeDriver(options);

		//Maximize the window
		driver.manage().window().maximize();

		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		//Go to URL - https://www.carwale.com/
		driver.get("https://www.ajio.com/shop/sale");
		
		//Enter Bags in the Search field
		driver.findElementByXPath("//input[@name='searchVal']").sendKeys("bags",Keys.ENTER);
		
		//Select Women from filter
		driver.findElementByXPath("//label[@class='facet-linkname facet-linkname-genderfilter facet-linkname-Women']").click();
		Thread.sleep(3000);
		
		//Enter Price Range Min as 2000 and Max as 5000
		driver.findElementByXPath("//span[text()='price']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@id='minPrice']").sendKeys("2000");
		driver.findElementByXPath("//input[@id='maxPrice']").sendKeys("5000",Keys.ENTER);
		Thread.sleep(3000);
		
		//Click on five grid
		driver.findElementByXPath("//div[@class='five-grid']").click();
		
		//Select SORT BY as "What's New"
		WebElement sortBy = driver.findElementByXPath("//div[@class='filter-dropdown']/select");
		Select select = new Select(sortBy);
		select.selectByVisibleText("What's New");
		Thread.sleep(3000);
		
		//Click on the product "Puma Ferrari LS Shoulder Bag" 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement tar = driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']");
		js.executeScript("arguments[0].click();", tar);
		Thread.sleep(3000);
		
		//Switch control of windows
		Set<String> wins = driver.getWindowHandles();
		ArrayList<String>winlis = new ArrayList<String>(wins);
		driver.switchTo().window(winlis.get(1));
		
		//Get Coupon code
		String text = driver.findElementByXPath("//div[@class='promo-title']").getText();
		String couponCode = text.replaceAll("Use Code", "");
		System.out.println(couponCode);
		
		//Actual Price of the product
		String actualPrice = driver.findElementByXPath("//div[@class='prod-sp']").getText();
		int actprice = Integer.parseInt(actualPrice.replaceAll("\\D", ""));
		System.out.println("Actual Price of the Product: Rs. " + actprice);
		
		//discounted price of the coupon
		String discountedPrice = driver.findElementByXPath("//div[@class='promo-discounted-price']/span").getText();
		int disPrice = Integer.parseInt(discountedPrice.replaceAll("\\D", ""));
		System.out.println(" Discounted Price of the Product: Rs. " + disPrice);
		
		//Savings on purchasing the product
		long estimatedSavings = actprice-disPrice;	
		System.out.println("Saving in Product Detail Section:"+estimatedSavings);
		//Enter PinCode
		driver.findElementByXPath("//span[text()='Enter pin-code to know estimated delivery date.']").click();
		driver.findElementByXPath("//input[@name='pincode']").sendKeys("635001");
		
		//Check the availability of the product for PinCode
		driver.findElementByXPath("//button[text()='CONFIRM PINCODE']").click();
		
		//print the expected delivery date if it is available
		String expectedDelivery = driver.findElementByXPath("//span[@class='edd-message-success-details-highlighted']").getText();
		System.out.println("Expected Delivery Date:"+expectedDelivery);
		
		//Click on Other Informations under Product Details and Print the Customer Care address, phone and email 
		driver.findElementByXPath("//div[text()='Other information']").click();
		String details = driver.findElementByXPath("//span[text()='Customer Care Address']/parent::li/span[@class='other-info']").getText();
		System.out.println("Cutomer Care Details:"+ details);
				
		// Click on ADD TO BAG
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		Thread.sleep(3000);
		
		// Go to Bag
		driver.findElementByXPath("//div[text()='PROCEED TO BAG']").click();
		
		
		//Check the Order Total before apply coupon
		String order = driver.findElementByXPath("//section[@id='orderTotal']/span[@class='price-value bold-font']").getText();
		System.out.println("Order Total before appling coupon :"+order);
		
		//Enter Coupon Code
		driver.findElementByXPath("//input[@id='couponCodeInput']").sendKeys(couponCode);
		
		//Click Apply
		driver.findElementByXPath("//button[text()='Apply']").click();
		Thread.sleep(3000);
		//Verify the Coupon Savings amount(round off if it in decimal) under Order Summary and the matches the amount calculated
		String coupon = driver.findElementByXPath("//section[@id='couponDiscount']/span[@class='price-value discount-price']").getText();
		String substring = coupon.substring(4);
		double couponSaving = Double.parseDouble(substring.replaceAll(",", ""));
		long couponSavings = Math.round(couponSaving);
		System.out.println("Coupon Savings : Rs."+couponSavings);
		if (estimatedSavings == couponSavings) {
			System.out.println("Coupon Savings amount under Order Summary  matches the amount calculated in Product details");
		}else {
			System.out.println("Coupon Savings amount under Order Summary does not match the amount calculated in Product details");
		}	
		
		//Click on Delete
		driver.findElementByXPath("//div[text()='Delete']").click();
		
		//Delete the item from Bag
		driver.findElementByXPath("//div[text()='DELETE']").click();
		
		//Close all the browsers
		driver.quit();
		}
