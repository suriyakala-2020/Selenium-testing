import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class crm {

	public static void main(String[] args) throws InterruptedException{
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
driver.get("https://portaldemo.1crmcloud.com/1crm/login.php");

//Give username as admin and password as admin
driver.findElementById("login_user").sendKeys("admin");
driver.findElementById("login_pass").sendKeys("admin");
WebElement theme = driver.findElementById("login_theme");

//Choose theme as Claro Theme
Select select = new Select(theme);
select.selectByVisibleText("Claro Theme");

//Click Login
driver.findElementByXPath("//span[text()='Login']").click();
Thread.sleep(3000);

//Mouse Over Sales and Marketing
WebElement tar = driver.findElementByXPath("//a/div[text()='Sales & Marketing']");
Actions action = new Actions(driver);
action.moveToElement(tar).perform();

//Click Create contact
WebElement tar1 = driver.findElementByXPath("//div[text()='Contacts']");
action.moveToElement(tar1).perform();
driver.findElementByXPath("//span[@class='uii uii-add active-icon']").click();
Thread.sleep(6000);

//Select Title and type First name, Last Name, Email and Phone Numbers
driver.findElementByXPath("//div[@class='input-field input-field-group']/div[@id='DetailFormsalutation-input']").click();
Thread.sleep(3000);
driver.findElementByXPath("//div[text()='Ms.']").click();
driver.findElementById("DetailFormfirst_name-input").sendKeys("Suriya");
driver.findElementById("DetailFormlast_name-input").sendKeys("kala");
driver.findElementById("DetailFormemail1-input").sendKeys("skala8248524704@gmail.com");
driver.findElementById("DetailFormphone_home-input").sendKeys("8248524704");

//Save the information
driver.findElementByXPath("//div[@id='DetailFormlead_source-input']").click();

//Select Lead Source as "Public Relations"
driver.findElementByXPath("//div[text()='Public Relations']").click();

//Select Business Roles as "Sales"
driver.findElementById("DetailFormbusiness_role-input").click();
driver.findElementByXPath("//div[text()='Sales']").click();

//Fill the Primary Address, City, State, Country and Postal Code 
driver.findElementByXPath("//textarea[@id='DetailFormprimary_address_street-input']").sendKeys("no.8");
driver.findElementByXPath("//input[@id='DetailFormprimary_address_city-input']").sendKeys("Chennai");
driver.findElementByXPath("//input[@id='DetailFormprimary_address_state-input']").sendKeys("TamilNadu");
driver.findElementByXPath("//input[@id='DetailFormprimary_address_country-input']").sendKeys("India");
driver.findElementByXPath("//input[@id='DetailFormprimary_address_postalcode-input']").sendKeys("600028");

//click Save
driver.findElementByXPath("(//span[text()='Save'])[2]").click();

//Mouse over on Today's Activities
WebElement tar2 = driver.findElementByLinkText("Today's Activities");
action.moveToElement(tar2).perform();

//click Meetings
driver.findElementByXPath("//div[text()='Meetings']").click();
Thread.sleep(3000);

//Click Create 
driver.findElementByXPath("(//span[text()='Create'])[2]").click();

//Type Subject as "Project Status"
driver.findElementByXPath("//input[@id='DetailFormname-input']").sendKeys("Project Status");

//Select Status as "Planned"
driver.findElementByXPath("//div[@id='DetailFormstatus-input']").click();
driver.findElementByXPath("//div[text()='Planned']").click();
Thread.sleep(3000);

//Start Date & Time as tomorrow 3 pm
driver.findElementByXPath("//div[@class='input-label datetime-label text-number']").click();
LocalDate today = LocalDate.now();
LocalDate tomorrow = today.plusDays(1);
String tom = tomorrow.toString();
System.out.println(tomorrow);
driver.findElementByXPath("(//input[@class='input-text'])[4]").sendKeys(Keys.CLEAR);
driver.findElementByXPath("(//input[@class='input-text'])[4]").sendKeys(tom,Keys.ENTER);
driver.findElementByXPath("(//input[@class='input-text'])[4]").sendKeys(Keys.CLEAR);
driver.findElementByXPath("(//input[@class='input-text'])[4]").sendKeys("15:00",Keys.ENTER);

//Select Duration as 1hr
driver.findElementByXPath("//input[@id='DetailFormis_daylong-input-checkbox']").click();
driver.findElementByXPath("//input[@id='DetailFormis_daylong-input-checkbox']").click();
driver.findElementByXPath("//input[@id='DetailFormduration-time']").sendKeys("1h 00m");

//Click Add paricipants and  add created Contact name
driver.findElementByXPath("//button[@name='addInvitee']/span").click();
driver.findElementByXPath("//div[text()='Suriya kala']").click();

//click Save
driver.findElementByXPath("//span[@id='DetailForm_save2-label']").click();

//Go to Sales and Marketting
WebElement tar3 = driver.findElementByXPath("//div[text()='Sales & Marketing']");
action.moveToElement(tar3).perform();
Thread.sleep(3000);

//Click Contacts
driver.findElementByXPath("//div[text()='Contacts']").click();
Thread.sleep(3000);

//search the lead Name and click the name from the result
driver.findElementByXPath("//input[@class='input-text input-entry ']").sendKeys("suriya",Keys.ENTER);
Thread.sleep(6000);
driver.findElementByXPath("//a[@class='listViewNameLink']").click();
Thread.sleep(3000);

//Check weather the Meeting is assigned to the contact under Activities Section.
String activity = driver.findElementByXPath("//a[@class='listViewNameLink']").getText();
System.out.println(activity);
if (activity.contains("Project Status")) {
	System.out.println("Meeting got added to Contact");
}else {
	System.out.println("Meeting not yet added to Contact");
}

//close browser
driver.quit();
	}

	}
