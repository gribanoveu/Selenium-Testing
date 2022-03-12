package selenium.service.allure;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import selenium.base.Driver;

import java.nio.charset.StandardCharsets;

/** Класс для вызова методов прикрепления обьектов в отчет allure */
public class AllureAttachments {

    /** прикрепляет текстовое сообщение в отчет */
    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    /** прикрепляет скриншот в отчет */
    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
    }

    /** прикрепляет исходный код страницы в отчет */
    @Attachment(value = "Page source", type = "text/html")
    public static byte[] attachPageSource() {
        return Driver.getInstance().getPageSource().getBytes(StandardCharsets.UTF_8);
    }
}
