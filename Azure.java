import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class Azure {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Set the chromedriver.exe file to JAVA class
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		// Set ChromeDriver to execute in silent mode
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		// Modify default options in Chrome
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		chromePrefs.put("download.default_directory", "E:\\downloads");
		options.setExperimentalOption("prefs", chromePrefs);
		
		//Open Chrome browser
		ChromeDriver driver = new ChromeDriver(options);

		//Maximize the window
		driver.manage().window().maximize();

		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		//Go to URL - https://www.carwale.com/
		driver.get("https://azure.microsoft.com/en-in/"); 
		
		//Click on Pricing
		driver.findElementByXPath("//a[text()='Pricing']").click();
		
		//Click on Pricing Calculator
		driver.findElementByXPath("//a[text()[normalize-space()='Pricing calculator']]").click();
		
		//Click on Containers
		driver.findElementByXPath("//button[text()='Containers']").click();
		
		//Select Container Instances
		driver.findElementByXPath("(//button[@title='Container Instances'])[2]").click();
		
		//Click on Container Instance Added View
		driver.findElementByXPath("//a[text()='View']").click();
		
		//Select Region as "South India"
		WebElement regionDrop = driver.findElementByXPath("//select[@name='region']");
		Select region = new Select(regionDrop);
		region.selectByVisibleText("South India");
		
		//Set the Duration as 180000 seconds
		driver.findElementByXPath("(//input[@name='seconds'])[1]").sendKeys(Keys.ARROW_LEFT,"8000");
		WebElement memoryDrop = driver.findElementByXPath("//select[@name='memory']");
		Select memory = new Select(memoryDrop);
		
		//Select the Memory as 4GB
		memory.selectByVisibleText("4 GB");
		
		//Enable SHOW DEV/TEST PRICING
		driver.findElementByXPath("//span[text()='Show Dev/Test Pricing']").click();
		
		//Select Indian Rupee  as currency
		WebElement currencyDrop1 = driver.findElementByXPath("//select[@class='select currency-dropdown']");
		Select currency1 = new Select(currencyDrop1);
		currency1.selectByValue("INR");
		
		//Print the Estimated monthly price
		String monthlyPrice = driver.findElementByXPath("(//div[@class='row row-size1 column estimate-total']//div/span[@class='numeric'])[2]").getText();
		System.out.println("Estimated Monthly Price: "+ monthlyPrice);
		
		//Click on Export to download the estimate as excel
		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
		Thread.sleep(3000);
		
		//Verify the downloded file in the local folder (ExportedEstimate)
		File file1 = new File("E:\\downloads\\ExportedEstimate.xlsx");
		if (file1.exists()) {
			System.out.println("Downloaded Monthly Cost Estimation");
		}else {
			System.out.println("Failed to Download Monthly Cost Estimation");
		}
		Thread.sleep(3000);
		
		//Navigate to Example Scenarios  
		WebElement tar = driver.findElementByXPath("//a[text()='Example Scenarios']");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",tar);
		
		//Select CI/CD for Containers
		WebElement tar1 = driver.findElementByXPath("//button[@title='CI/CD for Containers']");
		js.executeScript("arguments[0].click();",tar1);
		
		//Click Add to Estimate
		WebElement tar2 = driver.findElementByXPath("//button[text()='Add to estimate']");
		js.executeScript("arguments[0].click();",tar2);	
		Thread.sleep(6000);
		
		//Change the Currency as Indian Rupee
		WebElement currencyDrop2 = driver.findElementByXPath("//select[@class='select currency-dropdown']");
		Select currency2 = new Select(currencyDrop2);
		currency2.selectByValue("INR");
		
		//Enable SHOW DEV/TEST PRICING
		driver.findElementByXPath("//span[text()='Show Dev/Test Pricing']").click();
		
		//Export the Estimate
		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
		Thread.sleep(3000);
		
		//Verify the downloded file in the local folder
		File file2 = new File("E:\\downloads\\ExportedEstimate (1).xlsx");
		if (file2.exists()) {
			System.out.println("Downloaded Monthly Cost Estimation for Example Scenario");
		}else {
			System.out.println("Failed to Download Monthly Cost Estimation for Example Scenario");
		}

	}

}
