package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public FluentWait fluentWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    //Wrapper methods
    public void waitVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void writeText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        click(element);
        element.sendKeys(text);
    }

}
