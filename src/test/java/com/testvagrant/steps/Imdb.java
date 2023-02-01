package com.testvagrant.steps;

import com.testvagrant.page.ImdbPage;
import com.testvagrant.utils.ConfigurationUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.testvagrant.logger.CustomLogger;

import static com.testvagrant.utils.Browsers.getDriver;
import static com.testvagrant.utils.ConfigurationUtil.getValue;
import static org.junit.Assert.assertTrue;

public class Imdb {

    private static final CustomLogger LOGGER = new CustomLogger(Imdb.class);

    WebDriver driver = getDriver();

    ImdbPage imdbPage = new ImdbPage();

    @Given("^user navigate to the puspha rise \"([^\"]*)\" in imdb page$")
    public void userNavigateToThePusphaRiseInWikiPage(String url) {
        LOGGER.info("Load the url in wiki page: ");
        driver.get(getValue(url));
    }

    @Then("^user check the release date \"([^\"]*)\" and country \"([^\"]*)\" details in the imdb page$")
    public void userCheckTheReleaseDateAndCountryDetailsInThePage(String releaseDate, String country) {
        LOGGER.info("validate the country and release details in the page: ");
        assertTrue("should show the proper country details: ",imdbPage.getListInfoData(releaseDate));
        assertTrue("should show the proper country details: ",imdbPage.getListInfoData(country));
    }
}
