package ru.cbgr.qa.service.allure;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.cbgr.qa.base.Driver;
import ru.cbgr.qa.enums.RemoteStand;
import ru.cbgr.qa.helpers.Element;

import java.nio.charset.StandardCharsets;

import static ru.cbgr.qa.base.BaseTest.USER;

/** Класс для вызова методов прикрепления обьектов в отчет allure */
@SuppressWarnings({"unused", "UnusedReturnValue"})
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

    public static void getAllureEnvironment() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", Driver.getInstance().getCapabilities().getBrowserName().toUpperCase())
                        .put("Version", Driver.getInstance().getCapabilities().getBrowserVersion())
                        .put("Stand", RemoteStand.REMOTE_URL.getUrl())
                        .put("Stand VERSION", Element.getText("//div[contains(@class,'version')]"))
                        .put("User", USER.toUpperCase())
                        .build());
    }
}
