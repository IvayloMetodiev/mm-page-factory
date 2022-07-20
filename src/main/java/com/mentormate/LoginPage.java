package com.mentormate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    @FindBy(xpath = "//p[@class='h4 mb-4']")
    WebElement signInText;

    @FindBy(xpath = "//input[@class='form-control mb-4 ng-pristine ng-invalid ng-touched']")
    WebElement usernameOrEmailInput;

    @FindBy(xpath = "//input[@id='defaultLoginFormPassword']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@class='remember-me-button ng-pristine ng-valid ng-touched']")
    WebElement rememberMeCheckBox;

    @FindBy(xpath = "//button[@id='sign-in-button']")
    WebElement signInBtn;

    @FindBy(xpath = "//a[@href='/users/register']")
    WebElement registerBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);

        driver.get("http://training.skillo-bg.com/users/login");

        PageFactory.initElements(driver, this);
    }

    //Verification methods

    public boolean isSignUpTextDisplayed(){
        return signInText.isDisplayed();
    }

    public boolean isUsernameOrEmailInputDisplayed(){
        return usernameOrEmailInput.isDisplayed();
    }

    public boolean isPasswordInputDisplayed(){
        return passwordInput.isDisplayed();
    }

    public boolean isRememberMeCheckboxDisplayed(){
        return rememberMeCheckBox.isDisplayed();
    }

    public boolean isSignInBtnDisplayed(){
        return signInBtn.isDisplayed();
    }

    public boolean isRegisterBtnDisplayed(){
        return registerBtn.isDisplayed();
    }

    public boolean areAllLoginPageElementsDisplayed(){
    return isSignUpTextDisplayed() &&
            isUsernameOrEmailInputDisplayed() &&
            isPasswordInputDisplayed() &&
            isRememberMeCheckboxDisplayed() &&
            isSignInBtnDisplayed() &&
            isRegisterBtnDisplayed();
    }

    //Init web elements methods

    public void fillUsername(String username){
        usernameOrEmailInput.click();
        usernameOrEmailInput.clear();
        usernameOrEmailInput.sendKeys(username);
    }

    public void fillPassword(String password){
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void rememberMeOn(){
        rememberMeCheckBox.click();
    }

    public void signUpBtnClick(){
        signInBtn.click();
    }

    public void fullLoginRememberMeOn(String username,String password){
        fillUsername(username);
        fillPassword(password);
        rememberMeOn();
        signUpBtnClick();
    }

    public void fullLoginRememberMeOff(String username,String password){
        fillUsername(username);
        fillPassword(password);
        signUpBtnClick();
    }


}
