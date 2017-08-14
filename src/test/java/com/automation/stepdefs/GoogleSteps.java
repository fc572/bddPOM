package com.automation.stepdefs;

import com.pages.GoogleSearchPage;
import com.pages.GoogleSearchResultsPage;

import com.pages.Page;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class GoogleSteps {
	private final GoogleSearchPage googleSearchPage;
	private final GoogleSearchResultsPage googleSearchResultsPage;
	
	private final Logger logger = LoggerFactory.getLogger(GoogleSteps.class);

	public GoogleSteps(GoogleSearchPage commonGoogleSearchPage, GoogleSearchResultsPage commonGoogleSearchResultsPage) {
		googleSearchPage = commonGoogleSearchPage;
		googleSearchResultsPage = commonGoogleSearchResultsPage;
	}

	@After
	public void clearCookies() throws Throwable {
		Page.clearAllCookies();
	}

	@Given("^I am using Google$")
	public void i_am_using_Google() throws Throwable {
		logger.info("Loading page");
		googleSearchPage.load();
		logger.debug("Loaded page");
	}

	@When("^I search for (.*)$")
	public void i_search_for_search_term(String searchTerm) throws Throwable {
		googleSearchPage.searchFor(searchTerm);
	}

	@Then("^I am shown search results for (.*)$")
	public void i_am_shown_search_results_for_search_term(String searchTerm) throws Throwable {
		assertThat(googleSearchResultsPage.firstHitTitle().toLowerCase(), containsString(searchTerm));
	}
}
