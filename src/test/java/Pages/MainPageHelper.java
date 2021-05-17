package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPageHelper extends PageBase {

    public MainPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "org.wikipedia:id/menu_overflow_button")
    WebElement menuOverflowButton;
    @FindBy(id = "org.wikipedia:id/single_fragment_toolbar_wordmark")
    WebElement title;
    @FindBy(id = "org.wikipedia:id/menu_page_search")
    WebElement searchButton;
    @FindBy(id = "org.wikipedia:id/search_src_text")
    WebElement searchTextField;
    @FindBy(id = "org.wikipedia:id/page_list_item_container")
    List<WebElement> currentSearch;


    public MainPageHelper waitPageIsLoaded() {
        waitUntilElementIsClickabl(searchButton, 5);
        return this;
    }

    public String strTitle() {
        return title.getText();
    }

    public MainPageHelper clickFindButton() {
        searchButton.click();

        return this;
    }

    public MainPageHelper findJavaWiki() {
//        AppiumDriver app = (AppiumDriver)driver;
        fillField(searchTextField, "java");
        currentSearch.get(0).click();
//        app.hideKeyboard();
//        app.getKeyboard().sendKeys(Keys.ENTER);
        return this;
    }
}
