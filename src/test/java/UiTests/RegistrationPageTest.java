package UiTests;

import Pages.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {

    @Test(groups = "create_account")
    public void successfulRegistrationTest() {
        String baseUrl = "https://freelance.lsrv.in.ua";
        String username = "testuser123";
        String name = "test1234";
        String lastName = "User";
        String password = "random12345";

        driver.get(baseUrl + "/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.setUserName(username)
                .setName(name)
                .setLastname(lastName)
                .setPasswordAndConfirm(password)
                .clickOnRegisterButton();

    }
}

