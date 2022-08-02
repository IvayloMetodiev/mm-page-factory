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

    public LandingPage(WebDriver driver) {
        super(driver);

//        driver.get("");

        PageFactory.initElements(driver, this);
    }

//    public LandingPage(WebDriver driver) {
//        this.driver = driver;
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        actions = new Actions(driver);




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


}
