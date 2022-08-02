package mentorMatePageFactory;

import pages.HomePage;
import pages.LoginPage;
import com.mentormate.common.RetryAnalyzer;
import com.mentormate.common.Screenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    String defaultPassword = "Qwerty1";


    @BeforeMethod
    public void SetUp() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            Screenshot.capture(driver, "target/surefire-reports", result.getName());
        }
    }

//    (retryAnalyzer = RetryAnalyzer.class)

    @Test (dependsOnMethods = {"mentorMatePageFactory.SignUpTest.signUpTest"})
    public void testLogin() {

        Assert.assertTrue(loginPage.isSignUpTextDisplayed());
        Assert.assertTrue(loginPage.isUsernameOrEmailInputDisplayed());


        String getGeneratedUser = super.getUsername();

        System.out.println(getGeneratedUser);

//        loginPage.fullLoginRememberMeOff(getGeneratedUser, defaultPassword);
//
//        Assert.assertTrue(homePage.areAllElementsDisplayed());

    }


}
