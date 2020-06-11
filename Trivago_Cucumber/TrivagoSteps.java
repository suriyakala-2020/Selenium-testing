package Trivago_Cucumber;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrivagoSteps {
ChromeDriver driver;
Actions action;

@Given("Open the Chrome Browser")
public void openBrowser() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
	driver = new ChromeDriver();
}
@Given("Maximise the webpage")
public void maximiseBrowser() {
	driver.manage().window().maximize();
}
@Given("Set the default implicit wait")
public void implicitWait() {
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
}
@Given("Load the browser with Trivago URL")
public void loadUrl() {
	driver.get("https://www.trivago.com/");	
}
@Given("Enter the destination as Agra, Uttar Pradesh")
public void enterDestination() throws InterruptedException {
	driver.findElementByXPath("//input[@id='querytext']").sendKeys("Agra");
	Thread.sleep(3000);
	driver.findElementByXPath("//span[text()='City - Uttar Pradesh, India']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//button[text()='OK']").click();	
	
}
@Given("Select the check in date as 2020-06-20")
public void checkinDate() {
	driver.findElementByXPath("//time[@datetime='2020-06-20']").click();	
}
@Given("Select the check out date as 2020-06-30")
public void checkoutDate() throws InterruptedException {
	driver.findElementByXPath("//time[@datetime='2020-06-30']").click();
	Thread.sleep(3000);	
}
@Given("Select the room as Family Room")
public void roomDetails() {
	driver.findElementByXPath("//span[text()='Family rooms']").click();	
}
@Given("Select the number of Adults as 2")
public void familyAdults() {
	WebElement adults = driver.findElementByXPath("//select[@id='select-num-adults-2']");
	Select select1 = new Select(adults);
	select1.selectByValue("2");	
}
@Given("Select the number of Childrens as 1")
public void familyChildrens() {
	WebElement children = driver.findElementByXPath("//select[@id='select-num-children-2']");
	Select select2 = new Select(children);
	select2.selectByValue("1");	
}
@Given("Select the Child's Age as 4")
public void childrenAge() {
	WebElement age = driver.findElementByXPath("//select[@id='select-ages-children-2-3']");
	Select select3 = new Select(age);
	select3.selectByValue("4");	
}
@Given("Click the Confirm button")
public void clickConfirm() {
	driver.findElementByXPath("//span[text()='Confirm']").click();	
}
@Given("Click the Search button")
public void clickSearch() {
	driver.findElementByXPath("//button[@class='btn btn--primary btn--regular search-button js-search-button']").click();	
}
@Given("Select the accommodation type as 4 stars hotel")
public void roomType() throws InterruptedException {
	WebElement accommodation = driver.findElementByXPath("(//button[@class='filter-item filter-item--select js-toolbar-hover-button'])[1]");
	action = new Actions(driver);
	action.moveToElement(accommodation).perform();
	Thread.sleep(3000);
	driver.findElementByXPath("(//button[@class='filter-components__starBtn--a8fdc pointer filter-components__starBtnActive--4718c'])[4]").click();
	driver.findElementByXPath("//button[text()='Done']").click();
}
@Given("Select the Guest rating as Very Good")
public void hotelRating() {
	WebElement rating = driver.findElementByXPath("(//button[@class='filter-item filter-item--select js-toolbar-hover-button'])[2]");
	action.moveToElement(rating).perform();
	driver.findElementByXPath("//span[text()='Very good']").click();	
}
@Given("Select the Hotel Location as Agra Fort")
public void hotelLocation() {
	WebElement location = driver.findElementByXPath("//strong[text()='Hotel location']");
	action.moveToElement(location).perform();	
	WebElement site = driver.findElementByXPath("//select[@id='pois']");
	Select select4 = new Select(site);
	select4.selectByVisibleText("Agra Fort");
	driver.findElementByXPath("//button[text()='Done']").click();
}
@Given("Select the additional facilities as Air conditioning, Restaurant and WiFi")
public void facilities() throws InterruptedException {
	WebElement more = driver.findElementByXPath("//strong[text()='More filters']");
	action.moveToElement(more).perform();
	driver.findElementByXPath("//label[text()='Air conditioning']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//label[text()='WiFi']").click();
	driver.findElementByXPath("//input[@id='more-filters-search']").sendKeys("restaurant");
	driver.findElementByXPath("//mark[text()='Restaurant']").click();
	driver.findElementByXPath("//button[text()='Done']").click();	
}
@Given("Select the Sort the result as Rating & Recommended")
public void sortBy() throws InterruptedException {
	WebElement sort = driver.findElementByXPath("//select[@id='mf-select-sortby']");
	Select select5 = new Select(sort);
	select5.selectByVisibleText("Rating & Recommended");	
	String name = driver.findElementByXPath("(//span[@class='item-link name__copytext'])[1]").getText();
	System.out.println("Hotel Name: "+name);
	String ratings = driver.findElementByXPath("(//button[@class='reviews reviews--hover']//span[@itemprop='ratingValue'])[1]").getText();
	System.out.println("Rating: "+ratings);
	String reviews = driver.findElementByXPath("(//span[@class='details-paragraph details-paragraph--rating'])[1]").getText();
	System.out.println("Reviews: "+reviews);
	Thread.sleep(3000);
}
@Given("click view deal button")
public void clickDeal() {
	driver.findElementByXPath("(//span[text()='View Deal'])[1]").click();	
}
@Given("Click reserve for the hotel that satisfied maximum criteria")
public void reserveHotel() throws InterruptedException {
	Set<String> wins = driver.getWindowHandles();
	ArrayList <String> lis = new ArrayList <String> (wins);
	driver.switchTo().window(lis.get(1));
	String url = driver.getCurrentUrl();
	Thread.sleep(3000);
	System.out.println("URL of the current page: "+ url);
	String price = driver.findElementByXPath("(//div[@class='bui-price-display__value prco-text-nowrap-helper prco-inline-block-maker-helper'])[1]").getText();
	System.out.println("Price of the Room: "+price);
	driver.findElementByXPath("(//span[@class='bui-button__text'])[1]").click();
		
}
@When("Click I'll Reserve")
public void reserveConfirm() throws InterruptedException {
	driver.findElementByXPath("(//td[@class='submitButton']//span)[1]").click();
}
@Then("Booking details will be displayed")
public void bookingSuccess() {
	System.out.println("Successfully updated booking details");
	driver.quit();
}

}
