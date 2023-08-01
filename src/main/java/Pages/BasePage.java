package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    @FindBy(css = "button[mat-icon-button][mattooltip='Profile']")
    @CacheLookup
    protected WebElement profileOptionLocator;

    @FindBy(xpath = "//a[@href='/login']")
    @CacheLookup
    protected WebElement loginLocator;

    @FindBy(xpath = "//a[@href='/register']")
    @CacheLookup
    protected WebElement createAccountLocator;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); // Инициализация аннотаций здесь
    }

    protected void clickButton(WebElement button) {
        waitForVisibility(button);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    protected void waitForVisibility(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}

