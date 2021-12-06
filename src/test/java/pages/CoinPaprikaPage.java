package pages;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class CoinPaprikaPage {

    private List<String> coinNameList = new ArrayList<>();

    @Test
    @Description("Connexion to CoinPaprika is ok")
    public void CoinPaprikaConnexionTest() {
        given()
                .when()
                .get(" https://api.coinpaprika.com/v1/ping")
                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = {"CoinPaprikaConnexionTest"})
    @Description("I call the list of listen coin on Coin Paprika")
    public void CoinPaprikaListTest() {
        coinNameList =
                given()
                        .when()
                        .get("https://api.coinpaprika.com/v1/coins")
                        .then()
                        .statusCode(200)
                        .extract().jsonPath().getList("name");
    }

    @Test(dependsOnMethods = {"CoinPaprikaListTest"})
    @Description("Verify Monero is listed on CoinPaprika")
    public void CoinPaprikaVerifyMoneroInListTest(String value) {
        Assert.assertTrue(coinNameList.contains(value));
    }
}
