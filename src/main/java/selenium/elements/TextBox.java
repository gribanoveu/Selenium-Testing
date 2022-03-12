package selenium.elements;

import org.openqa.selenium.By;
import selenium.base.BaseElement;
import selenium.helpers.WaitHelper;

public class TextBox extends BaseElement {

    /** Поле для ввода текста */
    public TextBox(By by) {
        super(by);
    }

    /** Нажатие на текстовое поле ввода */
    public void click() {
        WaitHelper.visibilityOfElementLocated(by);
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    /** Ввод значения в текстовое поле ввода */
    public void setValue(String value) {
        WaitHelper.visibilityOfElementLocated(by);
        webElement.sendKeys(value);
    }

    public String getTextValue() {
        WaitHelper.visibilityOfElementLocated(by);
        return webElement.getText();
    }
}
