package mentorMatePageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.security.SecureRandom;

public class BaseTest {

    public WebDriver driver;
    SecureRandom random;

    // User generator
    public static String username;
    public static String defaultPassword = "Qwerty1";

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        random = new SecureRandom();
        int randomInt = random.nextInt(1000);
        this.username = "ivo" + String.valueOf(randomInt);
    }

    BasePage basePage;
    HomePage homePage;
    LandingPage landingPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    SignUpPage signUpPage;
    UploadImagePage uploadImagePage;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();


        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        signUpPage = new SignUpPage(driver);
        uploadImagePage = new UploadImagePage(driver);


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    public static void main(String[] args) {
        System.out.println();
    }
}
