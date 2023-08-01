package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

import java.awt.*;
import java.time.Duration;

public class MainPage extends BasePage {

    @FindBy(xpath = "/html/body/app-root/div/app-job/div/mat-card/div/button/span[1]")
    @CacheLookup
    private WebElement commentsButton;

    @FindBy(css = "button[mat-icon-button][mattooltip='Profile']")
    @CacheLookup
    private WebElement dropdownButton;

    @FindBy(css = " button[routerlink='/profile")
    @CacheLookup
    private WebElement profileOption;

    @FindBy(css = "#mat-menu-panel-0 > div > button:nth-child(2)")
    @CacheLookup
    private WebElement logoutOption;

    @FindBy(xpath = "/html/body/app-root/div/app-index/div/mat-card[1]/mat-card-actions/button")
    @CacheLookup
    private WebElement viewJobInfoButton;

    @FindBy(xpath = "//*[@id=\"mat-input-2\"]")
    @CacheLookup
    private WebElement CommentArea;

    @FindBy(xpath = "/html/body/app-root/div/app-job/div/mat-card/mat-card-content/p")
    @CacheLookup
    private WebElement JobDescription;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickLeaveCommentButton() {
        commentsButton.click();
    }

    public void clickProfile() {
        dropdownButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(profileOption)).click();
    }

    public void clickLogout() {
        dropdownButton.click();
        logoutOption.click();
    }

    public void clickViewJobInfo() {

        viewJobInfoButton.click();
    }

    public void CommentArea(String Text) {

        CommentArea.click();
        CommentArea.clear();
        CommentArea.sendKeys(Text);
    }

    public void getJobDescription() {
        JobDescription.getText();
    }

    public String getEnteredComment() {
        WebElement commentTextArea = driver.findElement(By.cssSelector("textarea[formcontrolname='message']"));
        return commentTextArea.getAttribute("value");
    }
}


