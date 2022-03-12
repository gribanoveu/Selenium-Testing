package selenium.elements;

import org.openqa.selenium.By;
import selenium.base.BaseElement;
import selenium.helpers.WaitHelper;

public class RadioButton extends BaseElement {

    /** Радио кнопка */
    public RadioButton(By by) {
        super(by);
    }

    /** Установка переключателя */
    public void setSelected(boolean value) {
        if (value != isSelected()) {
            WaitHelper.clickabilityOfElement(webElement);
            webElement.click();
        }
    }

    /** Проверка, что переключатель установлен */
    public boolean isSelected() {
        WaitHelper.visibilityOfElementLocated(by);
        return webElement.isSelected();
    }
}
