package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//input[@formcontrolname='username']")
    private WebElement usernameLocator;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement nameLocator;

    @FindBy(xpath = "//input[@formcontrolname='lastname']")
    private WebElement lastnameLocator;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordLocator;

    @FindBy(xpath = "//input[@formcontrolname='confirmPassword']")
    private WebElement confirmPassLocator;

    @FindBy(xpath = "//span[@class='mat-button-wrapper']")
    private WebElement registerButton;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signInButton;

    @FindBy(tagName = "h2")
    private WebElement registrationHeader;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage setUserName(String username) {
        usernameLocator.clear();
        usernameLocator.sendKeys(username);
        return this;
    }

    public RegistrationPage setName(String name) {
        nameLocator.clear();
        nameLocator.sendKeys(name);
        return this;
    }

    public RegistrationPage setLastname(String lastname) {
        lastnameLocator.clear();
        lastnameLocator.sendKeys(lastname);
        return this;
    }

    public RegistrationPage setPasswordAndConfirm(String password) {
        passwordLocator.clear();
        passwordLocator.sendKeys(password);
        confirmPassLocator.clear();
        confirmPassLocator.sendKeys(password);
        return this;
    }

    public RegistrationPage clickOnRegisterButton() {
        clickButton(registerButton);
        return this;
    }

    public LoginPage clickOnSignInButton() {
        clickButton(signInButton);
        return new LoginPage(driver);
    }

    public String getTitle() {
        return registrationHeader.getText();
    }
}

