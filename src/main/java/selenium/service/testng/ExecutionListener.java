package selenium.service.testng;

import lombok.extern.slf4j.Slf4j;
import org.testng.IExecutionListener;


/**
 * author : egribanov
 * created : 23.02.2022, 20:20
 * Слушаель событий при запуске тестов и окончании
 * Используется для вычисления времени затраченного на выполнение тестов и записи его в логи
 * метод System.currentTimeMillis() не создает обьект для вычисления времени в отличии от new Date().getTime()
 **/
@Slf4j
public class ExecutionListener implements IExecutionListener {

    long startTime;
    long endTime;

    @Override
    public void onExecutionStart() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onExecutionFinish() {
        endTime = System.currentTimeMillis();
        float sec = (endTime - startTime) / 1000F;
        log.info("Время затраченное на выполнение тестов: " + sec + " секунд");
    }
}
