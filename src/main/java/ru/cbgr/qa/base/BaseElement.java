package ru.cbgr.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.cbgr.qa.helpers.Wait;

import java.time.Duration;

/** Базовый класс для всех элементов.
 * При создании нового вида элемента и способов взамодействия с ним следует наследоваться от данного класса */
@SuppressWarnings("unused")
public abstract class BaseElement {

    /** Получение вебэлемента */
    protected WebElement webElement;
    protected static Actions actions;

    /** Установка ожидания, по истетечении которого происходит исключение */
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(10);

    /** Установка ожидания перерыва между повторным поиском */
    private static final Duration DURATION_SLEEP = Duration.ofSeconds(1);

    /**  Базовый элемент
     * @param byXpath - локатор элемента
     * В конструкторе инициализируется длительность ожидания появления элемента
     * и осуществляется поиск элемента */
    public BaseElement(String byXpath) {
        Wait.initWait(DURATION_TIMEOUT, DURATION_SLEEP);
        Wait.visibleAndClickable(byXpath);
        webElement = Driver.getInstance().findElement(By.xpath(byXpath));
        actions = new Actions(Driver.getInstance());
    }

    /** Получение оборачиваемого элемента
     * Получив оборачиваемый элемент, можно вызвать его методы
     * Например, getText() */
    public WebElement getWebElement() {
        return webElement;
    }
}
