package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiTests extends TastBase {

    @Test
    public void simple() {
    }

    @Test
    public void deleteCreatedReadListThrowSwiping() {
        mainPage
                .clickFindButton()
                .findJavaWiki();
        currentPage
                .weitCurrentPageLoaded()
                .createBookmark();
        readListPage
                .newListCreate()
                .veiwCurrentList()
                .waitMyListIsLoaded()
                .deleteItemByswipe();

        Assert.assertFalse(readListPage.isElemetDeleted());

    }
}
