package com.tendable.test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class TestClass {
	
	WebDriver driver;
	
	@BeforeSuite
	public void openBrowser() {
		 WebDriverManager.chromedriver().create();
		 driver = new ChromeDriver();
		 driver.get("https://www.tendable.com/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		
	}
	
	@Test
	public void testPoint1() {
		// Test to confirm accessibility of the top-level menus: Home, Our Story, Our Solution, and Why Tendable
		Boolean isHomeAccessible = driver.findElement(By.xpath("//img[@alt='Tendable Logo']")).isDisplayed();
		System.out.println("Is Tendable logo or Home Menu accessible :"+isHomeAccessible);
		Boolean isOurStoryAccessible = driver.findElement(By.linkText("Our Story")).isDisplayed();
		System.out.println("Is Our Story Menu accessible :"+isOurStoryAccessible);
		Boolean isOurSolutionAccessible = driver.findElement(By.linkText("Our Solution")).isDisplayed();
		System.out.println("Is Our Solution Menu accessible :"+isOurSolutionAccessible);
		Boolean isWhyTendableAccessible = driver.findElement(By.linkText("Why Tendable?")).isDisplayed();
		System.out.println("Is Why Tendable? Menue accessible :"+isWhyTendableAccessible);	
	}
	
	@Test
	public void testPoint2() {
		// Test to Verify that the "Request a Demo" button is present and active on each of the aforementioned top-level menu pages.
		Boolean isRequestADemoPresent = driver.findElement(By.linkText("Request a Demo")).isDisplayed();
		System.out.println("Is \"Request a Demo\" button present :"+isRequestADemoPresent);
		Boolean isRequestADemoActive = driver.findElement(By.linkText("Request a Demo")).isEnabled();
		System.out.println("Is \"Request a Demo\" button active :"+isRequestADemoActive);
	}
	
	@Test
	public void testPoint3() {
		/* Navigate to the "Contact Us" section, choose "Marketing", and complete the form—
		excluding the "Message" field. On submission, an error should arise. Ensure your script 
		confirms the error message's appearance. If the error is displayed, mark the test as PASS. If 
		absent, it's a FAIL. */
		driver.findElement(By.linkText("Contact Us")).click();
		driver.findElement(By.xpath("//button[@data-target='.toggle-163701']")).click();
		driver.findElement(By.xpath("//input[@id='form-input-fullName']")).sendKeys("Kartik Test");
		driver.findElement(By.xpath("//input[@id='form-input-organisationName']")).sendKeys("XYZ Technology Pvt Ltd");
		driver.findElement(By.xpath("//input[@id='form-input-cellPhone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='form-input-email']")).sendKeys("kartikTest@gmail.com");
		driver.findElement(By.xpath("//input[@id='form-input-consentAgreed-0']")).click();
		driver.findElement(By.xpath("//button[@data-original-text='Submit']")).click();
		
		String expectedErrorMessage = "Sorry, there was an error submitting the form. Please try again.";
		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='ff-form-errors']")).getText();
		
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		
	}

}
