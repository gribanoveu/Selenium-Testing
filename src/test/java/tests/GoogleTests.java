package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.cbgr.qa.base.BaseTest;
import ru.cbgr.qa.helpers.Action;
import ru.cbgr.qa.service.testng.RetryListener;
import ru.cbgr.qa.service.testng.TestErrorListener;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * author : egribanov
 * created : 23.02.2022, 19:03
 **/
@Slf4j
@Listeners(TestErrorListener.class)
public class GoogleTests extends BaseTest {
    private static final String URL = "https://www.google.ru/";
    public static final String SEARCH_BUTTON = "//*[text()='Картинки']";

    @Test(retryAnalyzer = RetryListener.class)
    public void searchSelenium() throws InterruptedException {
        Thread.sleep(5000);
    }
}
