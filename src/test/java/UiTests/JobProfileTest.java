package UiTests;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobProfileTest extends BaseTest {
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

        profilePage.clickAddJobButton();
        profilePage.enterTitle(NEW_TITLE);
        profilePage.enterDescription(Description);
        profilePage.enterPrice(PRICE);
        profilePage.clickCreateJobButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String jobTitleOnProfile = profilePage.getJobTitleOnProfile();
        Assert.assertEquals(jobTitleOnProfile, NEW_TITLE, "Название новой джобы не совпадает с ожидаемым.");

    }
}
