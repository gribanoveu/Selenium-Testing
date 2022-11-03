package tests;

import org.testng.annotations.Test;
import ru.cbgr.qa.base.BaseTest;
import ru.cbgr.qa.service.testng.RetryListener;

/**
 * @author Evgeny Gribanov
 * @version 28.10.2022
 * @link egribanov@cbgr.ru
 */
public class GoogleTests2 extends BaseTest {
    @Test(retryAnalyzer = RetryListener.class)
    public void searchSelenium() throws InterruptedException {
        Thread.sleep(5000);
    }
}
