package selenium.helpers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import selenium.base.Driver;

/** Класс для работы с куки
 * author : egribanov
 * created : 16.03.2022, 22:09
 **/
@Slf4j
public class CookieHelper {

    /** Логирование доступных куки */
    public static void printBasicCookieInfo() {
        log.info("--- Получены следующие куки (имя/значение): ---");
        for (Cookie cookie: Driver.getInstance().manage().getCookies()) {
            log.info("Name: " + cookie.getName() + " | Value: " + cookie.getValue());
        }
        log.info("--- Конец полученных куки ---");
    }

    /** Получение значения куки по его имени */
    public static String getValueNamedCookie(String cookieName) {
        String cookieValue = String.valueOf(Driver.getInstance().manage().getCookieNamed(cookieName).getValue());
        log.info("Cookie: " + cookieName + " имеет значение: " + cookieValue);
        return cookieValue;
    }

}
