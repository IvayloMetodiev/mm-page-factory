package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.SecureRandom;

public class SignUpPage extends BasePage{


    @FindBy (css = "#nav-link-home")
    WebElement homeBtn;

    @FindBy (css = "#nav-link-login")
    WebElement loginBtn;

    @FindBy (css = ".text-center.mb-4")
    WebElement signUpText;

    @FindBy (css = "#homeIcon")
    WebElement skilloLogo;

    @FindBy (xpath = "//input[@name='username']")
    WebElement usernameInputFiled;

    @FindBy (xpath = "//input[@formcontrolname='email']")
    WebElement emailInputFiled;

    @FindBy (css = "#defaultRegisterFormPassword")
    WebElement passwordInputField;

    @FindBy (css = "#defaultRegisterPhonePassword")
    WebElement confirmPasswordInputFiled;

    @FindBy (css = "#sign-in-button")
    WebElement signUpBtn;

    public SignUpPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    //Verification Methods

    public boolean isHomeBtnDisplayed(){
        return homeBtn.isDisplayed();
    }

    public boolean isLoginBtnDisplayed(){
        return loginBtn.isDisplayed();
    }

    public boolean isSignUpTextDisplayed(){
        return signUpText.isDisplayed();
    }

    public boolean isLogoDisplayed(){
        return skilloLogo.isDisplayed();
    }

    public boolean isUsernameInputDisplayed(){
        return usernameInputFiled.isDisplayed();
    }

    public boolean isEmailInputDisplayed(){
        return emailInputFiled.isDisplayed();
    }

    public boolean isPasswordFiledDisplayed(){
        return passwordInputField.isDisplayed();
    }

    public boolean isConfirmPasswordDisplayed(){
        return confirmPasswordInputFiled.isDisplayed();
    }

    public boolean areAllElementsDisplayed(){
        return isConfirmPasswordDisplayed() &&
                isPasswordFiledDisplayed() &&
                isEmailInputDisplayed() &&
                isUsernameInputDisplayed() &&
                isLogoDisplayed() &&
                isSignUpTextDisplayed() &&
                isHomeBtnDisplayed() &&
                isLoginBtnDisplayed();
    }

    //Init Methods

    public void fillUsername(String username){
        click(usernameInputFiled);
        usernameInputFiled.clear();
        usernameInputFiled.sendKeys(username);
    }

    public void fillEmail(String email){
        click(emailInputFiled);
        emailInputFiled.clear();
        emailInputFiled.sendKeys(email);
    }

    public void fillPassword(String password){
        click(passwordInputField);
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void fillConfirmPassword(String password){
        click(confirmPasswordInputFiled);
        confirmPasswordInputFiled.clear();
        confirmPasswordInputFiled.sendKeys(password);
    }

    public void createAccount(String username, String email, String password){
        fillUsername(username);
        fillEmail(email);
        fillPassword(password);
        fillConfirmPassword(password);
        click(signUpBtn);
    }

}

