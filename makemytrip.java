import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class makemytrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
// Set the chromedriver.exe file to JAVA class
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

//Launch ChromeBrowser
ChromeDriver driver =new ChromeDriver();

//Maximize Browser
driver.manage().window().maximize();

//Open URL
driver.get("https://www.makemytrip.com/");

//Enter city as Goa, and choose Goa, India
driver.findElementByXPath("(//span[@class='chNavText darkGreyText'])[2]").click();
driver.findElementByXPath("//input[@id='city']").click();
driver.findElementByXPath("//input[@placeholder ='Enter city/ Hotel/ Area/ Building']").sendKeys("Goa,");
driver.findElementByXPath("//p[text()='Goa, India']").click();

//Enter Check in date as May 15
driver.findElementByXPath("//input[@id='checkin']").click();
WebElement checkIn = driver.findElementByXPath("//div[@aria-label='Fri May 15 2020']");

//Enter CheckOut date = CheckIn date + 5
String text = checkIn.getText();
checkIn.click();
int inDate = Integer.parseInt(text);
int outDate = inDate+5;
driver.findElementByXPath("//input[@id='checkout']").click();
driver.findElementByXPath("(//div[text()='"+outDate+"'])[2]").click();

//Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12).
driver.findElementByXPath("//input[@id='guest']").click();
driver.findElementByXPath("//li[@data-cy='adults-2']").click();
driver.findElementByXPath("//li[@data-cy='children-1']").click();
driver.findElementByXPath("//button[@class='primaryBtn btnApply']").click();

//Click on search button
driver.findElementByXPath("//button[@id='hsw_search_button']").click();

//Select 5 start in Star Category under Select Filters
driver.findElementByXPath("//div[@class='mmBackdrop wholeBlack']").click();
driver.findElementByXPath("(//span[@class='checkmarkOuter']/label)[13]").click();

//Select locality as Baga
driver.findElementByXPath("//label[@for='mmLocality_checkbox_35']").click();
Thread.sleep(3000);

//Click on the first resulting hotel
driver.findElementByXPath("(//div[@class='flexOne appendLeft20'])[1]").click();

//Switch Control on Windows
Set<String> wins = driver.getWindowHandles();
ArrayList<String> winlis = new ArrayList<String>(wins);
driver.switchTo().window(winlis.get(1));

//Print the Hotel Name
String hotelName = driver.findElementByXPath("//h1[@id='detpg_hotel_name']").getText();
System.out.println("Name of the Hotel:"+hotelName);

//Click MORE OPTIONS link
driver.findElementByXPath("//span[text()='MORE OPTIONS']").click();

//Select 3Months plan and close
driver.findElementByXPath("//table//tr[2]//td[6]").click();
driver.findElementByXPath("//span[@class='close']").click();
Thread.sleep(3000);

//Click on BOOK THIS NOW
driver.findElementByXPath("//a[text()='BOOK THIS NOW']").click();

//Print the Total Payable amount
String Total = driver.findElementByXPath("//span[@id='revpg_total_payable_amt']").getText();
System.out.println("Total Payable Amount:"+Total);

//Close all windows
driver.quit();

	}

}
