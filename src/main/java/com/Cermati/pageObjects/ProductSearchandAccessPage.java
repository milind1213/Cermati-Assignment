package com.Cermati.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Cermati.commonFactory.CommonSelenium;

public class ProductSearchandAccessPage extends CommonSelenium {
	WebDriver driver;

	public ProductSearchandAccessPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By shopByCategoryBtn = By.id("gh-shop-a");
	private By allFilters = By.xpath("(//ul[@class='brm__list']//li//button)[last()]");
	private By minPriceFrom = By.xpath("//input[contains(@aria-label,'Minimum Value')]");
	private By maxpricedTo = By.xpath("//input[contains(@aria-label,'Maximum Value')]");
	private By applyFilterBtn = By.cssSelector("button[aria-label='Apply']");
	private By appliedFilterbtn = By.xpath("//span[contains(text(),'filters applied')]");
	private By searchLocator = By.xpath("//input[@id='gh-ac'  or @placeholder ='Search for anything']");
	private By categoryDropdownLocator = By.id("gh-cat");
	private By searchBtnLocatoer = By.id("gh-btn");
	private By searchResultLocator = By.xpath("(//a/div/span[@role='heading' and contains(text(), 'iPhone')])[1]");
	private By conditionFilter = By.xpath("//div[contains(@id,'c3-mainPanel')]//span[text()='Condition']");
	private By priceFilter = By.xpath("//div[contains(@id,'c3-mainPanel')]//span[text()='Price']");
	private By itemBylocation = By.xpath("//div[contains(@id,'c3-mainPanel')]//span[text()='Item Location']");
	private String conditionTag = "//ul[@class='brm__aspect-list']//li/a/span[contains(text(),'Condition')]";
	private String priceTag = "//ul[@class='brm__aspect-list']//li/a/span[contains(text(),'Price')]";
	private String itemLocationTag = "//ul[@class='brm__aspect-list']//li/a/span[contains(text(),'Item Location')]";

	public void applyConditionFilter(String phoneType) {
		scrollClick(allFilters);
		waitFor(2);
		waitForElementToBeClickable(driver, conditionFilter, 5);
		click(conditionFilter);
		waitForElementDisplay(driver, By.xpath("//span[@class='field']//label[.='" + phoneType + "']"), 5);
		click(By.xpath("//span[@class='field']//label[.='" + phoneType + "']"));
		waitFor(3);
	}

	public void applyPriceFilter(String minAmt, String maxAmt) {
		click(priceFilter);
		waitForElementDisplay(driver, minPriceFrom, 3);
		sendKeys(minPriceFrom, minAmt);
		sendKeys(maxpricedTo, maxAmt);
	}

	public void applyItemLocationFilter(String itemLocation) {
		waitForElementToBeClickable(driver, itemBylocation, 5);
		click(itemBylocation);
		try {
			String itemLocationXPath = "//span[contains(text(),'" + itemLocation + "')]//ancestor::span//input";
			WebElement locationElement = driver.findElement(By.xpath(itemLocationXPath));
			locationElement.click();
			Thread.sleep(2000);
			click(applyFilterBtn);
			waitFor(2);
		} catch (Exception e) {
			System.out.println("An Error occurred while applying filter: " + e.getMessage());
		}
	}
	
	public void clickingOnAllFilters() {
		scrollClick(allFilters);
	}
	
	public String getPhoneCondtionTagText() {
		waitForElementDisplay(driver, appliedFilterbtn, 5);
		click(appliedFilterbtn);
		String condtionText = driver.findElement(By.xpath(conditionTag)).getText();
		String str[] = condtionText.split(":");
		String phoneCondtionTagText = str[0];
		return phoneCondtionTagText;
	}
	
	public String getPriceFilterTagText() {
		String text = driver.findElement(By.xpath(priceTag)).getText();
		String str[] = text.split(":");
		String pricefilterTagText = str[0];
		return pricefilterTagText;
	}

	public String getItemLocationTagText() {
		String text = driver.findElement(By.xpath(itemLocationTag)).getText();
		String str[] = text.split(":");
		String locationText = str[0];
		return locationText;
	}

	
	public void searchItemInSearchbar(String item) {
	    try {
	        waitForElementToBeClickable(driver, searchLocator, 3);
	        sendKeys(searchLocator, item);
	    } catch (Exception e) {
	        System.err.println("An error occurred while searching for the item: " + e.getMessage());
	    }
	}

	public void selectItemCategory(String category) {
		WebElement ele = driver.findElement(By.id("gh-cat"));
		Select select = new Select(ele);
        select.selectByVisibleText(category);
		click(searchBtnLocatoer);
	}
	
	public void selectItemCategorys(String category) {
	    click(By.id("gh-cat"));
	    List<WebElement> list = driver.findElements(By.xpath("//select[@id='gh-cat']//option"));
	    for (WebElement ele : list) {
	        String cat = ele.getText();
	        if (cat.equals(" Computers/Tablets & Networking")) {
	            ele.click();  
	        }
	    }
	    click(searchBtnLocatoer);
	
	}

	
	public String getFirstResultValidation() {
		String firstResultText = driver.findElement(searchResultLocator).getText();
		return firstResultText;
	}

	public void shopByCategory() {
		click(shopByCategoryBtn);
	}

	public void selectingCellPhonesAccessories(String itemTypes) {
		By cellPhonesAndAccessories = By
				.xpath("//a[contains(text(),'electronicItems')]".replace("electronicItems", itemTypes));
		waitForElementToBeClickable(driver,cellPhonesAndAccessories,3);
		click(cellPhonesAndAccessories);
	}

	public void selectingCellPhonesAndSmartphones(String cellSmartphones) {
		By cellSmartphone = By.xpath("//a[text()='" + cellSmartphones + "']");
		waitForElementDisplay(driver, cellSmartphone, 3);
		click(cellSmartphone);
	}

}
