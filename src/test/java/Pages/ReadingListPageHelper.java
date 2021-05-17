package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReadingListPageHelper extends PageBase {
    public ReadingListPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "android:id/button1")
    WebElement subbmitCreateNewListButton;
    @FindBy(id = "org.wikipedia:id/page_list_item_container")
    WebElement currentListItem;
    @FindBy(className = "android.support.v7.app.ActionBar$Tab")
    List<WebElement> createdMessage;

    public ReadingListPageHelper newListCreate() {
        subbmitCreateNewListButton.click();
        return this;
    }

    public ReadingListPageHelper veiwCurrentList() {
        createdMessage.get(4).click();
        return this;
    }

    public ReadingListPageHelper waitMyListIsLoaded() {
        waitUntilElementIsVisable(currentListItem, 3);
        return this;
    }

    public boolean isElemetDeleted() {
        boolean tshuva = true;
        try {
            tshuva = currentListItem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
        return tshuva;
    }

    public ReadingListPageHelper deleteItemByswipe() {
        swipeRight(500, 900, 1000);
        return this;
    }
}
