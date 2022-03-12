package selenium.base;


import selenium.helpers.ActionHelper;
import selenium.helpers.JavaScriptHelper;
import selenium.helpers.WaitHelper;

import java.time.Duration;

/** Базовый класс для всех страниц.
 * При создании новой страницы и способов взамодействия с ней следует наследоваться от данного класса */
public abstract class BasePage {

    /** Установка ожидания, по истетечении которого происходит исключение, в секундах */
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(10);
    /** Установка ожидания перерыва между повторным поиском, в миллисекундах */
    private static final Duration DURATION_SLEEP = Duration.ofMillis(100);

    /**  Конструктор базового класса
     * Инициализируются ожидания, скрипты JS, действия с курсором */
    public BasePage() {
        WaitHelper.initWait(DURATION_TIMEOUT, DURATION_SLEEP);
        JavaScriptHelper.initJS();
        ActionHelper.initActions();
    }

    /** Получение заголовка текущей страницы */
    public static String getPageTitle() {
        return Driver.getInstance().getTitle();
    }
}
