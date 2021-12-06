package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CoinGeckoPage;

public class CoinGeckoStep {

    private final CoinGeckoPage coinGeckoPage;

    public CoinGeckoStep(CoinGeckoPage coinGeckoPage) {
        this.coinGeckoPage = coinGeckoPage;
    }

    @Given("^Connexion to CoinGecko ok$")
    public void connexionToCoinGeckoOk() {
        coinGeckoPage.CoinGeckoConnexionTest();
    }

    @When("^i call the list of listed coin on CoinGecko$")
    public void iCallTheListOfListedCoinOnCoinGecko() {
        coinGeckoPage.CoinGeckoListTest();
    }

    @Then("^Verify \"([^\"]*)\" is listed on CoinGecko$")
    public void verifyIsListedOnCoinGecko(String coinName){
        coinGeckoPage.CoinGeckoVerifyMoneroInListTest(coinName);
    }
}
