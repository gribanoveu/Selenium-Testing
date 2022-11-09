package ru.cbgr.qa.helpers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import ru.cbgr.qa.base.Driver;
import ru.cbgr.qa.service.turbo.TurboNavigation;

@Slf4j
@SuppressWarnings({"StatementWithEmptyBody", "unused"})
public class Element {

    /** Получить ширину элемента
     * @param locator - локатор элемента
     * @return значение ширины в int */
    public static int getWidthOfElement(String locator) {
        while (TurboNavigation.isMaskClickable()) {}
        return Driver.getInstance().findElement(By.xpath(locator)).getRect().getWidth();
    }

    /** Получить высоту элемента
     * @param locator - локатор элемента
     * @return значение высоты в int */
    public static int getHeightOfElement(String locator) {
        while (TurboNavigation.isMaskClickable()) {}
        return Driver.getInstance().findElement(By.xpath(locator)).getRect().getHeight();
    }

    /** Получить горизонтальную позицию элемента от верхнего левого угла страницы
     * @param locator - локатор элемента
     * @return значение позиции в int */
    public static int getXPositionOfElement(String locator) {
        while (TurboNavigation.isMaskClickable()) {}
        return Driver.getInstance().findElement(By.xpath(locator)).getRect().getX();
    }

    /** Получить вертикальную позицию элемента от верхнего левого угла страницы
     * @param locator - локатор элемент
     * @return значение позиции в int */
    public static int getYPositionOfElement(String locator) {
        while (TurboNavigation.isMaskClickable()) {}
        return Driver.getInstance().findElement(By.xpath(locator)).getRect().getY();
    }

    /** Используется для получения размеров и координат элемента
     * @param locator - локатор элемента
     * @return значение позиции в int */
    public static Rectangle getRectOfElement(String locator) {
        while (TurboNavigation.isMaskClickable()) {}
        return Driver.getInstance().findElement(By.xpath(locator)).getRect();
    }

    /** Получить значение css свойства элемента
     * @param locator - локатор элемента
     * @param cssProperty - искомое проперти (background-color, etc.)
     * @return значение параметра в формате String */
    public static String getCSSValue(String locator, String cssProperty) {
        while (TurboNavigation.isMaskClickable()) {}
        return Driver.getInstance().findElement(By.xpath(locator)).getCssValue(cssProperty);
    }

    /** Получить значение css свойства элемента
     * @param locator - локатор элемента
     * @param attribute - имя искомого атрибута
     * @return значение атрибута в формате String */
    public static String getAttribute(String locator, String attribute) {
        while (TurboNavigation.isMaskClickable()) {}
        return Driver.getInstance().findElement(By.xpath(locator)).getAttribute(attribute);
    }

    /** Получить значение css свойства элемента
     * @param locator - локатор элемента
     * @return текст элемента в формате String */
    public static String getText(String locator) {
        while (TurboNavigation.isMaskClickable()) {}
        return Driver.getInstance().findElement(By.xpath(locator)).getText();
    }

    public static int getNumberOfElements(String locator) {
        while (TurboNavigation.isMaskClickable()) {}
        return Driver.getInstance().findElements(By.xpath(locator)).size();
    }

    public static int getCSSValueAsInt(String locator, String CSS) {
        String getElementHeightAsString = getCSSValue(locator, CSS);
        log.info("Значение атрибута " + CSS + ": " + getElementHeightAsString);
        return Integer.parseInt(getElementHeightAsString.replaceAll("[^0-9]",""));
    }
}
