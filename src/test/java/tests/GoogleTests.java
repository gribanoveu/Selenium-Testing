package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GoogleResultPage;
import selenium.base.BaseTest;
import selenium.helpers.CookieHelper;
import selenium.helpers.NavigateHelper;
import selenium.helpers.ScreenshotHelper;
import selenium.helpers.WindowHelper;
import selenium.service.testng.RetryListener;
import selenium.service.testng.TestErrorListener;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * author : egribanov
 * created : 23.02.2022, 19:03
 **/
@Slf4j
@Listeners(TestErrorListener.class)
public class GoogleTests extends BaseTest {
    private static final String URL = "https://www.google.ru/";

    @Test(retryAnalyzer = RetryListener.class)
    public void searchSelenium() {
        GoogleMainPage googleMainPage = new GoogleMainPage();
        GoogleResultPage googleResultPage = new GoogleResultPage();

        NavigateHelper.openPage(URL);

        googleMainPage.
                enterTextInSearchBox("Selenium").
                pressSearchButton();

        String expectedTextValue = googleResultPage.getCardTitle();

        assertThat(expectedTextValue).contains("Selenium");
    }

    @Test
    public void open() {
        NavigateHelper.openPage("https://ya.ru");
        log.info(WindowHelper.getWindowHandle());
        ScreenshotHelper.getPageScreenshot("страница");
    }
}
