import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
// Set the chromedriver.exe file to JAVA class
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

//Launch ChromeBrowser
ChromeDriver driver = new ChromeDriver();

//Maximize the Browser
driver.manage().window().maximize();

//Open URL
driver.get("https://www.bigbasket.com/");

//Mouse over on  Shop by Category
Actions action = new Actions(driver);
WebElement tar1 = driver.findElementByXPath("//a[text()=' Shop by Category ']");
action.moveToElement(tar1).perform();

//Mouse over on FOODGRAINS, OIL & MASALA
WebElement tar2 = driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]");
action.moveToElement(tar2).perform();

//Mouse over on RICE & RICE PRODUCTS
WebElement tar3 = driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]");
action.moveToElement(tar3).perform();

//Click on Boiled & Steam Rice
WebElement tar31 = driver.findElementByXPath("(//a[text()='Boiled & Steam Rice'])[2]");
WebDriverWait wait = new WebDriverWait(driver,10);
wait.until(ExpectedConditions.elementToBeClickable(tar31));
tar31.click();

//Sleep for 3000 ms
Thread.sleep(3000);

//Choose the Brand as bb Royal
driver.findElementByXPath("(//span[text()='bb Royal'])[1]").click();

//Select Ponni Boiled Rice - Super Premium
WebElement tar4 = driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']");

//Select 5kg bag
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", tar4);
driver.findElementByXPath("//div[text()='5 kg']").click();

//Print the price of Rice
String price = driver.findElementByXPath("//td[@data-qa='productPrice']").getText();
System.out.println("Price of Ponni Boiled Rice:" + price);

//Sleep for 3000 ms
Thread.sleep(3000);

//Click on ADD TO BASKET
driver.findElementByXPath("//span[text()='ADD TO BASKET']").click();

//Verify the success message displayed
WebElement message = driver.findElementByXPath("//div[@id='toast']");
System.out.println(message);

//Type Dal in Search field and enter
driver.findElementByXPath("//input[@id='productSearch']").sendKeys("Dal",Keys.ENTER);

//Go to Toor/Arhar Dal and select 2kg & set Qty 2
driver.findElementByXPath("(//div[@qa='product_name']/a)[3]").click();
driver.findElementByXPath("//div[text()='2 kg']").click();
driver.findElementByXPath("//input[@name='qty']").sendKeys(Keys.BACK_SPACE,"2");

//Print the price of Dal
String price2 = driver.findElementByXPath("//td[@data-qa='productPrice']").getText();
System.out.println("Price of Toor/Arhar Dal :" + price2);

//Click on ADD TO BASKET
driver.findElementByXPath("//span[text()='ADD TO BASKET']").click();

//Mouse hover on My Basket
WebElement tar5 = driver.findElementByXPath("//div[@data-qa='myBasket']");
action.moveToElement(tar5).perform();

//Validate the Sub Total displayed for the selected items
String product1 = driver.findElementByXPath("(//div[@class='row mrp']/span)[1]").getText();
String product2 = driver.findElementByXPath("(//div[@class='row mrp']/span)[2]").getText();
String total = driver.findElementByXPath("//span[@style='float: right']/span").getText();
int sum = Integer.parseInt(product1)+Integer.parseInt(product2);
int subTotal = Integer.parseInt(total);
if (sum == subTotal) {
	System.out.println("Total amount matches the sum of individual product amount");
}else {
	System.out.println("Mismatch in amount information");
}

//Reduce the Quantity of Dal as 1 
driver.findElementByXPath("(//button[@ng-click = 'vm.decreamentQuantity(cartItem);'])[2]").click();

//Validate the Sub Total for the current items
String newProduct2 = driver.findElementByXPath("(//div[@class='row mrp']/span)[2]").getText();
String newTotal = driver.findElementByXPath("//span[@style='float: right']/span").getText();
int newSum = Integer.parseInt(product1)+Integer.parseInt(newProduct2);
int NewsubTotal = Integer.parseInt(newTotal);
if (newSum == NewsubTotal) {
	System.out.println("Total amount matches the sum of individual product amount after reducing the Quantity of Dal as 1 ");
}else {
	System.out.println("Mismatch in amount information after reducing the Quantity of Dal as 1");
}

//Close the Browser
driver.quit();
	}

}
