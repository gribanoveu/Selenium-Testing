package ru.cbgr.qa.base;


import ru.cbgr.qa.helpers.JavaScript;
import ru.cbgr.qa.helpers.Wait;

import java.time.Duration;

/** Базовый класс для всех страниц.
 * При создании новой страницы и способов взамодействия с ней следует наследоваться от данного класса */
@SuppressWarnings("unused")
public abstract class BasePage {

    /** Установка ожидания, по истетечении которого происходит исключение, в секундах */
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(10);
    /** Установка ожидания перерыва между повторным поиском, в миллисекундах */
    private static final Duration DURATION_SLEEP = Duration.ofMillis(100);

    /**  Конструктор базового класса
     * Инициализируются ожидания, скрипты JS, действия с курсором */
    public BasePage() {
        Wait.initWait(DURATION_TIMEOUT, DURATION_SLEEP);
        JavaScript.initJS();
    }

    /** Получение заголовка текущей страницы */
    public static String getPageTitle() {
        return Driver.getInstance().getTitle();
    }

    /** Получение URL текущей страницы */
    public static String getPageURL() {
        return Driver.getInstance().getCurrentUrl();
    }
}
