package ru.cbgr.qa.service.turbo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import ru.cbgr.qa.base.Driver;
import ru.cbgr.qa.helpers.Action;

import java.time.Duration;

/**
 * @author Evgeny Gribanov
 * @version 27.10.2022
 * @link egribanov@cbgr.ru
 */
public class TurboNavigation {
    public static final String INDICATOR_LOCATOR = "//*[@id='indicator']/div";
    public static final String TAB_BAR = "//div[@data-testid='tab-bar__tab']";
    public static final String CLOSE_ALL_TABS_BUTTON = "//span[text()='Закрыть все' and contains(@data-testid,'context-menu_caption')]";
    public static final String LOCATOR_LOGIN_USER_BOX = "//*[@data-testid='user']";
    public static final String LOCATOR_LOGIN_BUTTON = "//*[@data-testid='button_caption']";
    public static final String LOCATOR_LOGIN_CHECK_BOX = "//div[contains(text(),'Отключить пользователя')]";

    // отсутствие маски на элементе, нужна перед взаимодействиями с элементами и ассертами
    // маска присутствует во время обновления состояния элемента
    public static boolean isMaskClickable() {
        return isElementClickableIgnoreExceptions(By.xpath(INDICATOR_LOCATOR));
    }

    public static boolean isElementClickableIgnoreExceptions(By by) {
        var wait = new FluentWait<WebDriver>(Driver.getInstance())
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }

    public static void clickToLoginInAuthPage(String LOGIN) {
        Action.byXpath(LOCATOR_LOGIN_USER_BOX).click().clear().enterText(LOGIN);
        Action.byXpath(LOCATOR_LOGIN_BUTTON).click();

        while (TurboNavigation.isMaskClickable()) {}

        if (isElementFoundDisplayedEnabled(By.xpath(LOCATOR_LOGIN_CHECK_BOX))) {
            Action.byXpath(LOCATOR_LOGIN_CHECK_BOX).click();
            Action.byXpath(TurboNavigation.LOCATOR_LOGIN_BUTTON).click();
            while (TurboNavigation.isMaskClickable()) {}
        }
    }

    /** Если элемент отображается и чекбокс не нажат, вернуть true, иначе false
     * Поиск элемента как списка если чекбокс найден и включен true, иначе пробуем опять */
    private static boolean isElementFoundDisplayedEnabled(By by) {
        try {
            var element = Driver.getInstance().findElements(by);
            return !element.isEmpty()
                    && element.get(element.size() - 1).isDisplayed()
                    && element.get(element.size() - 1).isEnabled();
        } catch (Exception ignored) {}
        return false;
    }

    // закрытие по нажатию правой клавиши может работать нестабильно или не работать на старых версиях
    public static void closeOpenTabs() {
        Action.byXpath(TAB_BAR).contextClick();
        Action.byXpath(CLOSE_ALL_TABS_BUTTON).click();
    }
}
