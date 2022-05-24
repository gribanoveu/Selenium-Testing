package selenium.helpers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import selenium.base.Driver;

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

        public static void click(By locator) {
            Wait.visibleAndClickable(locator);
            Driver.getInstance().findElement(locator).click();
        }

        public static void contextClick(By locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(locator)).contextClick().perform();
        }

        public static void moveToAndClick(By locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(locator)).click().perform();
        }

        public static void clickAndClear(By locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(locator)).click().perform();
            Driver.getInstance().findElement(locator).clear();
        }

        public static void clickAndSendText(By locator, String text) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(locator)).click().sendKeys(text).perform();
        }

        public static void clickClearAndSendText(By locator, String text) {
            Wait.visibleAndClickable(locator);
            Driver.getInstance().findElement(locator).click();
            Driver.getInstance().findElement(locator).clear();
            Driver.getInstance().findElement(locator).sendKeys(text);
        }
    }

    public static class DoubleClick {

        public static void click(By locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(locator)).doubleClick().perform();
        }

        public static void clickAndClear(By locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(locator)).doubleClick().perform();
            Driver.getInstance().findElement(locator).clear();
        }

        public static void clickAndSendText(By locator, String text) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(locator)).doubleClick().sendKeys(text).perform();
        }

        public static void clickClearAndSendText(By locator, String text) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(locator)).doubleClick().perform();
            Driver.getInstance().findElement(locator).clear();
            Driver.getInstance().findElement(locator).sendKeys(text);
        }
    }


    public static class TextBox {

        public static void pressEnter(By locator) {
            Wait.visibleAndClickable(locator);
            Driver.getInstance().findElement(locator).sendKeys(ENTER);
        }

        public static void clickAndSelectText(By locator) {
            Wait.visibleAndClickable(locator);
            Driver.getInstance().findElement(locator).sendKeys(Keys.CONTROL + "a");
        }

        public static void selectText(By locator) {
            Driver.getInstance().findElement(locator).sendKeys(Keys.CONTROL + "a");
        }

        public static void sendText(By locator, String text) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(locator)).sendKeys(text).perform();
        }

        public static void clearAndSendText(By locator, String text) {
            Wait.visibleAndClickable(locator);
            Driver.getInstance().findElement(locator).clear();
            Driver.getInstance().findElement(locator).sendKeys(text);
        }
    }

    public static class Move {

        /** Перемещение курсора на элемент */
        public static void moveTo(By locator) {
            Wait.visibleAndClickable(locator);
            actions.moveToElement(Driver.getInstance().findElement(locator)).perform();
        }

        public static void dragAndDropElement(By firstLocator, By secondLocator) {
            Wait.visibleAndClickable(firstLocator);
            actions.clickAndHold(Driver.getInstance().findElement(firstLocator)).
                    moveToElement(Driver.getInstance().findElement(secondLocator)).build().perform();
        }

        public static void dragElement(By locator, int x, int y) {
            Wait.visibleAndClickable(locator);
            actions.clickAndHold(Driver.getInstance().findElement(locator)).moveByOffset(x, y).build().perform();
        }
    }

    public static class CheckBox {

        public static void setChecked(By locator, boolean value) {
            if (value != isChecked(locator)) {
                Driver.getInstance().findElement(locator).click();
            }
        }

        /** Проверка, что флажок установлен */
        public static boolean isChecked(By locator) {
            Wait.visibleAndClickable(locator);
            return Driver.getInstance().findElement(locator).isSelected();
        }
    }

    public static class SelectList {

        /** Выбрать значение списка по его значению */
        public static void selectOptionByValue(By locator, String option) {
            Wait.visibleAndClickable(locator);
            Select selectObject = new Select(Driver.getInstance().findElement(locator));
            selectObject.selectByValue(option);
        }

        public static void selectOptionByVisibleText(By locator, String text) {
            Wait.visibleAndClickable(locator);
            Select selectObject = new Select(Driver.getInstance().findElement(locator));
            selectObject.selectByVisibleText(text);
        }
    }
}
