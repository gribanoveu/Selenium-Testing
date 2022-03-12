package selenium.elements;

import org.openqa.selenium.By;
import selenium.base.BaseElement;
import selenium.helpers.WaitHelper;

public class Hamburger extends BaseElement {

    /** Меню с тремя полосками */
    public Hamburger(By by) {
        super(by);
    }

    /** Раскрытие гармошки */
    public void show() {
        WaitHelper.visibilityOfElementLocated(by);
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
