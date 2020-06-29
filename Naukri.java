package ten;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naukri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
System.setProperty("webdriver.chrome.silentOutput", "true");
ChromeDriver driver = new ChromeDriver();
driver.get("https://www.naukri.com/");
Set<String> winhan = driver.getWindowHandles();
ArrayList <String> wins = new ArrayList <String> (winhan);
driver.switchTo().window(wins.get(1));
String ad1 = driver.findElementByXPath("//a/img").getAttribute("alt");
System.out.println("First Advertisement: "+ ad1);
driver.close();
driver.switchTo().window(wins.get(2));
String ad2 = driver.findElementByXPath("//a/img").getAttribute("alt");
System.out.println("Second Advertisement: "+ ad2);
driver.close();
driver.switchTo().window(wins.get(0));
driver.manage().window().maximize();
driver.findElementByXPath("//label[contains(text(),'Upload CV')]").click();
WebElement upload = driver.findElementByXPath("//input[@id='file_upload']");
upload.sendKeys("E:\\Task 20.txt");
String error = driver.findElementByXPath("//div[@class='error-header']").getText();
System.out.println("Error_Message: "+error);



	}

}
