package com.Cermati.stepDefinitions;

import org.testng.Assert;

import com.Cermati.commonFactory.WebBrowser;
import com.Cermati.pageObjects.ProductSearchandAccessPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductAccess_Steps {
	private ProductSearchandAccessPage user;
	private String url = WebBrowser.getUrl();

	@Given("the user landed on the eBay homepage")
	public void the_user_landed_on_the_e_bay_homepage() {
		user = new ProductSearchandAccessPage(WebBrowser.getDriver());
		WebBrowser.getDriver().get(url);
	}

	@When("the user navigates to Electronics under Shop by category")
	public void the_user_navigates_to_electronics_under_shop_by_category() {
		user.shopByCategory();
	}

	@When("the user selects {string} from the available options")
	public void the_user_selects_from_the_available_options(String itemTypes) {
		user.selectingCellPhonesAccessories(itemTypes);
	}

	@When("clicks on {string} in the left-hand navigation section")
	public void clicks_on_in_the_left_hand_navigation_section(String cellSmartphones) {
		user.selectingCellPhonesAndSmartphones(cellSmartphones);
	}

	@When("clicks and opens the All Filters menu")
	public void clicks_and_opens_the_all_filters_menu() {
		user.clickingOnAllFilters();
	}

	@When("clicks on Condition filter option and selects {string}")
	public void clicks_on_condition_filter_option_and_selects(String phoneConditionType) {
		user.applyConditionFilter(phoneConditionType);
	}

	@When("clicks on Price filter and enters items {string} and {string}")
	public void clicks_on_price_filter_and_enters_items_and(String minPrice, String maxPrice) {
		user.applyPriceFilter(minPrice, maxPrice);
	}

	@When("clicks on Item Location filter and selects {string} and clicks on Apply button")
	public void clicks_on_item_location_filter_and_selects_and_clicks_on_apply_button(String location) {
		user.applyItemLocationFilter(location);
	}

	@Then("verifies the applied filter tags  {string},{string} and {string}")
	public void applied_filter_tags_Verifying(String expConditionTag, String expPriceTag, String expItemLocationTag) {
		String actualconTag = user.getPhoneCondtionTagText();
		Assert.assertEquals(actualconTag, expConditionTag);
		
		String actualPriceTag = user.getPriceFilterTagText();
		Assert.assertEquals(actualPriceTag, expPriceTag);

		String actualLocationTag = user.getItemLocationTagText();
		Assert.assertEquals(actualLocationTag, expItemLocationTag);
		
 	} 

	@When("the user enters {string} in the search bar")
	public void the_user_enters_in_the_search_bar(String item) {
	   user.searchItemInSearchbar(item);
	}
	
	@When("changes the search category to {string} and clicks Search")
	public void changes_the_search_category_to_and_clicks_search(String category) {
	   user.selectItemCategorys(category);
	}
	
	@Then("verifies that the page loads completely")
	public void verifies_that_the_page_loads_completely() {
	   System.out.println("dgdfg");
	}
	
	@Then("verifies that the name of the first result contains {string}")
	public void verifies_that_the_name_of_the_first_result_contains(String item) {
	   String actualResult =  user.getFirstResultValidation();
	   Assert.assertTrue(actualResult.toLowerCase().contains(item.toLowerCase()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
