package ru.cbgr.qa.helpers;


import ru.cbgr.qa.base.Driver;

/** Класс для перемещения по страницам */
public class Navigate {

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
