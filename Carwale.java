import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Carwale {

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
driver.get("https://www.carwale.com/");

// Click on Used Cars
driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
Thread.sleep(3000);

// Select the City as Chennai
driver.findElementByXPath("//input[@id='usedCarsList']").sendKeys("Chennai");
Thread.sleep(3000);
driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
Thread.sleep(3000);

// Select budget min (8L) and max(12L) and Click Search
driver.findElementByXPath("//li[@data-min-price='8']").click();
driver.findElementByXPath("//li[@data-max-price='12']").click();
driver.findElementByXPath("//button[@id='btnFindCar']").click();

// Select Cars with Photos under Only Show Cars 
driver.findElementByXPath("//span[text()='Cars with Photos']").click();
Thread.sleep(3000);

// Select Manufacturer as "Hyundai" --> Creta
Actions action = new Actions(driver);
action.sendKeys(Keys.PAGE_DOWN).perform();
Thread.sleep(3000);
driver.findElementByXPath("//span[@class='filterText' and contains(text(),'Hyundai')]").click();
driver.findElementByXPath("//span[@class='model-txt' and contains(text(),'Creta')]").click();

// Select Fuel Type as Petrol
driver.findElementByXPath("//div[@id='3']/h3[contains(text(),'Fuel Type')]").click();
driver.findElementByXPath("//span[text()='Petrol']").click();

// Select Best Match as "KM: Low to High"
WebElement drop = driver.findElementByXPath("//select[@id='sort']");
Select select = new Select(drop);
select.selectByVisibleText("KM: Low to High");
 
//Click on "Don't show anymore tips" 
driver.findElementByLinkText("Don't show anymore tips").click();
Thread.sleep(3000);

// Validate the Cars are listed with KMs Low to High Add the least KM ran car to Wishlist
List<WebElement> list = driver.findElements(By.xpath("//span[@class='slkms vehicle-data__item']"));
int n = list.size();
System.out.println(n);
int[] alist = new int[n];
int count =0;
for (int i = 0; i <n-1; i++) {
	alist[i] = (Integer.parseInt(list.get(i).getText().replaceAll("\\D", "")));
	alist[i+1]= (Integer.parseInt(list.get(i+1).getText().replaceAll("\\D", "")));
	if (alist[i]<alist[i+1]) {
		System.out.println(alist[i+1]+"km is in low to high order");
		count ++;
				             }else 
				             {
					System.out.println(alist[i+1]+"km is in high to low order");
					if (alist[i+1]<alist[0]) {
						System.out.println(alist[i+1]+"is the least km");
						action.sendKeys(Keys.PAGE_DOWN).perform();
						action.sendKeys(Keys.PAGE_DOWN).perform();
						driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])["+(i+1)+"+1]").click();
						
					                          }else 
					                          {
					     System.out.println(alist[0]+"km is the least km");
						driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])[1]").click();
					                          }
					           }
	
	
if (count==4) {
	System.out.println(alist[0]+"km is the least km");
	driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])[1]").click();
}
}
Thread.sleep(3000);

// Go to Wishlist and Click on More Details
driver.findElementByXPath("//ul[@class='rightfloat inner-div']/li[@class='action-box shortlistBtn']").click();
driver.findElementByLinkText("More details »").click();

// Print all the details under Overview in the Same way as displayed in application 
Set<String> wins = driver.getWindowHandles();
ArrayList<String> winlis = new ArrayList<String>(wins);
driver.switchTo().window(winlis.get(1));
List<WebElement> elekey = driver.findElementsByXPath("//div[@id='overview']//ul//div[@class='equal-width text-light-grey']");
List<WebElement> elevalue = driver.findElementsByXPath("//div[@id='overview']//ul//div[@class='equal-width dark-text']");
LinkedHashMap<String, String> Overview = new LinkedHashMap<String,String>();
for (int i = 0; i < elekey.size(); i++) {
	String key = elekey.get(i).getText();
	String value = elevalue.get(i).getText();
	Overview.put(key,value);	
}
for (Entry<String, String> j : Overview.entrySet())
{
System.out.println("Car Details");
System.out.println(j.getKey()+" = "+j.getValue());
}

// Close the browser
driver.quit();
	}
}
