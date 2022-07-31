package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage extends BasePage {

    @FindBy(xpath = "//div[@class='image-container']")
    WebElement profileAvatar;

    @FindBy(xpath = "//label[@class='btn-public btn btn-primary active']")
    WebElement postTypeNavigation;

    @FindBy(xpath = "//div[@class='row no-gutters']")
    WebElement galleryPosts;


    public ProfilePage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);

    }

    //Verification Methods
    public boolean isAvatarDisplayed() {
        return profileAvatar.isDisplayed();
    }

    public boolean isPostTypeNavigationDisplayed(){
        return postTypeNavigation.isDisplayed();
    }

    public boolean isGalleryDisplayed(){
        return galleryPosts.isDisplayed();
    }

    public boolean areAllElementsDisplayed(){
        return isAvatarDisplayed() &&
                isGalleryDisplayed() &&
                isPostTypeNavigationDisplayed();
    }


    //Init Methods


}
