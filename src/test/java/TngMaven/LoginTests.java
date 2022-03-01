package TngMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests {

	@Test         // annotation - testng
	public void validScrnarioTest() {
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println(" akash \"  ");
		
		
		driver.get("https://learning.postman.com/docs/sending-requests/variables/");
	
		try {
			driver.wait(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		driver.close();
		driver.quit();
	}
	
}
