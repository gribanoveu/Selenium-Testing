package selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.helpers.WaitHelper;

import java.time.Duration;

/** Базовый класс для всех элементов.
 * При создании нового вида элемента и способов взамодействия с ним следует наследоваться от данного класса */
public abstract class BaseElement {

    /** Получение вебэлемента */
    protected WebElement webElement;

    /** Получение локатора */
    protected By by;

    /** Установка ожидания, по истетечении которого происходит исключение */
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(5);

    /** Установка ожидания перерыва между повторным поиском */
    private static final Duration DURATION_SLEEP = Duration.ofSeconds(5);

    /**  Базовый элемент
     * @param by - локатор элемента
     * В конструкторе инициализируется длительность ожидания появления элемента
     * и осуществляется поиск элемента */
    public BaseElement(By by) {
        this.by = by;
        WaitHelper.initWait(DURATION_TIMEOUT, DURATION_SLEEP);
        WaitHelper.presenceOfElementLocated(by);
        webElement = Driver.getInstance().findElement(by);
    }

    /** Получение оборачиваемого элемента
     * Получив оборачиваемый элемент, можно вызвать его методы
     * Например, getText() */
    public WebElement getWebElement() {
        return webElement;
    }

}
