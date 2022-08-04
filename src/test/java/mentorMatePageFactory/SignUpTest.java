package mentorMatePageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.SignUpPage;

import java.security.SecureRandom;

public class SignUpTest extends BaseTest { ;

    @Test
    public void signUpTest() {

        setUsername();
        System.out.println(getUsername());

        landingPage.openLandingPage();
        landingPage.loginBtnClick();
        landingPage.loginBtnClick();

        loginPage.clickRegisterBtn();

        signUpPage.areAllElementsDisplayed();


        super.setUsername();
        String email = username + "@test.tt";
        String password = "Qwerty1";

        signUpPage.createAccount(super.getUsername(), email, password);

        Assert.assertTrue(homePage.areAllElementsDisplayed());



    }

}
