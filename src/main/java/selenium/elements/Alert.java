package selenium.elements;

import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import selenium.base.BaseElement;
import selenium.base.Driver;
import selenium.helpers.ActionHelper;
import selenium.helpers.WaitHelper;

/**
 * author : egribanov
 * created : 16.03.2022, 21:21
 **/
@Slf4j
public class Alert extends BaseElement {

    /** Всплывающее отовещение браузера */
    public Alert(By by) {
        super(by);
    }

    /** Кликнуть на элемент */
    public Alert click() {
        WaitHelper.waitWhenAlertIsPresents();
        ActionHelper.moveToElement(webElement);
        webElement.click();
        return this;
    }

    /** Подтвердить сообщение во всплывающем оповещении */
    public Alert confirmAlert() {
        WaitHelper.waitWhenAlertIsPresents();
        Driver.getInstance().switchTo().alert().accept();
        log.info("Всплывающее оповещение подтверждено");
        return this;
    }

    /** Отклонить сообщение во всплывающем оповещении */
    public Alert dismissAlert() {
        webElement.click();
        WaitHelper.waitWhenAlertIsPresents();
        Driver.getInstance().switchTo().alert().dismiss();
        log.info("Всплывающее оповещение отклонено");
        return this;
    }

    /** Передать текст во всплывающее оповещение */
    public Alert sendTextToAlert(String text) {
        webElement.click();
        WaitHelper.waitWhenAlertIsPresents();
        Driver.getInstance().switchTo().alert().sendKeys(text);
        log.info("Во всплывающее оповещение отправлен текст: " + text);
        return this;
    }

    /** Получить сообщение всплывающего оповещения */
    public String getAlertMessageText() {
        webElement.click();
        WaitHelper.waitWhenAlertIsPresents();
        return Driver.getInstance().switchTo().alert().getText();
    }
}
