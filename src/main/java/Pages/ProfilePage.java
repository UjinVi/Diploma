package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(), 'Profile')]")
    @CacheLookup
    private WebElement profileHeading;

    @FindBy(css = "button[mat-flat-button].mat-primary")
    @CacheLookup
    private WebElement editInfoButton;

    @FindBy(xpath = "/html/body/app-root/div/app-profile/div/div[2]/app-my-jobs/div/div/button")
    @CacheLookup
    private WebElement addJobButton;

    @FindBy(xpath = "//button[contains(text(), 'Close profile')]")
    @CacheLookup
    private WebElement closeProfileButton;

    @FindBy(xpath = "//*[@id=\"mat-input-2\"]")
    @CacheLookup
    private WebElement titleInput;

    @FindBy(xpath = "//*[@id=\"mat-input-3\"]")
    @CacheLookup
    private WebElement descriptionInput;

    @FindBy(xpath = "//*[@id=\"mat-input-4\"]")
    @CacheLookup
    private WebElement priceInput;

    @FindBy(xpath = "/html/body/app-root/div/app-profile/div/div[2]/app-add-job/div/form/div/button")
    @CacheLookup
    private WebElement createJobButton;

    @FindBy(xpath = "//h2[contains(text(), 'Edit User Profile')]")
    @CacheLookup
    private WebElement editUserProfileHeading;

    @FindBy(xpath = "//*[@id=\"mat-input-2\"]")
    @CacheLookup
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"mat-input-3\"]")
    @CacheLookup
    private WebElement lastnameInput;

    @FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-edit-profile/div/form/div/button[2]/span[1]")
    @CacheLookup
    private WebElement updateButton;
    @FindBy(xpath = "/html/body/app-root/div/app-profile/div/div[2]/app-my-jobs/div/mat-card[1]/mat-card-actions/button")
    @CacheLookup
    private WebElement removeJob;


    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void clickEditInfoButton() {

        editInfoButton.click();
    }

    public WebElement clickAddJobButton() {

        addJobButton.click();
        return addJobButton;
    }



    public void enterTitle(String title) {

        titleInput.sendKeys(title);
    }

    public void enterDescription(String description) {

        descriptionInput.sendKeys(description);
    }

    public void enterPrice(Integer price) {

        priceInput.sendKeys("1000");
    }

    public void clickCreateJobButton() {

        createJobButton.click();
    }


    public void enterName(String name) {

        nameInput.sendKeys(name);
    }

    public void enterLastname(String lastname) {

        lastnameInput.sendKeys(lastname);
    }

    public void clickUpdateButton() {

        updateButton.click();
    }

    public String getName() {

        return nameInput.getAttribute("value");
    }

    public String getLastname() {

        return lastnameInput.getAttribute("value");
    }
    public void clearNameAndLastnameInputs() {

        nameInput.clear();
        lastnameInput.clear();
    }
    public WebElement  clickRemoveButton(){
      removeJob.click();
      return removeJob;
    }


    public String checkUserName() {
        WebElement h2Element = driver.findElement(By.cssSelector("body > app-root > div > app-profile > div > div.row > div:nth-child(2) > h2"));
        String username = h2Element.getText();
        return username;
    }
    public String CheckAmountOfJobs(){
        WebElement h2Element2 =driver.findElement(By.cssSelector("body > app-root > div > app-profile > div > div.row > app-my-jobs > div > h2"));
        String AmountOfJobs = h2Element2.getText();
        return AmountOfJobs;
    }
    public String CheckAmountOfComments(){
        WebElement Element =driver.findElement
                (By.xpath("/html/body/app-root/div/app-profile/div/div[2]/app-my-jobs/div/mat-card/mat-card-subtitle/mat-card-subtitle[1]"));
        String amountOfComments = Element.getText();
        return amountOfComments;
    }

    public String getJobTitleOnProfile() {
        WebElement jobTitleElement = driver.findElement
                (By.cssSelector("body > app-root > div > app-profile > div > div.row > app-my-jobs > div > mat-card > mat-card-header > div > mat-card-title"));
        return jobTitleElement.getText();
    }

}




