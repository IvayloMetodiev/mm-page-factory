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

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            Screenshot.capture(driver, "target/surefire-reports", result.getName());
        }
    }

//

    @Test (dependsOnMethods = {"mentorMatePageFactory.SignUpTest.signUpTest"}, retryAnalyzer = RetryAnalyzer.class)
    public void testLogin() {


        Assert.assertTrue(loginPage.isSignUpTextDisplayed());
        Assert.assertTrue(loginPage.isUsernameOrEmailInputDisplayed());


        String getGeneratedUser = super.getUsername();

        loginPage.fullLoginRememberMeOff(getGeneratedUser, defaultPassword);

        Assert.assertTrue(homePage.areAllElementsDisplayed());

    }


}
