package mentorMatePageFactory;

import com.mentormate.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
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

public class LandingPageTest {

    public Actions actions;
    WebDriver driver;
    LandingPage landingPage;

    WebElement signInText;
    WebElement usernameOrEmailInput;
    WebElement passwordInput;
    WebElement signInBtn;
    WebElement registerBtn;
    WebElement profileBtn;
    WebElement logoutBtn;
    WebElement newPostBtn;
    WebElement username;
    WebElement email;
    String defaultPassword = "Qwerty1";
    String usernameGenerator;
    WebElement password;
    WebElement confirmPassword;
    WebElement signUpBtn;
    WebElement loginBtn;
    String testCaption = "Testing caption 123 123 #@$%^$";
    WebDriverWait wait;

    @BeforeTest
    public void SetUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920x1080");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        landingPage = new LandingPage(driver);

    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testOpenHomePage() {

        Assert.assertTrue(landingPage.isLoginBtnDisplayed());


    }
}
