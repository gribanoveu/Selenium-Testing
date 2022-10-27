package ru.cbgr.qa.helpers;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import ru.cbgr.qa.base.Driver;

import java.io.File;
import java.io.IOException;

@Slf4j
public class Screenshot {

    /** Сохранение скриншота страницы в папку target (при запуске через mvn clean она очищается).
     * Сохраняется в формате "Заголовок страницы" + "ваше имя" + "id сессии" */
    public static void getPageScreenshot(String name) {
        File scrFile = ((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile,
                    new File( "target" + File.separator + "screenshot" + File.separator + "page-screenshot" + "./"+ Driver.getInstance().getTitle() + "_" + name + "_" + Driver.getInstance().getSessionId() + "_" + ".png"));
            log.info("Скриншот страницы сохранен в корень проекта по пути ./target/Screenshot c именем: " + name);
        } catch (IOException e) {
            log.warn("Не удалось сохранить скриншот страницы!");
        }
    }

    public static void getElementScreenshot(WebElement webElement, String name) {
        File scrFile = webElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile,
                    new File( "target" + File.separator + "screenshot" + File.separator + "element-screenshot" + "./"+ Driver.getInstance().getTitle() + "_" + name + "_" + Driver.getInstance().getSessionId() + "_" + ".png"));
            log.info("Скриншот элемента сохранен в корень проекта по пути ./target/Screenshot c именем: " + name);
        } catch (IOException e) {
            log.warn("Не удалось сохранить скриншот элемента!");
        }
    }
}
