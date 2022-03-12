package selenium.base;


import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import selenium.enums.Browsers;

import java.net.MalformedURLException;

/** Базовый класс для всех тестов.
 * При создании нового теста следует наследоваться от данного класса.
 * Аннотация @Slf4j позволяет использовать логгирование путем вызова метода log.info(), etc */
@Slf4j
public abstract class BaseTest {
    /** Получение проперти для указания запуска браузера в maven -Dbrowser=firefox.
     * При передаче неверного значения используется значение по умолчанию */
    String browser = System.getProperty("browser", "chrome").toLowerCase();

     /** Получение проперти для указания запускать ли тесты на удаленной машине -Dremote=true.
      * Принимает только true или false значения.
      * При передаче неверного значения используется значение по умолчанию */
    String enableRemoteWebDriver = System.getProperty("remote", "false");

    /** Метод инициализации вебдрайвера, запускается перед выполнением тестов.
     * Получает название браузера.
     * Получает указание запускать ли удаленный вебдрайвер */
    @BeforeTest
    public void setUp() throws MalformedURLException {
        Driver.setupDriver(Browsers.fromString(browser), Boolean.valueOf(enableRemoteWebDriver));
        log.info("Драйвер стартовал!");
    }

    /** Метод закрытия экземляра ведбрайвера, выполняется после всех тестов */
    @AfterTest
    public void setDown() {
        if(Driver.getInstance() != null) {
            Driver.getInstance().quit();
            log.info("Драйвер остановлен!");
        }
    }
}
