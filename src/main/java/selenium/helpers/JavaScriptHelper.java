package selenium.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import selenium.base.Driver;

/** Класс для выполняния JavaScript скриптов */
public class JavaScriptHelper {
    protected static JavascriptExecutor js;

    /** Инициализация исполнителя Js скриптов */
    public static void initJS() {
        js = Driver.getInstance();
    }

    /** Скролл страницы на заданное расстояние в пикселях по X и по Y */
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        js.executeScript(script);
    }

    /** Установка невидимости веб элемента */
    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        js.executeScript(script, element);
    }
}
