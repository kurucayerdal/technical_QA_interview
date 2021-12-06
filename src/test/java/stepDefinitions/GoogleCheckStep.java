package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GoogleCheckPage;
import pages.Parent;

public class GoogleCheckStep extends Parent {

    private final GoogleCheckPage googleCheckPage = new GoogleCheckPage();

    @Given("^Set our favourite coin to Monero$")
    public void setOurFavouriteCoinToMonero() {
    }

    @When("^Open \"([^\"]*)\"$")
    public void open(String url) {
        openUrl(url);
    }

    @And("^Make a google search \"([^\"]*)\"$")
    public void makeAGoogleSearch(String searchValue) {
        clickFunction(googleCheckPage.getButtonAcceptCookies());
        sendKeysFunction(googleCheckPage.getInputSearch(), searchValue);
        clickFunction(googleCheckPage.getButtonSearch());
    }

    @Then("^Verify There is a wikipedia link$")
    public void verifyThereIsAWikipediaLink() {
        verifyListContainsLink(googleCheckPage.getFirstPageLinksList(), "wikipedia.org");
    }
}
