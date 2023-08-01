package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLogInButton() {
        clickButton(loginLocator);
        return new LoginPage(driver);
    }

    public RegistrationPage clickCreateAccountButton() {
        clickButton(createAccountLocator);
        return new RegistrationPage(driver);
    }
}

