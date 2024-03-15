package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//https://www.bing.com/
public class SearchPage {
    @FindBy(css = "#sb_form_q")
    private WebElement searchField;
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void sendKeys(String text)  {
        searchField.sendKeys(text);
        searchField.submit();
        System.out.println("Введен такой текст: " + text);
    }
}