package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebInventoryPage {
    private final WebDriverWait wait;

    private final By inventoryList = By.cssSelector("[data-test='inventory-list']");
    private final By firstAddToCart = By.cssSelector("button.btn_inventory");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");

    public WebInventoryPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void waitLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(inventoryList));
    }

    public void addAnyProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(firstAddToCart)).click();
    }

    public String cartCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
    }
}
