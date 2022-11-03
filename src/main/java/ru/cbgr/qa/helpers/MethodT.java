package ru.cbgr.qa.helpers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cbgr.qa.base.Driver;
import ru.cbgr.qa.service.turbo.TurboNavigation;

/**
 * @author Evgeny Gribanov
 * @version 27.10.2022
 * @link egribanov@cbgr.ru
 */
@Slf4j
@SuppressWarnings("StatementWithEmptyBody")
public class MethodT {
    public static void printElementCssAndAttributeProperty(String locator, String atribute) {
        String getCSS = Driver.getInstance().findElement(By.xpath(locator)).getCssValue(atribute);
        String getAttribute = Driver.getInstance().findElement(By.xpath(locator)).getAttribute(atribute);
        log.info(" CSS --> " + atribute + " --> " + getCSS);
        log.info(" Attribute --> " + atribute + " --> " + getAttribute);
    }

    // получение значения атрибута {searchedAttribute}
    public static String getElementCssProperty(String elementLocator, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        Wait.visibleAndClickable(elementLocator);
        return Driver.getInstance().findElement(By.xpath(elementLocator)).getCssValue(searchedAttribute);
    }

    // получение значения атрибута {searchedAttribute}
    public static boolean isCssPropertyEmpty(String elementLocator, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        Wait.visibleAndClickable(elementLocator);
        log.info(Driver.getInstance().findElement(By.xpath(elementLocator)).getCssValue(searchedAttribute));
        return Driver.getInstance().findElement(By.xpath(elementLocator)).getCssValue(searchedAttribute).isEmpty();
    }

    // получение значения атрибута {searchedAttribute}
    public static String getElementAttributeProperty(String elementLocator, String searchedAttribute) {
        while (TurboNavigation.isMaskClickable()) {}
        Wait.visibleAndClickable(elementLocator);
        return Driver.getInstance().findElement(By.xpath(elementLocator)).getAttribute(searchedAttribute);
    }

    // Получаем текст из инф. поля
    public static String getElementTextValue(String locatorInfo) {
        while (TurboNavigation.isMaskClickable()) {}
        Wait.visibleAndClickable(locatorInfo);
        return Driver.getInstance().findElement(By.xpath(locatorInfo)).getText();
    }

    // Получить количество элементов
    public static int getNumberOfElements(String locator) {
        while (TurboNavigation.isMaskClickable()) {}
        Wait.visibleAndClickable(locator);
        return Driver.getInstance().findElements(By.xpath(locator)).size();
    }

    // получить вебэлемент по локатору
    public static WebElement getWebElement(String locator) {
        return Driver.getInstance().findElement(By.xpath(locator));
    }

    /** Получить высоту элемента
     * @param locator - локатор элемента
     * @return значение высоты в int */
    public static int getHeightOfElement(String locator) {
        return Driver.getInstance().findElement(By.xpath(locator)).getRect().getHeight();
    }

    public static int getCSSValueAsInt(String locator, String CSS) {
        String getElementHeightAsString = MethodT.getElementCssProperty(locator, CSS);
        log.info("Значение атрибута " + CSS + ": " + getElementHeightAsString);
        return Integer.parseInt(getElementHeightAsString.replaceAll("[^0-9]",""));
    }
}
