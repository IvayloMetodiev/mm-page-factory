package mentorMatePageFactory;

import pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest {

    LandingPage landingPage;

    @BeforeMethod
    public void SetUp() {
        landingPage = new LandingPage(driver);
    }

    @Test
    public void testOpenHomePage() {

        landingPage.openLandingPage();
        Assert.assertTrue(landingPage.isLoginBtnDisplayed());


    }
}
