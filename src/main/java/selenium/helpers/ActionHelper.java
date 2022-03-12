package selenium.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.base.Driver;

/** Класс для взаимодействия с курсором */
public class ActionHelper {

    protected static Actions actions;

    /** Инициализация действий */
    public static void initActions() {
        actions = new Actions(Driver.getInstance());
    }

    /** Перемещение курсора на элемент */
    public static void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }
}
