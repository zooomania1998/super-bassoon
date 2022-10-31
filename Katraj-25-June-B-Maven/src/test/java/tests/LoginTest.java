package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;


public class LoginTest {
	
	public WebDriver driver;
	LoginPage lp;

	@BeforeClass
	public void initalization() {
		
	     //Webdriver manager to manage driver exe
		WebDriverManager.chromedriver().setup();
		
		//step-1
		driver =new ChromeDriver();
		
		//step-2
		driver.manage().window().maximize();
		
		//step-3 open webpage
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//step-4 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		
		//create object
		 lp = new LoginPage(driver);
		 
	
	}
	
	@Test
	public void login() {
		
		lp.enterCred("Admin", "admin123");
		
		Assert.assertTrue(lp.isEnabled(), "Button is not enabled");
		
		lp.clickButton();
		
		System.out.println("successfully login");
		
		
	}
	
	
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
		
	}	

}
