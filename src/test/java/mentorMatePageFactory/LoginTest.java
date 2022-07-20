package mentorMatePageFactory;

import com.mentormate.LandingPage;
import com.mentormate.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest {

    WebDriver driver;
    LandingPage landingPage;
    LoginPage loginPage;

    WebElement profileBtn;
    WebElement logoutBtn;
    WebElement newPostBtn;
    String defaultPassword = "Qwerty1";
    String testCaption = "Testing caption 123 123 #@$%^$";


    @BeforeTest
    public void SetUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920x1080");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);

    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    public void testLogin() {

        Assert.assertTrue(loginPage.isSignUpTextDisplayed());
        Assert.assertTrue(loginPage.isUsernameOrEmailInputDisplayed());

//        loginPage.fillUsername("Ivaylo123");
//        loginPage.fillPassword(defaultPassword);
//loginPage.fullLoginRememberMeOff("ivaylo123", defaultPassword);


//        profileBtn = driver.findElement(By.xpath("//a[@id='nav-link-profile']"));
//        logoutBtn = driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt fa-lg']"));
//        newPostBtn = driver.findElement(By.xpath("//a[@id='nav-link-new-post']"));
//
//        Assert.assertTrue(profileBtn.isDisplayed());
//        Assert.assertTrue(logoutBtn.isDisplayed());
//        Assert.assertTrue(newPostBtn.isDisplayed());
    }
}
