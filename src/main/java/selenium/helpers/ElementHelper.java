package selenium.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import selenium.base.Driver;

public class ElementHelper {

    /** Получить ширину элемента
     * @param locator - локатор элемента
     * @return значение ширины в int */
    public static int getWidthOfElement(By locator) {
        return Driver.getInstance().findElement(locator).getRect().getWidth();
    }

    /** Получить высоту элемента
     * @param locator - локатор элемента
     * @return значение высоты в int */
    public static int getHeightOfElement(By locator) {
        return Driver.getInstance().findElement(locator).getRect().getHeight();
    }

    /** Получить горизонтальную позицию элемента от верхнего левого угла страницы
     * @param locator - локатор элемента
     * @return значение позиции в int */
    public static int getXPositionOfElement(By locator) {
        return Driver.getInstance().findElement(locator).getRect().getX();
    }

    /** Получить вертикальную позицию элемента от верхнего левого угла страницы
     * @param locator - локатор элемент
     * @return значение позиции в int */
    public static int getYPositionOfElement(By locator) {
        return Driver.getInstance().findElement(locator).getRect().getY();
    }

    /** Используется для получения размеров и координат элемента
     * @param locator - локатор элемента
     * @return значение позиции в int */
    public static Rectangle getRectOfElement(By locator) {
        return Driver.getInstance().findElement(locator).getRect();
    }

    /** Получить значение css свойства элемента
     * @param locator - локатор элемента
     * @param cssProperty - испокомое проперти (background-color, etc.)
     * @return значение параметра в формате String */
    public static String getCSSValue(By locator, String cssProperty) {
        return Driver.getInstance().findElement(locator).getCssValue(cssProperty);
    }

    /** Получить значение css свойства элемента
     * @param locator - локатор элемента
     * @param attribute - имя искомого атрибута
     * @return значение атрибута в формате String */
    public static String getAttribute(By locator, String attribute) {
        return Driver.getInstance().findElement(locator).getAttribute(attribute);
    }

    /** Получить значение css свойства элемента
     * @param locator - локатор элемента
     * @return текст элемента в формате String */
    public static String getText(By locator) {
        return Driver.getInstance().findElement(locator).getText();
    }
}
