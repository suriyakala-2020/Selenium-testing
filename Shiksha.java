import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Shiksha {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
// Set the chromedriver.exe file to JAVA class
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

// Set ChromeDriver to execute in silent mode
System.setProperty("webdriver.chrome.silentOutput", "true");

// Open Chrome browser
ChromeDriver driver = new ChromeDriver();

// Maximize the window
driver.manage().window().maximize();

//Implicit Wait
driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

//Go to URL - https://studyabroad.shiksha.com/
driver.get("https://studyabroad.shiksha.com/");

//Mouse over on Colleges and click MS in Computer Science &Engg under MS Colleges
WebElement tar1 = driver.findElementByXPath("//label[@class='menuTab-div fnt-wt melabel' and contains(text(),'Colleges')]");
Actions actions = new Actions(driver);
actions.moveToElement(tar1).perform();
driver.findElementByXPath("//a[text()='MS in Computer Science &Engg']").click();
Thread.sleep(3000);

// Select USA under countries
WebElement tar = driver.findElementByXPath("//div[@id='locationFilterScrollbar']//div[@class='thumb']");
actions.clickAndHold(tar).moveByOffset(0, 80).release().perform();
driver.findElementByXPath("//div[@class='tar']/a[text()='OK']").click();
driver.findElementByXPath("//a[text()='USA']").click();

// Switch control to new window
Set<String> win = driver.getWindowHandles();
ArrayList<String> winlis = new ArrayList<String>(win);
driver.switchTo().window(winlis.get(1));

// Select GRE under Exam Accepted and Score 300 & Below 
driver.findElementByXPath("//label[@class='exam-col-chkbx flLt']/p[text()='GRE']").click();
Thread.sleep(3000);
WebElement tar2 = driver.findElementByXPath("//li[@class='labelInputs active']/div[@class='filter-dropdown flLt']/select");
Select select = new Select(tar2);
select.selectByVisibleText("300 & below");
Thread.sleep(3000);
driver.findElementByXPath("//p[text()='Max 10 Lakhs']").click();

// Select Sort By: Low to high 1st year total fees
actions.sendKeys(Keys.PAGE_DOWN).perform();
Thread.sleep(3000);
WebElement tar3 = driver.findElementByXPath("//select[@id='categorySorter']");
Select sort = new Select(tar3);
sort.selectByVisibleText("Low to high 1st year total fees");

// Click Add to compare of the College having least fees with Public University, Scholarship and Accommodation facilities
List<WebElement> collegeCount = driver.findElementsByXPath("//div[@class='uni-course-details flLt']");
for (int i = 1; i <= collegeCount.size(); i++) {
	Thread.sleep(3000);
	List<WebElement> Criteria = driver.findElementsByXPath("((//div[@class='uni-course-details flLt'])["+i+"]/div[3])[1]"
			+ "//span[@class='tick-mark']");
	int count = Criteria.size();
	if (count == 3) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement college = driver.findElementByXPath("(//div[@class='uni-course-details flLt'])["+i+"]/parent::div/parent::div"
				+ "/div[@class='compare-box flRt customInputs']//p");
		js.executeScript("arguments[0].click()", college);
				}
}
// Select the first college under Compare with similar colleges
driver.findElementByXPath("(//span[contains(text(),'[ Add ]')])[1]").click();

// Click on Compare College>
driver.findElementByXPath("//strong[contains(text(),'Compare Colleges')]").click();

// Select When to Study as 2021
driver.findElementByXPath("//strong[text()='2021']").click();

// Select Preferred Countries as USA
driver.findElementByXPath("(//div[text()='Preferred Countries']/following-sibling::div)[1]").click();
driver.findElementByXPath("//div[@class='city-lr ctry-lr']//label[text()[normalize-space()='USA']]").click();

// Select Level of Study as Masters
driver.findElementByXPath("//strong[text()='Masters']").click();

// Select Preferred Course as MS
driver.findElementByXPath("(//div[text()='Preferred Course']/following-sibling::div)[1]").click();
driver.findElementByXPath("//li[text()='MS']").click();

// Select Specialization as "Computer Science & Engineering"
driver.findElementByXPath("//div[text()='All specializations']").click();
driver.findElementByXPath("//li[text()='Computer Science & Engineering']").click();

// Click on Sign Up
driver.findElementByXPath("//a[contains(text(),'Sign Up')]").click();

// Print all the warning messages displayed on the screen for missed mandatory fields
List<WebElement> error = driver.findElementsByXPath("//div[@class='helper-text' and text()]");
for (WebElement i : error) {
String text = i.getText();
System.out.println(text);
}
	}
