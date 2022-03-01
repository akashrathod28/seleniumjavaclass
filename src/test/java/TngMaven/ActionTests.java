package TngMaven;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class ActionTests {
	WebDriver driver;
	
	
	
	@Test (enabled = true)
	public void actiontest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		driver.get("https://www.browserstack.com/");
		
		Actions action = new Actions(driver); 
		
		WebElement element = driver.findElement(By.linkText("Get started free"));
		
		Thread.sleep(5000);
		
		action.moveToElement(element).click().perform();
		Thread.sleep(5000);
		//action.contextClick(element).perform();
		
		WebElement input = driver.findElement(By.xpath("//input[@id='user_full_name']"));
		
		Action seriesOfActions = action
				.moveToElement(input)
				.click()
				.keyDown(input, Keys.SHIFT)
				.sendKeys(input, "hello")
				.keyUp(input, Keys.SHIFT)
				.doubleClick(input)
				.contextClick()
				.build();
				
			seriesOfActions.perform() ;
			
			ActionTests.takescreenshot(driver);

	}
	
	
	@Test (enabled = false)
	public void capSelenium() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.browserstack.com/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
//		
//		DesiredCapabilities capabilities = DesiredCapabilities();
//		  
//		capabilities.setCapability
//		System.out.println(driver.getBrowserName());
	}

	@Test (enabled = false)
	public void screenshottest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		driver.get("https://www.browserstack.com/");

		Thread.sleep(2000);
		
		       

	}
	
	public static void takescreenshot(WebDriver driver) {
		 //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File SrcFile =   scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile = new File("D:\\test.png");

        //Copy file at destination
       
       try {
		FileUtils.copyFile(SrcFile, DestFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
