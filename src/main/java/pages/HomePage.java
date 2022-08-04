package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    @FindBy(xpath = "//i[@class='fas fa-sign-out-alt fa-lg']")
    WebElement logoutBtn;

    @FindBy(xpath = "//input[@id='search-bar']")
    WebElement searchBar;

    @FindBy(xpath = "//i[@class='fas fa-search']")
    WebElement searchBtn;

    @FindBy(css = "#nav-link-new-post")
    WebElement newPostBtn;

    @FindBy(css = "#nav-link-profile")
    WebElement profileBtn;

    @FindBy(css = "#nav-link-home")
    WebElement homeBtn;

    @FindBy(css = "#homeIcon")
    WebElement logoBtn;

    @FindBy(css = ".row.post-list-container.ng-star-inserted")
    WebElement allPostListContainer;


    public HomePage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    //Verification methods

    public boolean isLogoutBtnDisplayed() {
        return logoutBtn.isDisplayed();
    }

    public boolean isSearchBarDisplayed() {
        return searchBar.isDisplayed();
    }

    public boolean isSearchBtnDisplayed() {
        return searchBtn.isDisplayed();
    }

    public boolean isNewPostBtnDisplayed() {
        return newPostBtn.isDisplayed();
    }

    public boolean isProfileBtnDisplayed() {
        return profileBtn.isDisplayed();
    }

    public boolean isHomeBtnDisplayed() {
        return homeBtn.isDisplayed();
    }

    public boolean isLogoDisplayed() {
        return logoBtn.isDisplayed();
    }

    public boolean isContentContainerDisplayed() {
        return allPostListContainer.isDisplayed();
    }

    public boolean areAllElementsDisplayed() {
        return isLogoutBtnDisplayed() &&
                isSearchBarDisplayed() &&
                isSearchBtnDisplayed() &&
                isProfileBtnDisplayed() &&
                isNewPostBtnDisplayed() &&
                isHomeBtnDisplayed() &&
                isLogoDisplayed() &&
                isContentContainerDisplayed();
    }

    //Init web elements methods


    public void openSuggestedSearch() {
    searchBar.click();
    searchBar.sendKeys("ivo");
    searchBtn.click();

    By suggestedSearchMenuBy = By.xpath("//div[@class='dropdown-container']");
    WebElement suggestedSearchMenu = driver.findElement(suggestedSearchMenuBy);

    wait.until(ExpectedConditions.visibilityOf(suggestedSearchMenu));
    }

    public void clickNewPostBtn(){
        click(newPostBtn);
    }

    public void clickLogoutBtn(){
        click(logoutBtn);
    }


}
