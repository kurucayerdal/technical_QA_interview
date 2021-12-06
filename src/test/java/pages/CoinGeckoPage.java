package pages;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class CoinGeckoPage {

    private  List<String> coinNameList = new ArrayList<>();

    @Test
    @Description("Connexion to CoinGecko ok")
    public void CoinGeckoConnexionTest(){
        given()
                .when()
                .get("https://api.coingecko.com/api/v3/ping")
                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = {"CoinGeckoConnexionTest"})
    @Description("I call the list of listed coin on CoinGecko")
    public void CoinGeckoListTest(){
        coinNameList =
        given()
                .when()
                .get("https://api.coingecko.com/api/v3/coins/list")
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("name");
    }

    @Test(dependsOnMethods = {"CoinGeckoListTest"})
    @Description("Verify Monero is listed on CoinGecko")
    public void CoinGeckoVerifyMoneroInListTest(String value){
        Assert.assertTrue(coinNameList.contains(value));
    }
}
