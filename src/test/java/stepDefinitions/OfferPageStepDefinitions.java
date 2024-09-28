package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinitions {

	public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;

	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_products_exist(String shortName)
			throws InterruptedException {
		switchToOffersPage();
		OffersPage offers = testContextSetup.pageObjectManager.getOfferPage();
		offers.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offers.getProductName();
	}
	
	public void switchToOffersPage() {
		LandingPage landing = testContextSetup.pageObjectManager.getLandingPage();
		landing.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();
	}

	@And("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
	}
}
