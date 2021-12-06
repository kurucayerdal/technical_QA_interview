package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

import java.util.List;

public class GoogleCheckPage {

    public GoogleCheckPage() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "L2AGLb")
    private WebElement buttonAcceptCookies;

    @FindBy(name = "q")
    private WebElement inputSearch;

    @FindBy(name = "btnK")
    private WebElement buttonSearch;

    @FindBy(css = "div[class='yuRUbf']>a")
    private List<WebElement> firstPageLinksList;

    public WebElement getButtonAcceptCookies() {
        return buttonAcceptCookies;
    }

    public WebElement getInputSearch() {
        return inputSearch;
    }

    public WebElement getButtonSearch() {
        return buttonSearch;
    }

    public List<WebElement> getFirstPageLinksList() {
        return firstPageLinksList;
    }
}
