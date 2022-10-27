package ru.cbgr.qa.base;


import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import ru.cbgr.qa.enums.RemoteStand;
import ru.cbgr.qa.helpers.Action;
import ru.cbgr.qa.helpers.JavaScript;
import ru.cbgr.qa.helpers.Wait;
import ru.cbgr.qa.service.allure.AllureAttachments;
import ru.cbgr.qa.service.turbo.TurboNavigation;
import ru.cbgr.qa.enums.Browsers;

import java.time.Duration;

/** Базовый класс для всех тестов.
 * При создании нового теста следует наследоваться от данного класса.
 * Аннотация @Slf4j позволяет использовать логгирование путем вызова метода log.info(), etc */
@Slf4j
public abstract class BaseTest {

    /** Получение проперти для указания запуска браузера в maven -Dbrowser=firefox.
     * При передаче неверного значения используется значение по умолчанию */
    String browser = System.getProperty("browser", "chrome").toLowerCase();

    public static final String USER = System.getProperty("user", "AUTOWEB_TEST");
    public static final String STAND = System.getProperty("stand", "test");

     /** Получение проперти для указания запускать ли тесты на удаленной машине -Dremote=true.
      * Принимает только true или false значения.
      * При передаче неверного значения используется значение по умолчанию */
    String isRemoteDriver = System.getProperty("remote", "false");

    // инициализация ожиданий
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration DURATION_SLEEP = Duration.ofSeconds(1);

    /** Метод инициализации вебдрайвера, запускается перед выполнением тестов.
     * Получает название браузера.
     * Получает указание запускать ли удаленный вебдрайвер */
    @BeforeTest
    public void runBrowser() {
        Driver.setupDriver(Browsers.fromString(browser), Boolean.valueOf(isRemoteDriver));
        Wait.initWait(DURATION_TIMEOUT, DURATION_SLEEP);
        JavaScript.initJS();
        Action.initActions();
        log.info("Драйвер стартовал!");
    }

    /** Метод закрытия экземпляра ведбрайвера, выполняется после всех тестов */
    @AfterTest
    public void setDown() {
        if(Driver.getInstance() != null) {
            Driver.getInstance().quit();
            log.info("Драйвер остановлен!");
        }
    }

    @BeforeClass
    public void prepareBrowserBeforeTests() {
        checkLoginInSystem();
        TurboNavigation.closeOpenTabs();
        Driver.getInstance().manage().window().maximize();
    }

    @AfterGroups
    public void closeTabAfterTestGroup() {
        TurboNavigation.closeOpenTabs();
    }

    @Step("Проверка что вход в систему произведен")
    protected void checkLoginInSystem() {
        String currentUrl = Driver.getInstance().getCurrentUrl();
        // если драйвер отсутствует запустить заново
        if (Driver.getInstance() == null) runBrowser();
        else Driver.getInstance().navigate().refresh();
        // !! без этой проверки страница не открывается
        if (!currentUrl.contains("/workspace")) login();
    }

    @Step("Вход в систему")
    protected void login() {
        log.info("СОБЫТИЕ: LOGIN FROM ENV* -> " + USER);
        Driver.getInstance().get(RemoteStand.getStandUrl(STAND));
        AllureAttachments.getAllureEnvironment();
        TurboNavigation.clickToLoginInAuthPage(USER);
    }
}
