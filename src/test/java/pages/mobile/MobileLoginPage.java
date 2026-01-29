package pages.mobile;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MobileLoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By username = AppiumBy.accessibilityId("test-Username");
    private final By password = AppiumBy.accessibilityId("test-Password");
    private final By loginBtn = AppiumBy.accessibilityId("test-LOGIN");

    public MobileLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
    }

    public void login(String user, String pass) {
        waitLoaded();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}

