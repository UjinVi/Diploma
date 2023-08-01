package UiTests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import Listeners.ListenerReports;

@Listeners({ListenerReports.class})
public class BaseTest {
    protected WebDriver driver;
    protected String BASE_URL = "https://freelance.lsrv.in.ua";
    protected String USERNAME = "testuser";
    protected String PASSWORD = "test1234";
    protected String NEW_NAME = "NewName";
    protected String NEW_LASTNAME = "NewLastname";
    protected String COMMENT = "This is true comment";
    protected String NEW_TITLE = "New Job for Junior AQA";
    protected String Description = "This is very good description";
    protected Integer PRICE = 2000;

    @BeforeClass
    @Parameters("browser")
    public void setUpBrowser(@Optional("chrome") String browser) {
        switch (browser) {
            case "chrome" -> WebDriverManager.chromedriver().setup();
            case "firefox" -> WebDriverManager.firefoxdriver().setup();
            default -> throw new IllegalArgumentException("Invalid browser value: " + browser);
        }
    }

    @BeforeMethod
    @Parameters("browser")
    public void creatingObjectOfBrowser(@Optional("chrome") String browser) {
        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            default -> throw new IllegalArgumentException("Invalid browser value: " + browser);
        }
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void clearUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}

