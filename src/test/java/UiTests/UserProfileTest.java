package UiTests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTest extends BaseTest {

    @Test(priority = 1)
    public void userProfile() {
        driver.get(BASE_URL + "/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(USERNAME)
                .setPassword(PASSWORD);
        loginPage.clickLoginButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isProfileButtonDisplayed = loginPage.isProfileButtonDisplayed();
        Assert.assertTrue(isProfileButtonDisplayed, "Кнопка \"Profile\" не найдена на странице после входа.");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfile();
        ProfilePage profilePage = new ProfilePage(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        profilePage.clickEditInfoButton();
        profilePage.clearNameAndLastnameInputs();
        profilePage.enterName(NEW_NAME);
        profilePage.enterLastname(NEW_LASTNAME);
        profilePage.clickUpdateButton();

        String updatedName = profilePage.getName();
        String updatedLastname = profilePage.getLastname();

        Assert.assertEquals(updatedName, NEW_NAME, "Имя не было изменено.");
        Assert.assertEquals(updatedLastname, NEW_LASTNAME, "Фамилия не была изменена.");

        System.out.println(profilePage.getName());
        System.out.println(profilePage.getLastname());
    }
}

