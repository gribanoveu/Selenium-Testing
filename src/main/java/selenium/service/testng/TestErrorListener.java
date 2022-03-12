package selenium.service.testng;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;
import selenium.service.allure.AllureAttachments;


/**
 * author : egribanov
 * created : 23.02.2022, 20:56
 * Слушатель для анализа выполнения тестов
 * В случае неудачи прикрмпляет скриншот в allure
 **/
@Slf4j
public class TestErrorListener implements ITestListener{

    @Override
    public void onTestFailure(ITestResult result) {
        AllureAttachments.attachScreenshot("SCREENSHOT-FAIL");
        AllureAttachments.attachAsText("INFO",
                 "Тест завершился неудачно: " + result.getInstanceName() +
                         "\nОшибка при выполнении метода: " + result.getMethod().getMethodName());
        log.info("Ошибка при выполнении метода " + result.getMethod().getMethodName());
        log.info("Скриншот страницы сохранен");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        AllureAttachments.attachScreenshot("SCREENSHOT-SKIP");
        AllureAttachments.attachAsText("INFO",
                "Тест пропущен: " + result.getInstanceName() +
                        "\nОшибка при выполнении метода: " + result.getMethod().getMethodName());
        log.info("Ошибка при выполнении метода " + result.getMethod().getMethodName());
        log.info("Скриншот страницы сохранен");
    }
}
