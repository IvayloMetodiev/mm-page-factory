package mentorMatePageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.security.SecureRandom;

public class BaseTest {

    public WebDriver driver;
    SecureRandom random;

    // User generator
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        random = new SecureRandom();
        int randomInt = random.nextInt(1000);
        this.username = username + String.valueOf(randomInt);
    }



    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
