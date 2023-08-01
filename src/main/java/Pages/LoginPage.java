package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(id = "mat-input-0")
    @CacheLookup
    protected WebElement usernameLocator;

    @FindBy(id = "mat-input-1")
    @CacheLookup
    protected WebElement passwordLocator;

    @FindBy(className = "mat-focus-indicator")
    @CacheLookup
    protected WebElement logInButtonLocator;

    @FindBy(tagName = "h2")
    @CacheLookup
    protected WebElement loginHeader;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return loginHeader.getText();
    }

    public LoginPage setUserName(String username) {
        usernameLocator.clear();
        usernameLocator.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordLocator.clear();
        passwordLocator.sendKeys(password);
        return this;
    }

    public WebElement clickLoginButton() {
        clickButton(logInButtonLocator);
        return logInButtonLocator;
    }

    public boolean isProfileButtonDisplayed() {
        try {WebElement profileButton = driver.findElement
                    (By.cssSelector("body > app-root > div > app-navigation > mat-toolbar > button"));
            return profileButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForProfileButtonToBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > app-navigation > mat-toolbar > button")));
        } catch (NoSuchElementException e) {
        }
    }
}

