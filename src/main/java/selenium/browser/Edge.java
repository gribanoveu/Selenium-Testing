package selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import selenium.enums.RemoteStand;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@Slf4j
public class Edge {
    /** Возвращает экземпляр вебдрайвера для запуска Microsoft Edge */
    public static RemoteWebDriver getDriver(Boolean isRemoteDriver) {
        // инициализация нужной версии вебдрайвера в зависимости от установленной версии браузера
        WebDriverManager.edgedriver().setup();

        // установка состояния браузера
        EdgeOptions options = new EdgeOptions();
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);

        // установка аргументов запуска
        options.addArguments("--incognito");
        options.addArguments("--start-fullscreen");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "edge");
        capabilities.setCapability("browserVersion", "98.0");
        capabilities.setCapability(EdgeOptions.CAPABILITY, options);
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        try {
            if (isRemoteDriver) {
                log.info("Запрошено выполнение тестов на удаленной машине!");
                return new RemoteWebDriver(new URL(RemoteStand.REMOTE_URL.getRemoteUrl()), capabilities);
            }
        } catch (MalformedURLException e) {
            log.error("Получен некорректный URL-адресс, запуск тестов на локальной машине!");
            throw new RuntimeException("Некорректный адрес удаленной машины!");
        }

        return new EdgeDriver(options);
    }
}
