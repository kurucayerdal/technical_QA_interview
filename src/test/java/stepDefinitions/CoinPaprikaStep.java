package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CoinPaprikaPage;

public class CoinPaprikaStep {

    private final CoinPaprikaPage coinPaprikaPage;

    public CoinPaprikaStep(CoinPaprikaPage coinPaprikaPage) {
        this.coinPaprikaPage = coinPaprikaPage;
    }

    @Given("^Connexion to CoinPaprika is ok$")
    public void connexionToCoinPaprikaIsOk() {
        coinPaprikaPage.CoinPaprikaConnexionTest();
    }

    @When("^I call the list of listen coin on Coin Paprika$")
    public void ıCallTheListOfListenCoinOnCoinPaprika() {
        coinPaprikaPage.CoinPaprikaListTest();
    }

    @Then("^Verify Monero is listed$")
    public void verifyMoneroIsListed() {

    }

    @Then("^Verify \"([^\"]*)\" is listed$")
    public void verifyIsListed(String coinName) {
        coinPaprikaPage.CoinPaprikaVerifyMoneroInListTest(coinName);
    }
}
