package steps.mobile;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.mobile.MobileLoginPage;
import pages.mobile.MobileInventoryPage;
import support.DriverManager;

public class MobileSteps {
    private MobileLoginPage login;
    private MobileInventoryPage products;

    @Given("I launch the sample mobile app")
    public void launchApp() {
        login = new MobileLoginPage(DriverManager.get());
        products = new MobileInventoryPage(DriverManager.get());
    }

    @When("I login with valid credentials on mobile")
    public void loginMobile() {
        login.login("standard_user", "secret_sauce");
    }

    @When("I add any product to the cart on mobile")
    public void addMobile() {
        products.waitLoaded();
        products.addFirstProduct();
    }

    @Then("cart icon shows 1 item on mobile")
    public void verifyMobile() {
        Assert.assertTrue("Expected cart to show 1 item", products.cartShowsOne());
    }
}
