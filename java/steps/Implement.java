package steps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Implement {
ChromeDriver driver;
Actions action;

@Given("User open the chrome browser")
public void openBrowser() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver = new ChromeDriver(options);
}
@Given("User maximise the browser")
public void maximiseBrowser() {
	driver.manage().window().maximize();
}
@Given("User set the default implicit timeout")
public void setTimeout() {
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
}
@Given("User load the URL")
public void openUrl() {
	driver.get("https://www.carwale.com/");
}
@Given("User click on Used Cars")
public void clickUserCars() {
	driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
}
@Given("User select the City as Chennai")
public void selectCity() throws InterruptedException {
	Thread.sleep(5000);
	driver.switchTo().frame("verloop-iframe");
	driver.findElementByXPath("//div[@class='close js-close-livechat']").click();
	driver.switchTo().defaultContent();
	driver.findElementByXPath("//input[@id='usedCarsList']").sendKeys("Chennai");
	Thread.sleep(3000);
	driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();

}
@Given("User select budget min as (.*)")
public void selectMinBudget(String min) throws InterruptedException {
	driver.findElementByXPath("//input[@id='minInput']").sendKeys(min);	
}
@Given("User select budget max as (.*)")
public void selectMaxBudget(String max) throws InterruptedException {
	driver.findElementByXPath("//input[@id='maxInput']").sendKeys(max);	
}
@Given("User click on search")
public void clickSearch() {
	driver.findElementByXPath("//button[@id='btnFindCar']").click();
}
@Given("User click on search cars with photos")
public void clickSearchCars() throws InterruptedException {
	driver.findElementByXPath("//span[text()='Cars with Photos']").click();
	Thread.sleep(3000);
}
@Given("User select manufacture as Hyundai Creta")
public void selectCarModel() throws InterruptedException {
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).perform();
	Thread.sleep(3000);
	driver.findElementByXPath("//span[@class='filterText' and contains(text(),'Hyundai')]").click();
	driver.findElementByXPath("//span[@class='model-txt' and contains(text(),'Creta')]").click();
}
@Given("User select fuel type as petrol")
public void selectFuel() {
	driver.findElementByXPath("//div[@id='3']/h3[contains(text(),'Fuel Type')]").click();
	driver.findElementByXPath("//span[text()='Petrol']").click();
}
@Given("User select best match as KM: Low to High")
public void sortBy() {
	WebElement drop = driver.findElementByXPath("//select[@id='sort']");
	Select select = new Select(drop);
	select.selectByVisibleText("KM: Low to High");
}
@Given("User validate the cars are listed with KMs Low to High")
public void validateCars() throws InterruptedException {
	driver.findElementByLinkText("Don't show anymore tips").click();
	Thread.sleep(3000);
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
		
		
	if (count==n-1) {
		System.out.println(alist[0]+"km is the least km");
		driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])[1]").click();
	}
	}
	}
@Given("User add the least KM ran car to wishlist")
public void clickAddWishlist() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElementByXPath("//ul[@class='rightfloat inner-div']/li[@class='action-box shortlistBtn']").click();
	}
@Given("User click on wishlist")
public void clickWishlist() throws InterruptedException {
	driver.executeScript("arguments[0].click", driver.findElementByXPath("//li[@class='action-box shortlistBtn overflowVisible']"));
}
@Given("User click on more details")
public void clickMoreDetails() {
	driver.findElementByLinkText("More details »").click();
}
@When("User print all the details under Overview")
public void displayCarDetails() {
	Set<String> wins = driver.getWindowHandles();
	ArrayList<String> winlis = new ArrayList<String>(wins);
	driver.switchTo().window(winlis.get(1));
	List<WebElement> elekey = driver.findElementsByXPath("//div[@id='overview']//ul//div[@class='equal-width text-light-grey']");
	List<WebElement> elevalue = driver.findElementsByXPath("//div[@id='overview']//ul//div[@class='equal-width dark-text']");
	LinkedHashMap<String, String> Overview = new LinkedHashMap<String,String>();
	System.out.println("Car Details");
	for (int i = 0; i < elekey.size(); i++) {
		String key = elekey.get(i).getText();
		String value = elevalue.get(i).getText();
		Overview.put(key,value);	
	}
	for (Entry<String, String> j : Overview.entrySet())
	{

	System.out.println(j.getKey()+" = "+j.getValue());
	}
}
@Then("User close the browser")
public void closeBrowser() {
	driver.quit();
}

}

