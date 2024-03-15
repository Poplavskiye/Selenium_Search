package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//https://www.bing.com/
public class ResultPage {
    @FindBy(css = "#sb_form_q")
    private WebElement searchField;
    @FindBy(css = "h2 > a[href]")
    private List <WebElement> results;

    public void clickElement(int num)  {
        results.get(num).click();
        System.out.println("Выбран результат под номером " +num);
    }
    public void sendKeys(String text)  {
        searchField.sendKeys(text);
        searchField.submit();
        System.out.println("Введен такой текст: " + text);

    }    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}