package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class PageBase {
    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }


    public void fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
    }

    public void waitUntilElementDisappears(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsAreVisible(List<WebElement> list, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void waitUntilAllWindowsAreLoaded(int windows, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.numberOfWindowsToBe(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsClickabl(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rotationScreenLandScape() {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void rotationScreenPortrate() {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public String getAnotherWindowHandle() {
        String firstWindow = driver.getWindowHandle();
        String secondWindow = "";
        for (String wCode : driver.getWindowHandles()) {
            System.out.println("Window: " + wCode);
            if (!wCode.equals(firstWindow)) secondWindow = wCode;
        }
        return secondWindow;
    }


    public void runBackGround(int time) {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.runAppInBackground(Duration.ofSeconds(time));
    }


    public void swipeUp() {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        TouchAction action = new TouchAction(appiumDriver);
        Dimension size = appiumDriver.manage().window().getSize();
        int x = (int) (size.width * 0.5);
        int y1 = (int) (size.height * 0.8);
        int y2 = (int) (size.height * 0.2);
        action
                .press(PointOption.point(x, y1))
                .waitAction()
                .moveTo(PointOption.point(x, y2))
                .release()
                .perform();
    }

    public void swipeDown() {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        TouchAction action = new TouchAction(appiumDriver);
        Dimension size = appiumDriver.manage().window().getSize();
        int x = (int) (size.width * 0.5);
        int y1 = (int) (size.height * 0.2);
        int y2 = (int) (size.height * 0.8);
        action
                .press(PointOption.point(x, y1))
                .waitAction()
                .moveTo(PointOption.point(x, y2))
                .release()
                .perform();
    }

    public void swipeUpToElement(By by, int maxTime) {
        int swipeCount = 0;
        while (driver.findElements(by).size() == 0 && swipeCount < maxTime) {
            swipeUp();
            swipeCount++;
        }
    }

    public void swipeRight(int x1, int x2, int y) {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        TouchAction action = new TouchAction(appiumDriver);
        Dimension size = appiumDriver.manage().window().getSize();
        action
                .press(PointOption.point(x1, y))
                .waitAction()
                .moveTo(PointOption.point(x2, y))
                .release()
                .perform();
    }

}
