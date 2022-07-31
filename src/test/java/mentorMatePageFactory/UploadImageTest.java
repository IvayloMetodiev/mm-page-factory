package mentorMatePageFactory;

import com.mentormate.common.Screenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.UploadImagePage;

public class UploadImageTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    UploadImagePage uploadImagePage;
    ProfilePage profilePage;

    String filePath = "C:\\Users\\Ivaylo Metodiev\\IdeaProjects\\PageFactorySkillo\\src\\main\\resources\\cat.jpg";
    String caption = "Testing caption 123 !@#$%%$";


    @BeforeMethod
    public void SetUp() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
//        uploadImagePage = new UploadImagePage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            Screenshot.capture(driver, "target/surefire-reports", result.getName());
        }
    }

    @Test
    public void uploadImageTest() {

        loginPage.fullLoginRememberMeOff("ivaylo123", "Qwerty1");

        homePage.clickNewPostBtn();

        uploadImagePage = new UploadImagePage(driver);

        Assert.assertTrue(uploadImagePage.areAllElementsVisible());

        uploadImagePage.createPublicPost(filePath, caption);

        profilePage = new ProfilePage(driver);

        Assert.assertTrue(profilePage.areAllElementsDisplayed());
    }


}
