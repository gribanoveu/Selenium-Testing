package ru.cbgr.qa.helpers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import ru.cbgr.qa.base.BaseElement;
import ru.cbgr.qa.base.Driver;

/**
 * @author Evgeny Gribanov
 * @version 08.11.2022
 * @link egribanov@cbgr.ru
 */
@Slf4j
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Action extends BaseElement {

    private Action(String byXpath) {
        super(byXpath);
    }

    public static Action byXpath(String xpath) {
        log.info("WebElement: " + xpath);
        return new Action(xpath);
    }

    public Action click() {
        log.info("Клик по элементу");
        actions.moveToElement(webElement).click().perform();
        return this;
    }

    public Action contextClick() {
        log.info("Навести на элемент");
        actions.moveToElement(webElement).contextClick().perform();
        return this;
    }

    public Action clear() {
        log.info("Очистить поле");
        webElement.clear();
        return this;
    }

    public Action enterText(String text) {
        log.info("Ввести текст: " + text);
        webElement.sendKeys(text);
        return this;
    }

    public Action doubleClick() {
        log.info("Двойной клик по элементу");
        actions.moveToElement(webElement).doubleClick().perform();
        return this;
    }

    public Action pressEnter() {
        log.info("Нажать ENTER");
        webElement.sendKeys(Keys.ENTER);
        return this;
    }

    public Action selectText() {
        log.info("Выделить текст");
        webElement.sendKeys(Keys.CONTROL + "a");
        return this;
    }

    public Action moveTo() {
        log.info("Навести на элемент");
        actions.moveToElement(webElement).perform();
        return this;
    }

    public Action dragAndDropTo(String locator) {
        log.info("Перетянуть элемент на: " + locator);
        actions.clickAndHold(webElement)
                .moveToElement(Driver.getInstance().findElement(By.xpath(locator)))
                .build().perform();
        return this;
    }

    public Action dragElement(int x, int y) {
        log.info("Переместить элемент на x: " + x + " y: " + y);
        actions.clickAndHold(webElement).moveByOffset(x, y).build().perform();
        return this;
    }

    public Action dragElementVertical(int x) {
        log.info("Переместить элемент вверх на: " + x);
        actions.clickAndHold(webElement).moveByOffset(x, 0).build().perform();
        return this;
    }

    public Action dragElementHorizontal(int y) {
        log.info("Переместить элемент вниз на: " + y);
        actions.clickAndHold(webElement).moveByOffset(0, y).build().perform();
        return this;
    }

    public boolean isChecked() {
        log.info("Чекбокс выбран [OK]");
        return webElement.isSelected();
    }

    public void setChecked(boolean value) {
        log.info("Установить чекбокс");
        if (value != isChecked()) {
            webElement.click();
        }
    }

    public void selectOptionByValue(String option) {
        log.info("Выбрать опцию по значению: " + option);
        var selectObject = new Select(webElement);
        selectObject.selectByValue(option);
    }

    public void selectOptionByVisibleText(String text) {
        log.info("Выбрать опцию по видимому тексту: " + text);
        var selectObject = new Select(webElement);
        selectObject.selectByVisibleText(text);
    }
}
