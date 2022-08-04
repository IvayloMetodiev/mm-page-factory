package mentorMatePageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(dependsOnMethods = {"mentorMatePageFactory.SignUpTest.signUpTest"})
    public void logoutTest() {

        landingPage.openLandingPage();
        Assert.assertTrue(landingPage.isLoginBtnDisplayed());
        landingPage.loginBtnClick();

        Assert.assertTrue(loginPage.areAllLoginPageElementsDisplayed());
        loginPage.fullLoginRememberMeOff(super.getUsername(), defaultPassword);

        Assert.assertTrue(homePage.areAllElementsDisplayed());
        homePage.clickLogoutBtn();

        Assert.assertTrue(landingPage.);


    }


}
