package selenium.service.testng;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * author : egribanov
 * created : 23.02.2022, 20:00
 * Слушатель для анализа запуска тестов
 * Запускает повторно тесты в случае неудачи не более 2х раз (указанно в переменной maxRetryCount)
 **/
@Slf4j
public class RetryListener implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            log.error("Тест завершился неудачно, повторная попытка запуска!");
            return true;
        }
        log.error("!!! ТЕСТ ЗАВЕРШЕН НЕУДАЧНО ПОСЛЕ " + retryCount + " ПОПЫТОК !!!");
        return false;
    }
}
