package selenium.helpers;


import selenium.base.Driver;

/** Класс для перемещения по страницам */
public class NavigateHelper {

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
