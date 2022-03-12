package selenium.helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import selenium.base.Driver;

/** Класс для взаимодействия с размером и положением окна */
public class WindowHelper {

    /** Минимизация размеров окна */
    public static void minimizeWindow() {
        Driver.getInstance().manage().window().minimize();
    }

    /** Максимизация размеров окна */
    public static void maximizeWindow () {
        Driver.getInstance().manage().window().maximize();
    }

    /** Отображение окна браузера в полноэкранном режиме */
    public static void fullscreenWindow () {
        Driver.getInstance().manage().window().fullscreen();
    }

    /** Получение координат расположения окна */
    public static Point getWindowPosition() {
        return Driver.getInstance().manage().window().getPosition();
    }

    /** Установка координат расположения окна */
    public static void setWindowPosition(Point position) {
        Driver.getInstance().manage().window().setPosition(position);
    }

    /** получение размеров окна */
    public static Dimension getWindowSize() {
        return Driver.getInstance().manage().window().getSize();
    }

    /** Установка размеров окна */
    public static void setWindowSize(Dimension dimension) {
        Driver.getInstance().manage().window().setSize(dimension);
    }
}
