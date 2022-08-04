package mentorMatePageFactory;

import com.mentormate.common.Screenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ProfilePage;
import pages.UploadImagePage;

public class CreatePublicPostTest extends BaseTest {

    String filePath = "C:\\Users\\ivaylo.metodiev\\IdeaProjects\\mm-page-factory\\src\\main\\resources\\cat.jpg";
    String caption = "Testing caption 123 !@#$%%$";

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            Screenshot.capture(driver, "target/surefire-reports", result.getName());
        }
    }

    @Test(dependsOnMethods = {"mentorMatePageFactory.SignUpTest.signUpTest"})
    public void uploadImageTest() {

        loginPage.fullLoginRememberMeOff(getUsername(), defaultPassword);

        homePage.clickNewPostBtn();

        uploadImagePage = new UploadImagePage(driver);

        Assert.assertTrue(uploadImagePage.areAllElementsVisible());

        uploadImagePage.createPublicPost(filePath, caption);

        profilePage = new ProfilePage(driver);

        Assert.assertTrue(profilePage.isGalleryDisplayed());
        Assert.assertTrue(profilePage.areAllElementsDisplayed());
    }


}
