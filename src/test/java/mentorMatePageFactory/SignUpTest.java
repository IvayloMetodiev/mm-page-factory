package mentorMatePageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.SignUpPage;

import java.security.SecureRandom;

public class SignUpTest extends BaseTest {

    LandingPage landingPage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    HomePage homePage;

    @BeforeMethod
    public void setUpSignUp() {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        homePage = new HomePage(driver);
    }


    @Test
    public void signUpTest() {

        landingPage.openLandingPage();
        landingPage.loginBtnClick();
        landingPage.loginBtnClick();

        loginPage.clickRegisterBtn();

        signUpPage.areAllElementsDisplayed();

        super.setUsername("ivo");
        String email = username + "@test.tt";
        String password = "Qwerty1";

        signUpPage.createAccount(super.getUsername(), email, password);

        Assert.assertTrue(homePage.areAllElementsDisplayed());



    }

}
