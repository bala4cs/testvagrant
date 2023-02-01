package com.testvagrant.steps;

import static com.testvagrant.utils.ConfigurationUtil.getValue;
import static com.testvagrant.utils.Browsers.getDriver;

import com.testvagrant.logger.CustomLogger;
import com.testvagrant.page.WikiPage;
import com.testvagrant.utils.ConfigurationUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class Wiki {

    private static final CustomLogger LOGGER = new CustomLogger(Wiki.class);

    WebDriver driver = getDriver();

    WikiPage wikiPage = new WikiPage();

    @Given("^user navigate to the puspha rise \"([^\"]*)\" in wiki page$")
    public void userNavigateToThePusphaRiseInWikiPage(String url) {
        LOGGER.info("Load the url in wiki page: ");
        driver.get(getValue(url));
    }

    @Then("^user check the release date \"([^\"]*)\" and country \"([^\"]*)\" details in the wiki page$")
    public void userCheckTheReleaseDateAndCountryDetailsInThePage(String releaseDate, String country) {
        LOGGER.info("validate the country and release details in the page: ");
        assertTrue("should show the proper country details: ", wikiPage.getListInfoData(country));
        assertTrue("should show the proper country details: ", wikiPage.getListInfoData(releaseDate));
    }
}
