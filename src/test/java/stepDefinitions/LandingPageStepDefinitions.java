package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import org.openqa.selenium.chrome.*;
import org.testng.Assert;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;

public class LandingPageStepDefinitions {
	
	public LandingPageStepDefinitions(TestContextSetup testContextSetup){
		this.testContextSetup = testContextSetup;
	}
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	
	@Given("user is on greenkart landing page")
	public void user_is_on_greenkart_landing_page() throws IOException {
	    testContextSetup.testBase.webDriverManager();
	}
	
	@When("^user searched with shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
		
		LandingPage landing = testContextSetup.pageObjectManager.getLandingPage();
		landing.searchItem(shortName);
//		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    testContextSetup.landingPageProductName = landing.getProductName().split("-")[0].trim();
	    System.out.println(testContextSetup.landingPageProductName + " is extracted from homepage");
	}
	
}
