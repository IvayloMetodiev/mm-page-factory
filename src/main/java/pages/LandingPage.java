package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage extends BasePage {

//    public WebDriver driver;
//    public WebDriverWait wait;
//    public Actions actions;

    @FindBy(xpath = "//a[@id='nav-link-login']")
    WebElement loginBtn;

    @FindBy(css = "#nav-link-home")
    WebElement homeBtn;

    public LandingPage(WebDriver driver) {
        super(driver);

//        driver.get("");

        PageFactory.initElements(driver, this);
    }


    //Init web elements methods
    public void loginBtnClick() {
        loginBtn.click();
    }

    public void openLandingPage(){
        driver.get("http://training.skillo-bg.com/");
    }

    //Verification Methods
    public boolean isLoginBtnDisplayed() {
        return loginBtn.isDisplayed();
    }

    public boolean isHomeBtnDisplayed(){
        return homeBtn.isDisplayed();
    }

    public boolean areAllElementsDisplayed(){
        return isLoginBtnDisplayed() &&
                isHomeBtnDisplayed();
    }


}
