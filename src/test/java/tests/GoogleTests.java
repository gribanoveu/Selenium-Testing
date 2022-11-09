package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.cbgr.qa.base.BaseTest;
import ru.cbgr.qa.element.Action;
import ru.cbgr.qa.service.testng.RetryListener;
import ru.cbgr.qa.service.testng.TestErrorListener;


/**
 * author : egribanov
 * created : 23.02.2022, 19:03
 **/
@Slf4j
@Listeners(TestErrorListener.class)
public class GoogleTests extends BaseTest {

    @Test(retryAnalyzer = RetryListener.class)
    public void searchSelenium() throws InterruptedException {
        Action.byXpath("//div[@data-testid='main-menu-button']").contextClick();
        Thread.sleep(5000);
    }
}
