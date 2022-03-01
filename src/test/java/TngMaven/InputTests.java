package TngMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputTests {

	@Test
	public void inputparameterTest() {
		
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	    String baseUrl = "https://demo.guru99.com/test/newtours/";
	    Assert.assertEquals("a", "a");
	    // positive user id pass
	    driver.get(baseUrl);
	    trylogintest(driver,"Mercury","Mercury");
	    
	    //blank user id pass
	    driver.get(baseUrl);
	    trylogintest(driver,"","");
	    
	    
	    //invalid user id pass
	     driver.get(baseUrl);
	     trylogintest(driver,"Mercury1","Mercury2");
	     
	} 
	     
	     private static void trylogintest(WebDriver driver, String string, String string2) {
	    		
				WebElement username = driver.findElement(By.xpath("//input[@name='userName']"));
		        username.sendKeys(string);
		      
		        WebElement pass = driver.findElement(By.name("password"));// ("//input[@name='password']"));
		        pass.sendKeys(string2);
		  
		        // DOM 
		        WebElement  submit = driver.findElement(By.xpath("//input[@name='submit']"));
		        submit.click();
		        
		        

	}
	
	
	
}
