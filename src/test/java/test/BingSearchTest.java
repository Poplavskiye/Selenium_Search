package test;

import pages.ResultPage;
import pages.SearchPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;


public class BingSearchTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchResultsByListTest() {
        ResultPage resultPage = new ResultPage(driver);
        String input = "Selenium";

        resultPage.sendKeys(input);
        resultPage.clickElement( 0);

        WebElement searchPagefield = driver.findElement(By.cssSelector("#sb_form_q"));
        assertEquals(input, searchPagefield.getAttribute("value"));
    }
    @Test
            public void searchFieldTest() {
        ResultPage resultPage = new ResultPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        String input = "Selenium";
        searchPage.sendKeys(input);
        assertEquals("https://www.selenium.dev/",driver.getCurrentUrl(),"Wrong website");
    }
}

