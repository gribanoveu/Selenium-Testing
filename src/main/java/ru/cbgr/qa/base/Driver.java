package ru.cbgr.qa.base;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.cbgr.qa.enums.Browsers;
import ru.cbgr.qa.browser.Chrome;
import ru.cbgr.qa.browser.Edge;
import ru.cbgr.qa.browser.Firefox;

/** Класс для взаимодействия с вебдрайвером, реализует паттерн синглтон */
@Slf4j
public abstract class Driver {
    /** Единственный экземпляр вебдрайвера */
    private static RemoteWebDriver webDriver;

    /** Метод первичной настройки вебдрайвера, принимает в качестве аргумента название браузера из перечисления (enum)
     * При передаче строки необходимо привести значение к строке (Browsers.fromString(browserName)) */
    public static void setupDriver(Browsers name, Boolean isRemoteDriver) {
        switch (name) {
            case CHROME : {
                log.info("Драйвер для браузера Google Chrome");
                webDriver = Chrome.getDriver(isRemoteDriver);
                break;
            }
            case EDGE : {
                log.info("Драйвер для браузера Microsoft Edge");
                webDriver = Edge.getDriver(isRemoteDriver);
                break;
            }
            case FIREFOX : {
                log.info("Драйвер для браузера Mozilla Firefox");
                webDriver = Firefox.getDriver(isRemoteDriver);
                break;
            }
            default :
                throw new RuntimeException("Некорректное имя браузера");
        }
    }

    /** Получение уже созданного экземпляра вебдрайвера */
    public static RemoteWebDriver getInstance() {
        return webDriver;
    }
}
