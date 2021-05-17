package Tests;


import Pages.CurrentPageHelper;
import Pages.MainPageHelper;
import Pages.ReadingListPageHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class TastBase {
    AppiumDriver driver;
    MainPageHelper mainPage;
    CurrentPageHelper currentPage;
    ReadingListPageHelper readListPage;

    @BeforeMethod(alwaysRun = true)
    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "org.wikipedia.page.PageActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:/Users/Igor/IdeaProjects/WikipediaMob/apk/wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
        currentPage = PageFactory.initElements(driver, CurrentPageHelper.class);
        readListPage = PageFactory.initElements(driver, ReadingListPageHelper.class);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage
                .waitPageIsLoaded()
                .rotationScreenPortrate();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}
