package selenium.base;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.RemoteWebDriver;
import selenium.enums.Browsers;
import selenium.browser.Chrome;
import selenium.browser.Edge;
import selenium.browser.Firefox;

import java.net.MalformedURLException;

/** Класс для взаимодействия с вебдрайвером, реализует паттерн синглтон */
@Slf4j
public abstract class Driver {
    /** Единственный экземпляр вебдрайвера */
    private static RemoteWebDriver webDriver;

    /** Метод первичной настройки вебдрайвера, принимает в качестве аргумента название браузера из перечисления (enum)
     * При передаче строки необходимо привести значение к строке (Browsers.fromString(browserName)) */
    public static RemoteWebDriver setupDriver(Browsers name, Boolean enableRemote) {
        switch (name) {
            case CHROME : {
                log.info("Драйвер для браузера Google Chrome");
                webDriver = Chrome.getDriver(enableRemote);
                break;
            }
            case EDGE : {
                log.info("Драйвер для браузера Microsoft Edge");
                webDriver = Edge.getDriver(enableRemote);
                break;
            }
            case FIREFOX : {
                log.info("Драйвер для браузера Mozilla Firefox");
                webDriver = Firefox.getDriver(enableRemote);
                break;
            }
            default :
                throw new RuntimeException("Некорректное имя браузера");
        }
        return webDriver;
    }

    /** Получение уже созданного экземпляра вебдрайвера */
    public static RemoteWebDriver getInstance() {
        return webDriver;
    }
}
