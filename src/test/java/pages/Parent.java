package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseDriver;

import java.time.Duration;
import java.util.List;

public class Parent {
    private WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(20));
    private JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    public void openUrl(String url) {
        WebDriver driver = BaseDriver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void clickFunction(WebElement element) {
        scrollToElement(element);
        waitUntilClickable(element);
        try {
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void sendKeysFunction(WebElement element, String value) {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void verifyListContainsLink(List<WebElement> elementList, String link) {
        try {
            for (WebElement e : elementList) {
                if (e.getAttribute("href").contains(link)) {
                    System.out.println("The link (" + link + ") is found.");
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("The link (" + link + ") is not found!");
            Assert.fail();
        }
    }
}
