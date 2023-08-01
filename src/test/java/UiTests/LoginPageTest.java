package UiTests;

import Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginPageTest extends BaseTest {

    @Test (groups ="login")
    public void loginTest() {
        String baseUrl = "https://freelance.lsrv.in.ua";
        String username = "testuser";
        String password = "test1234";

        driver.get(baseUrl + "/login");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUserName(username)
                .setPassword(password)
                .clickLoginButton();

        loginPage.waitForProfileButtonToBeDisplayed();

        boolean isProfileButtonDisplayed = loginPage.isProfileButtonDisplayed();
        Assert.assertTrue(isProfileButtonDisplayed, "Кнопка \"Profile\" не найдена на странице после входа.");
    }
}


