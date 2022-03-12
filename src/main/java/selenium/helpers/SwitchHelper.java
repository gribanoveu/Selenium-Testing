package selenium.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import selenium.base.Driver;

/** Класс для переключения окон */
public class SwitchHelper {

    /** Переключение на созданное окно */
    public static void switchToExistWindow(String window) {
        Driver.getInstance().switchTo().window(window);
    }

    /** Переключение на создаваемое окно */
    public static void switchToNewWindow() {
        Driver.getInstance().switchTo().newWindow(WindowType.WINDOW);
    }

    /** Переключение на создаваемую вкладку */
    public static void switchToNewTab() {
        Driver.getInstance().switchTo().newWindow(WindowType.TAB);
    }

    /** Переключение на алерт */
    public static void switchToAlert() {
        Driver.getInstance().switchTo().alert();
    }

    /** Переключение на фрейм по его индексу */
    public static void switchToFrameByIndex(int index) {
        Driver.getInstance().switchTo().frame(index);
    }

    /** Переключение на фрейм по его атрибуту name или id */
    public static void switchToFrameByNameOrId(String nameOrId) {
        Driver.getInstance().switchTo().frame(nameOrId);
    }

    /** Переключение на фрейм по веб элементу */
    public static void switchToFrameByFrameWebElement(WebElement webElement) { Driver.getInstance().switchTo().frame(webElement); }

    /** Переключение на родительский фрейм */
    public static void switchToParentFrame() {
        Driver.getInstance().switchTo().parentFrame();
    }

    /** Переключение на основной документ */
    public static void switchToDefaultContent() {
        Driver.getInstance().switchTo().defaultContent();
    }

    /** Переключение на активный веб элемент */
    public static void switchToActiveWebElement() {
        Driver.getInstance().switchTo().activeElement();
    }
}
