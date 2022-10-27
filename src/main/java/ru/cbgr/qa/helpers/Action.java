package ru.cbgr.qa.helpers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import ru.cbgr.qa.base.Driver;

import static org.openqa.selenium.Keys.ENTER;

/** Класс для взаимодействия с курсором */
@Slf4j
public class Action {
    protected static Actions actions;

    /** Инициализация действий */
    public static void initActions() {
        actions = new Actions(Driver.getInstance());
    }

    public static class OneClick {
        public static void click(String locator) {
            Wait.visibleAndClickable(locator);
            Driver.getInstance().findElement(By.xpath(locator)).click();
        }

        public static void contextClick(String locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(By.xpath(locator))).contextClick().perform();
        }

        public static void moveToAndClick(String locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(By.xpath(locator))).click().perform();
        }

        public static void clickAndClear(String locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(By.xpath(locator))).click().perform();
            Driver.getInstance().findElement(By.xpath(locator)).clear();
        }

        public static void clickAndSendText(String locator, String text) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(By.xpath(locator))).click().sendKeys(text).perform();
        }

        public static void clickClearAndSendText(String locator, String text) {
            Wait.visibleAndClickable(locator);
            Driver.getInstance().findElement(By.xpath(locator)).click();
            Driver.getInstance().findElement(By.xpath(locator)).clear();
            Driver.getInstance().findElement(By.xpath(locator)).sendKeys(text);
        }
    }

    public static class DoubleClick {

        public static void click(String locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(By.xpath(locator))).doubleClick().perform();
        }

        public static void clickAndClear(String locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(By.xpath(locator))).doubleClick().perform();
            Driver.getInstance().findElement(By.xpath(locator)).clear();
        }

        public static void clickAndSendText(String locator, String text) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(By.xpath(locator))).doubleClick().sendKeys(text).perform();
        }

        public static void clickClearAndSendText(String locator, String text) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(By.xpath(locator))).doubleClick().perform();
            Driver.getInstance().findElement(By.xpath(locator)).clear();
            Driver.getInstance().findElement(By.xpath(locator)).sendKeys(text);
        }
    }


    public static class TextBox {

        public static void pressEnter(String locator) {
            Wait.visibleAndClickable(locator);
            Driver.getInstance().findElement(By.xpath(locator)).sendKeys(ENTER);
        }

        public static void clickAndSelectText(String locator) {
            Wait.visibleAndClickable(locator);
            Driver.getInstance().findElement(By.xpath(locator)).sendKeys(Keys.CONTROL + "a");
        }

        public static void selectText(String locator) {
            Driver.getInstance().findElement(By.xpath(locator)).sendKeys(Keys.CONTROL + "a");
        }

        public static void sendTextStringy (String locator, String text) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(By.xpath(locator))).sendKeys(text).perform();
        }

        public static void clearAndSendText(String locator, String text) {
            Wait.visibleAndClickable(locator);
            Driver.getInstance().findElement(By.xpath(locator)).clear();
            Driver.getInstance().findElement(By.xpath(locator)).sendKeys(text);
        }
    }

    public static class Move {

        /** Перемещение курсора на элемент */
        public static void moveTo(String locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(By.xpath(locator))).perform();
        }

        public static void dragAndDropElement(String firstLocator, String secondLocator) {
            Wait.visibleAndClickable(firstLocator);
            actions.clickAndHold(Driver.getInstance().findElement(By.xpath(firstLocator))).
                    moveToElement(Driver.getInstance().findElement(By.xpath(secondLocator))).build().perform();
        }

        public static void dragElement(String locator, int x, int y) {
            Wait.visibleAndClickable(locator);
            actions.clickAndHold(Driver.getInstance().findElement(By.xpath(locator))).moveByOffset(x, y).build().perform();
        }
    }

    public static class CheckBox {

        public static void setChecked(String locator, boolean value) {
            if (value != isChecked(locator)) {
                Driver.getInstance().findElement(By.xpath(locator)).click();
            }
        }

        /** Проверка, что флажок установлен */
        public static boolean isChecked(String locator) {
            Wait.visibleAndClickable(locator);
            return Driver.getInstance().findElement(By.xpath(locator)).isSelected();
        }
    }

    public static class SelectList {

        /** Выбрать значение списка по его значению */
        public static void selectOptionByValue(String locator, String option) {
            Wait.visibleAndClickable(locator);
            Select selectObject = new Select(Driver.getInstance().findElement(By.xpath(locator)));
            selectObject.selectByValue(option);
        }

        public static void selectOptionByVisibleText(String locator, String text) {
            Wait.visibleAndClickable(locator);
            Select selectObject = new Select(Driver.getInstance().findElement(By.xpath(locator)));
            selectObject.selectByVisibleText(text);
        }
    }
}
