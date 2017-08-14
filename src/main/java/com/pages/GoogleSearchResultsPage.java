package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.pages.Page.getBrowser;

public class GoogleSearchResultsPage {

	private WebDriver driver;

	@FindBy(css = ".g .r")
	private WebElement firstHitDescriptionText;

	public GoogleSearchResultsPage() throws Throwable {
		driver = getBrowser();
		PageFactory.initElements(driver, this);
	}

	public String firstHitTitle() {
		return firstHitDescriptionText.getText();
	}
}
