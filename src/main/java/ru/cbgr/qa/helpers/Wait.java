package ru.cbgr.qa.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.cbgr.qa.base.Driver;

import java.time.Duration;

/** Класс для ожидания элементов */
public class Wait {
    protected static WebDriverWait wait;

    /** Установка таймаута ожидания и интервал опроса */
    public static void initWait(Duration timeOut, Duration sleep) {
        wait = new WebDriverWait(Driver.getInstance(), timeOut, sleep);
    }

    public static void visibleAndClickable(String webElement) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElement)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webElement)));
    }

    /** Ожидание наличия элемента по локатору */
    public static void presenceOfElementLocated(String webElement) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(webElement)));
    }

    /** Ожидание появления текста в элементе */
    public static void presenceOfTextInElement(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    /** Ожидание кликабельности элемента */
    public static void clickabilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /** Ожидание кликабельности элемента по локатору */
    public static void clickabilityOfElement(String webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webElement)));
    }

    /** Ожидание видимости элемента */
    public static void visibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /** Ожидание видимости элемента по локатору */
    public static void visibilityOfElementLocated(String webElement) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElement)));
    }

    /** Ожидание появления в списке продуктов в первой позиции заданного продукта */
    @Deprecated
    public static void firstWebElementMustBe(String webElement, String text) {
        wait.until((ExpectedCondition<Boolean>) webDriver ->
                webDriver.findElement(By.xpath(webElement)).getText().contains(text));
    }

    /** Ожидание появления всплывающего алерта */
    public static void waitWhenAlertIsPresents() {
         wait.until(ExpectedConditions.alertIsPresent());
    }

    public static boolean isElementDisplayed(String webElement) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElement))).isDisplayed();
    }
}
