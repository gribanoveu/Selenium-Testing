package pages;

import org.openqa.selenium.By;
import selenium.base.BasePage;
import selenium.elements.Button;
import selenium.elements.TextBox;

/**
 * author : egribanov
 * created : 23.02.2022, 19:02
 **/
public class GoogleMainPage extends BasePage {

    private static final String SEARCH_BOX = "//input[@name='q']";
    public static final String SEARCH_BUTTON = "//input[@name='btnK']";

    public GoogleMainPage enterTextInSearchBox(String text) {
        TextBox searchBox = new TextBox(By.xpath(SEARCH_BOX));
        searchBox.setValue(text);
        return this;
    }

    public GoogleMainPage pressSearchButton() {
        Button searchButton = new Button(By.xpath(SEARCH_BUTTON));
        searchButton.click();
        return this;
    }
}
