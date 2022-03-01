package TngMaven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class heroTests {
	WebDriver driver;
	
	@BeforeTest
	public void BeforeMethod() {
		System.out.println("Before   Method");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}
	
	@Test ( enabled = false )
	public void CheckboxesTest() {
		System.out.println("check box method");
		driver.get("https://the-internet.herokuapp.com/");
		
		
		WebElement checkboxLink = driver.findElement(By.xpath("//a[text()='Checkboxes']"));
		checkboxLink.click();
		
		
		WebElement checkboxPageH3 = driver.findElement(By.xpath("//h3[text()='Checkboxes']"));
		String textHerder = checkboxPageH3.getText();
		System.out.println(textHerder);
		
		Assert.assertEquals(textHerder, "Checkboxes");
		
		
//		WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
//		checkbox1.click();
//		boolean  value = checkbox1.isSelected();
		
		List<WebElement> checkbox1 = driver.findElements(By.xpath("//input[@type ='checkbox']"));
		
		checkbox1.get(0).click();
		boolean  value = checkbox1.get(0).isSelected();
		
		checkbox1.get(1).click();
		boolean  value1 = checkbox1.get(1).isSelected();
				
		try {
			driver.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(value);
		System.out.println(value1);
		
	}
	
	@Test  ( enabled = false )
	public void dorpdownTest()  {
		System.out.println("dorpdown Test method");
		driver.get("https://the-internet.herokuapp.com/");
		
		WebElement dropdownLink = driver.findElement(By.xpath("//a[text()='Dropdown']"));
		dropdownLink.click();
		
		
		WebElement cdropdownPageH3 = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
		String textHerder = cdropdownPageH3.getText();
		System.out.println(textHerder);
		
		Assert.assertEquals(textHerder, "Dropdown List","drowpdown text did not match");
		
		WebElement selectbox = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select dropdown = new Select(selectbox);
		
		//  1
		dropdown.selectByIndex(1);
		dropdown.selectByIndex(2);
		
		// 2
		dropdown.selectByValue("1");  
		try {
			driver.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//  3
		dropdown.selectByVisibleText("Option 2"); 
		
	}
	
	
	@Test ( enabled = false )
	public void alertPrompt() throws InterruptedException {
		
		System.out.println("alert method");
		
		driver.get("https://the-internet.herokuapp.com/");
		
		WebElement baseAuthLink = driver.findElement(By.xpath("//a[text()='JavaScript Alerts']"));
		baseAuthLink.click();
		
		
		WebElement JSPromptLink = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		JSPromptLink.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent());
		  
		//auth page
	
		Thread.sleep(5000);
	
		driver.switchTo().alert().sendKeys("rathod");  
		Thread.sleep(5000);

		
		driver.switchTo().alert().accept(); 
		
	}
	
	@Test ( enabled = false )
	public void JSAlert() {
		
		System.out.println("alert method");
		
		driver.get("https://the-internet.herokuapp.com/");
		
		WebElement baseAuthLink = driver.findElement(By.xpath("//a[text()='JavaScript Alerts']"));
		baseAuthLink.click();
		
		
		WebElement JSPromptLink = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		JSPromptLink.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent());
		  
		driver.switchTo().alert().accept(); 
		
	}
	
	@Test ( enabled = false )
	public void JSConfirm() {
		
		System.out.println("alert method");
		
		driver.get("https://the-internet.herokuapp.com/");
		
		WebElement baseAuthLink = driver.findElement(By.xpath("//a[text()='JavaScript Alerts']"));
		baseAuthLink.click();
		
		
		WebElement JSPromptLink = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		JSPromptLink.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent());
		  try {
			//driver.wait(10000);
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().dismiss(); 
		
	}
	
	
	@Test ( enabled = false )
	public void JSExecutor() throws InterruptedException {
		driver.get("https://www.browserstack.com/users/sign_in");
				
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		
		js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");

		
		 js.executeScript("window.scrollBy(0,600)");
		 Thread.sleep(3000);
		 driver.manage().window().maximize();
		 
		 js.executeScript("alert('Welcome to Guru99');");
		 Thread.sleep(3000);

	}
	
	
	
	@Test ( enabled = true )
	public void JSClickTest() throws InterruptedException {
		System.out.println("check box method");
		driver.get("https://the-internet.herokuapp.com/");
		
		
		WebElement checkboxLink = driver.findElement(By.xpath("//a[.='Inputs']"));
//		checkboxLink.click();
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].click();",checkboxLink);
	
		
		 js.executeScript("window.scrollBy(0,600)");
		
		WebElement input = driver.findElement(By.xpath("//input[1]"));
		js.executeScript("arguments[0].value=123;",input);
		

		
	}
	
	@AfterTest
	public void AfterMethod() {
		System.out.println("after   Method");
//		driver.close();
//		driver.quit();	
		
	}

}
