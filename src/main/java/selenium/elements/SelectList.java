package selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import selenium.base.BaseElement;
import selenium.base.Driver;
import selenium.helpers.WaitHelper;

import java.util.List;

public class SelectList extends BaseElement {
    /** Элемент списка, представляет собой веб-элемент вида select -> option:
     * <select>
     *     <option value=value1>Option1</option>
     *     <option value=value2 selected>Option2</option>
     * </select> */
    public SelectList(By by) {
        super(by);
    }

    /** Выбрать значение списка по его значению */
    public void selectOptionByValue(String option) {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        selectObject.selectByValue(option);
    }

    /** Выбрать значение списка по его тексту */
    public void selectOptionByVisibleText(String text) {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        selectObject.selectByVisibleText(text);
    }

    /** Выбрать значение списка по его индексу */
    public void selectOptionByIndex(int index) {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        selectObject.selectByIndex(index);
    }

    /** Получить все выбранные элементы списка в виде списка вебэлементов */
    public List<WebElement> getAllSelectedOptions() {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        return selectObject.getAllSelectedOptions();
    }

    /** Получить все доступные опции */
    public List<WebElement> getAllOptions() {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        return selectObject.getOptions();
    }

    /** Получить первую выбранную опцию списка */
    public WebElement getFirstSelectedOptions() {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        return selectObject.getFirstSelectedOption();
    }

    /** Отменить выбор опции по значению */
    public void deselectOptionByValue(String option) {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        selectObject.deselectByValue(option);
    }

    /** Отменить выбор опции по видимому тексту */
    public void deselectOptionByVisibleText(String text) {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        selectObject.deselectByVisibleText(text);
    }

    /** Отключить выбор опции по индексу */
    public void deselectOptionByIndex(int index) {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        selectObject.deselectByIndex(index);
    }

    /** Отключить все опции */
    public void deselectAllOptions() {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        selectObject.deselectAll();
    }

    /** Возвращает булево значение, позволяет ли список выбрать несколько элементов */
    public boolean isListMultiSelection() {
        WaitHelper.clickabilityOfElement(webElement);
        Select selectObject = new Select(webElement);
        return selectObject.isMultiple();
    }
}
