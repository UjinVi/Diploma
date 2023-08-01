package UiTests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnouncementEditTest extends BaseTest {

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
        mainPage.clickViewJobInfo();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.getJobDescription();
        mainPage.CommentArea(COMMENT);
        mainPage.clickLeaveCommentButton();

        String commentText = mainPage.getEnteredComment();
        Assert.assertEquals(commentText, COMMENT, "Введенный комментарий не соответствует ожидаемому значению.");

        mainPage.clickLeaveCommentButton();

        System.out.println(commentText);

    }
}
