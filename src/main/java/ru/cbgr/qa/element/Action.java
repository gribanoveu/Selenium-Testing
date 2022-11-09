package ru.cbgr.qa.element;

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
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Action extends BaseElement {

    private Action(String byXpath) {
        super(byXpath);
    }

    public static Action byXpath(String xpath) {
        return new Action(xpath);
    }

    public Action click() {
        webElement.click();
        return this;
    }

    public Action contextClick() {
        actions.moveToElement(webElement).contextClick().perform();
        return this;
    }

    public Action clear() {
        webElement.clear();
        return this;
    }

    public Action enterText(String text) {
        webElement.sendKeys(text);
        return this;
    }

    public Action doubleClick() {
        actions.moveToElement(webElement).doubleClick().perform();
        return this;
    }

    public Action pressEnter() {
        webElement.sendKeys(Keys.ENTER);
        return this;
    }

    public Action selectText() {
        webElement.sendKeys(Keys.CONTROL + "a");
        return this;
    }

    public Action moveTo() {
        actions.moveToElement(webElement).perform();
        return this;
    }

    public Action dragAndDropTo(String locator) {
        actions.clickAndHold(webElement)
                .moveToElement(Driver.getInstance().findElement(By.xpath(locator)))
                .build().perform();
        return this;
    }

    public Action dragElement(int x, int y) {
        actions.clickAndHold(webElement).moveByOffset(x, y).build().perform();
        return this;
    }

    public Action dragElementVertical(int x) {
        actions.clickAndHold(webElement).moveByOffset(x, 0).build().perform();
        return this;
    }

    public Action dragElementHorizontal(int y) {
        actions.clickAndHold(webElement).moveByOffset(0, y).build().perform();
        return this;
    }

    public boolean isChecked() {
        return webElement.isSelected();
    }

    public void setChecked(boolean value) {
        if (value != isChecked()) {
            webElement.click();
        }
    }

    public void selectOptionByValue( String option) {
        Select selectObject = new Select(webElement);
        selectObject.selectByValue(option);
    }

    public void selectOptionByVisibleText( String text) {
        Select selectObject = new Select(webElement);
        selectObject.selectByVisibleText(text);
    }
}
