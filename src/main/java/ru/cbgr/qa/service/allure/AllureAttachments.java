package ru.cbgr.qa.service.allure;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.cbgr.qa.base.Driver;
import ru.cbgr.qa.helpers.MethodT;
import ru.cbgr.qa.enums.RemoteStand;


import java.nio.charset.StandardCharsets;

import static ru.cbgr.qa.base.BaseTest.USER;
import static ru.cbgr.qa.service.allure.AllureEnvironmentWriter.allureEnvironmentWriter;

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

    public static void getAllureEnvironment() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", Driver.getInstance().getCapabilities().getBrowserName().toUpperCase())
                        .put("Version", Driver.getInstance().getCapabilities().getBrowserVersion())
                        .put("Stand", RemoteStand.REMOTE_URL.getUrl())
                        .put("Stand VERSION", MethodT.getElementTextValue("//div[contains(@class,'version')]"))
                        .put("User", USER.toUpperCase())
                        .build());
    }
}
