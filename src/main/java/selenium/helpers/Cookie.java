package selenium.helpers;

import lombok.extern.slf4j.Slf4j;
import selenium.base.Driver;

/** Класс для работы с куки
 * author : egribanov
 * created : 16.03.2022, 22:09
 **/
@Slf4j
public class Cookie {

    /** Логирование доступных куки */
    public static void printBasicCookieInfo() {
        log.info("Получены следующие куки (имя/значение): ");
        for (org.openqa.selenium.Cookie cookie: Driver.getInstance().manage().getCookies()) {
            log.info(" - " + cookie.getName() + " / " + cookie.getValue());
        }
        log.info("Конец полученных куки ");
    }

    /** Получение значения куки по его имени */
    public static String getValueNamedCookie(String cookieName) {
        String cookieValue = String.valueOf(Driver.getInstance().manage().getCookieNamed(cookieName).getValue());
        log.info("Cookie: " + cookieName + " имеет значение: " + cookieValue);
        return cookieValue;
    }

    /** Добавление куки, передается имя и значение */
    public static void addCookie(String cookieName, String cookieValue) {
        Driver.getInstance().manage().addCookie(new org.openqa.selenium.Cookie(cookieName, cookieValue));
        log.info("Отправлен запрос на добавление куки с именем: '" + cookieName + "' и значением: '" + cookieValue + "'");
    }

    /** Добавление куки, передается имя и значение */
    public static void addCookie(org.openqa.selenium.Cookie cookie) {
        Driver.getInstance().manage().addCookie(cookie);
        log.info("Отправлен запрос на добавление куки");
    }

    /** Удаление куки */
    public static void deleteCookie(String cookieName) {
        Driver.getInstance().manage().deleteCookieNamed(cookieName);
        log.info("Отправлен запрос на удаление куки с именем: '" + cookieName + "'");
    }

    /** Удаление куки */
    public static void deleteCookie(org.openqa.selenium.Cookie cookie) {
        Driver.getInstance().manage().deleteCookie(cookie);
        log.info("Отправлен запрос на удаление куки");
    }

    /** Удаление всех куки */
    public static void deleteAllCookie() {
        Driver.getInstance().manage().deleteAllCookies();
        log.info("Отправлен запрос на удаление всех куки");
    }
}
