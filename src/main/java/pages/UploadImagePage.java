package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class UploadImagePage extends BasePage {

    @FindBy (xpath = "//div[@class='uploadfilecontainer']")
    WebElement dragAndDropContainer;

    @FindBy (css = "#choose-file")
    WebElement browseBtn;

    @FindBy (xpath = "//label[@class='post-status-label custom-control-label active']")
    WebElement publicPrivetToggle;

    @FindBy (xpath = "//input[@name='caption']")
    WebElement captionInputField;

    @FindBy (xpath = "//input[@class='file ng-untouched ng-pristine ng-invalid']")
    WebElement filePathField;

    @FindBy (css = "#create-post")
    WebElement submitBtn;

//    @FindBy (xpath = "//div[@class='file-preview']")
//    WebElement uploadedImagePreview;



    public UploadImagePage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);

    }

    //Verification Methods
    public boolean isDragAndDropContainerDisplayed(){
        return dragAndDropContainer.isDisplayed();
    }

    public boolean isBrowseBtnDisplayed(){
        return browseBtn.isDisplayed();
    }

    public boolean isPublicPrivetToggleDisplayed(){
        return publicPrivetToggle.isDisplayed();
    }

    public boolean isCaptionFiledDisplayed(){
        click(captionInputField);
        return captionInputField.isDisplayed();
    }

    public boolean isSubmitBtnDisplayed(){
        return submitBtn.isDisplayed();
    }

    public boolean areAllElementsVisible(){
        return isSubmitBtnDisplayed() &&
                isCaptionFiledDisplayed() &&
                isPublicPrivetToggleDisplayed() &&
                isBrowseBtnDisplayed() &&
                isDragAndDropContainerDisplayed();
    }

    //Init Methods
    public void createPublicPost(String imagePath, String caption){
        filePathField.sendKeys(imagePath);
        click(captionInputField);
        captionInputField.sendKeys(caption);
        click(submitBtn);
    }

    public void createPrivatePost(String imagePath){
        filePathField.sendKeys(imagePath);
        click(publicPrivetToggle);
        click(submitBtn);
    }






}
