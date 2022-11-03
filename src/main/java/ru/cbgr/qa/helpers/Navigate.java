package ru.cbgr.qa.helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import ru.cbgr.qa.base.Driver;

import static ru.cbgr.qa.service.turbo.TurboNavigation.isMaskClickable;

/** Класс для перемещения по страницам */
@SuppressWarnings("StatementWithEmptyBody")
public class Navigate {
    private static final String FORM_NAME_LOCATOR = "//*[contains(@data-testid,'%s')]";

    public static void openTurboPage(String formLocators) {
        var locator = String.format(FORM_NAME_LOCATOR, formLocators);
        while (isMaskClickable()){}
        if (!Wait.isElementDisplayed(locator)) {
            Action.Move.moveTo(locator);
        }
        Action.OneClick.click(locator);
    }

    /** Открытие новой страницы */
    public static void openPage(String URL) {
        Driver.getInstance().navigate().to(URL);
    }

    /** Переход на предыдущую страницу */
    public static void back() {
        Driver.getInstance().navigate().back();
    }

    /** Переход на следующую страницу */
    public static void forward() {
        Driver.getInstance().navigate().forward();
    }

    /** Обновление страницы */
    public static void refresh() {
        Driver.getInstance().navigate().refresh();
    }
}
