package selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import selenium.enums.RemoteStand;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class Firefox {
    /** Возвращает экземпляр вебдрайвера для запуска Google Chrome */
    public static RemoteWebDriver getDriver(Boolean enableRemoteWebDriver) {
        // инициализация нужной версии вебдрайвера в зависимости от установленной версии браузера
        WebDriverManager.firefoxdriver().setup();

        // установка состояния браузера
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);

        // установка аргументов запуска
        options.addArguments("-private");
        options.addArguments("-kiosk");

        try {
            if (enableRemoteWebDriver) {
                log.info("Запрошено выполнение тестов на удаленной машине!");
                return new RemoteWebDriver(new URL(RemoteStand.REMOTE_URL.getRemoteUrl()), options);
            }
        } catch (MalformedURLException e) {
            log.error("Получен некорректный URL-адресс, запуск тестов на локальной машине!");
            return new FirefoxDriver(options);

        }

        return new FirefoxDriver(options);
    }
}
