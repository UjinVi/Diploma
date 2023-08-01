package UiTests;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.ProfilePage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckProfileContentTest  extends BaseTest {


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
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String nameOnProfile = profilePage.checkUserName();

        Assert.assertEquals(nameOnProfile, USERNAME, "Имя пользователя не соответствует ожидаемому.");


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

        String amountOfJobs = profilePage.CheckAmountOfJobs();
        String expectedText = "You have 1 jobs";
        Assert.assertEquals(amountOfJobs, expectedText, "Количество объявлений не отображается");

        String amountOfComments = profilePage.CheckAmountOfComments();
        String expectedAmount = "Comments: 0";
        Assert.assertEquals(amountOfComments, expectedAmount, "Количество объявлений не отображается");

        profilePage.clickRemoveButton();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}