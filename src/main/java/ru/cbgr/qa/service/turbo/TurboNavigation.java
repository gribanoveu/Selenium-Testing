package ru.cbgr.qa.service.turbo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.cbgr.qa.base.Driver;
import ru.cbgr.qa.helpers.Action;

import java.time.Duration;
import java.util.List;

/**
 * @author Evgeny Gribanov
 * @version 27.10.2022
 * @link egribanov@cbgr.ru
 */
public class TurboNavigation {
    private static final String CLOSE_TAB_BUTTON_LOCATOR = "//*/span[@data-testid='tab-bar__tab-icon']";
    public static final String INDICATOR_LOCATOR = "//*[@id='indicator']/div";
    public static final String LEFT_ARROW_LOCATOR = "//*[@data-testid='button' and @data-nav='prev']";
    public static final String TAB_BAR = "//div[@data-testid='tab-bar__tab']";
    public static final String CLOSE_ALL_TABS_BUTTON = "//span[text()='Закрыть все' and contains(@data-testid,'context-menu_caption')]";

    // отсутствие маски на элементе, нужна перед взаимодействиями с элементами и ассертами
    // маска присутствует во время обновления состояния элемента
    public static boolean isMaskClickable() {
        return isClickable(By.xpath(INDICATOR_LOCATOR));
    }

    public static boolean isClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(1), Duration.ofMillis(50));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }

    public static boolean isElementPresent(By by) {
        try {
            while (isMaskClickable()) {}
            Driver.getInstance().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void clickToLoginInAuthPage(String LOGIN) {
        String locatorUser = "//*[@data-testid='user']";
        String locatorLoginButton = "//*[@data-testid='button_caption']";
        String checkBoxLocator = "//*/div[contains(text(),'Отключить пользователя и продолжить')]";
        String loginButtonLocator = "//*[@data-testid='button_caption']";

        Action.TextBox.clearAndSendText(locatorUser, LOGIN);
        Action.OneClick.click(locatorLoginButton);

        while (TurboNavigation.isMaskClickable()) {}

        if (isElementFoundDisplayedEnabled(By.xpath("//*/div[contains(text(),'Отключить пользователя и продолжить')]"))) {
            Action.OneClick.click(checkBoxLocator);
            Action.OneClick.click(loginButtonLocator);
            while (TurboNavigation.isMaskClickable()) {}
        }
    }

    /** Если элемент отображается и чекбокс не нажат, вернуть true, иначе false */
    private static boolean isElementFoundDisplayedEnabled(By by) {
        try {
            List<WebElement> e = Driver.getInstance().findElements(by);
            return !e.isEmpty() && e.get(e.size() - 1).isDisplayed() && e.get(e.size() - 1).isEnabled();
        } catch (Exception ignored) {}
        return false;
    }

    // закрытие по нажатию правой клавиши может работать нестабильно или не работать на старых версиях
    public static void closeOpenTabs() {
        Action.OneClick.contextClick(TAB_BAR);
        Action.OneClick.click(CLOSE_ALL_TABS_BUTTON);
    }
}
