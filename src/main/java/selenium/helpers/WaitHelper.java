package selenium.helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.Driver;

import java.time.Duration;

/** Класс для ожидания элементов */
public class WaitHelper {

    protected static WebDriverWait wait;

    /** Установка таймаута ожидания и интервал опроса */
    public static void initWait(Duration timeOut, Duration sleep) {
        wait = new WebDriverWait(Driver.getInstance(), timeOut, sleep);
    }

    /** Ожидание наличия элемента по локатору */
    public static void presenceOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
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
    public static void clickabilityOfElement(By webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /** Ожидание видимости элемента */
    public static void visibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /** Ожидание видимости элемента по локатору */
    public static void visibilityOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }

    /** Ожидание появления в списке продуктов в первой позиции заданного продукта */
    @Deprecated
    public static void firstWebElementMustBe(By webElement, String text) {
        wait.until((ExpectedCondition<Boolean>) webDriver ->
                webDriver.findElement(webElement).getText().contains(text));
    }

    /** Ожидание появления всплывающего алерта */
    public static void waitWhenAlertIsPresents() {
         wait.until(ExpectedConditions.alertIsPresent());
    }
}
