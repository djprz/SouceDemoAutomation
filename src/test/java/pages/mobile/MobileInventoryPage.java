package pages.mobile;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class MobileInventoryPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By productsTitle = AppiumBy.accessibilityId("test-PRODUCTS");
    private final By addToCartButtons = AppiumBy.accessibilityId("test-ADD TO CART");
    private final By oneItem = AppiumBy.xpath(
            "//android.view.ViewGroup[@content-desc='test-Cart']//android.widget.TextView[@text='1']"
            );
    // Another way to search
    //    AppiumBy.androidUIAutomator(
    //        "new UiSelector().text(\"1\").fromParent(new UiSelector().description(\"test-Cart\"))"
    //    )

    public MobileInventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle));
    }

    public void addFirstProduct() {
        waitLoaded();
        wait.until(driver -> driver.findElements(addToCartButtons).size() > 0);
        driver.findElements(addToCartButtons).get(0).click();
    }

    public boolean cartShowsOne() {
        return driver.findElements(oneItem).size() > 0;
    }
}
