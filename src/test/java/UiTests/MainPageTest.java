package UiTests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test(groups = "login")
    public void LoginPageTest() {
        driver.get("https://freelance.lsrv.in.ua/home");
        HomePage mainPage = new HomePage(driver);
        LoginPage loginPage = mainPage.clickLogInButton();

        Assert.assertEquals(loginPage.getTitle(), "Login", "Заголовок страницы не соответствует ожидаемому при переходе на страницу входа.");
    }

    @Test(groups = "create_account")
    public void RegistrationPageTest() {
        driver.get("https://freelance.lsrv.in.ua/home");
        HomePage mainPage = new HomePage(driver);
        RegistrationPage registrationPage = mainPage.clickCreateAccountButton();

        Assert.assertEquals(registrationPage.getTitle(), "Register", "Заголовок страницы не соответствует ожидаемому при переходе на страницу регистрации.");
    }
}

