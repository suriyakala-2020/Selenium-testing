import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Honda {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

// Set the chromedriver.exe file to JAVA class
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

//Set ChromeDriver to execute in silent mode
System.setProperty("webdriver.chrome.silentOutput", "true");

////Launch ChromeBrowser
ChromeDriver driver = new ChromeDriver();

//Maximize Browser
driver.manage().window().maximize();

//Implicit Wait
driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

//Get URL
driver.get("https://www.honda2wheelersindia.com/");

//Close Pop-up box
driver.findElementByXPath("//button[@class='close']").click();

//Click on scooters
driver.findElementByXPath("(//a[text()='Scooter'])[1]").click();
Thread.sleep(3000);

//click Dio
driver.findElementByXPath("//div/a/img[@src='/assets/images/thumb/dioBS6-icon.png']").click();
Thread.sleep(3000);

//Click on Specifications
driver.findElementByXPath("//li/a[text()='Specifications']").click();

//Mouse over on ENGINE
Actions action = new Actions(driver);
WebElement tar = driver.findElementByXPath("(//li[@class='specificationsLi wow bounceInLeft'])[2]/a");
Thread.sleep(3000);
action.moveToElement(tar).perform();

//Get Displacement value of Dio
String dioDisplacement = driver.findElementByXPath("(//ul[@class='tab_content'])[2]//span[text()='Displacement']/following-sibling::span").getText();
System.out.println("Displacement value of Dio : "+(dioDisplacement));
float Displacement1 = Float.parseFloat(dioDisplacement.replaceAll("c", ""));
System.out.println(Displacement1);

//Go to Scooter
driver.findElementByXPath("(//a[text()='Scooter'])[1]").click();

//click Activa 125
driver.findElementByXPath("//div/a/img[@src='/assets/images/thumb/activa-125new-icon.png']").click();

//Click on Specifications
driver.findElementByXPath("//li/a[text()='Specifications']").click();

//Mouse over on ENGINE
WebElement tar1 = driver.findElementByXPath("(//li[@class='specificationsLi'])[4]/a");
Thread.sleep(3000);
action.moveToElement(tar1).perform();

//Get Displacement value of Activa
String activaDisplacement = driver.findElementByXPath("(//ul[@class='tab_content'])[2]//span[text()='Displacement']/following-sibling::span").getText();
System.out.println("Displacement value of Activa : "+(activaDisplacement));
float Displacement2 = Float.parseFloat(activaDisplacement.replaceAll("c", ""));
System.out.println(Displacement2);

//Compare Displacement of Dio and Activa 125 and print the Scooter name having better Displacement.
if (Displacement1 > Displacement2) {
	System.out.println("Dio has better displacement");
}else {
	System.out.println("Activa has better displacement");
}

//Click FAQ from Menu
driver.findElementByLinkText("FAQ").click();

//Click Activa 125 BS-VI under Browse By Product
driver.findElementByLinkText("Activa 125 BS-VI").click();

//Click  Vehicle Price 
WebElement tar2 = driver.findElementByXPath("//a[text()=' Vehicle Price']");
tar2.click();
Thread.sleep(3000);

//Check Activa 125 BS-VI selected and click submit
if (tar2.isEnabled()) {
	driver.findElementByXPath("//button[@id='submit6']").click();	
}

//click the price link
driver.findElementByLinkText("Click here to know the price of Activa 125 BS-VI.").click();

//Move Control to new window
Set<String> win = driver.getWindowHandles();
ArrayList<String> winlis = new ArrayList<String>(win);
driver.switchTo().window(winlis.get(1));

//Select the state as Tamil Nadu
WebElement tar3 = driver.findElementById("StateID");
Select select = new Select(tar3);
select.selectByVisibleText("Tamil Nadu");

//Select the city as Chennai
WebElement tar4 = driver.findElementById("CityID");
Select select1 = new Select(tar4);
select1.selectByVisibleText("Chennai");

//Click Search
driver.findElementByXPath("//button[text()='Search']").click();

//Print all the 3 models and their prices
for (int i = 1; i <=3; i++) {
		String text = driver.findElementByXPath("//table[@id='gvshow']//tbody//tr["+i+"]").getText();
		System.out.println(text.replace("Chennai", ""));		
}

//Close all windows
driver.quit();

	}

}
