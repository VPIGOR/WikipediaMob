package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CurrentPageHelper extends PageBase {
    public CurrentPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "org.wikipedia:id/view_page_title_text")
    WebElement title;
    @FindBy(className = "android.support.v7.app.ActionBar$Tab")
    List<WebElement> buttomScrollView;
    @FindBy(id = "org.wikipedia:id/onboarding_button")
    WebElement goItButton;
    @FindBy(id = "android:id/button1")
    WebElement subbmitCreateNewListButton;
    @FindBy(id = "org.wikipedia:id/menu_page_show_tabs")
    WebElement closeTabsButton;


    public CurrentPageHelper createBookmark() {
        buttomScrollView.get(0).click();
        waitUntilElementIsClickabl(goItButton, 3);
        goItButton.click();
        waitUntilElementIsClickabl(subbmitCreateNewListButton, 3);
        return this;
    }

    public CurrentPageHelper weitCurrentPageLoaded() {
        waitUntilElementIsClickabl(buttomScrollView.get(0), 3);
        return this;
    }


}
