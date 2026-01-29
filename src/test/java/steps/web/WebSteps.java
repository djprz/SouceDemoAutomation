package steps.web;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.web.WebInventoryPage;
import pages.web.WebLoginPage;
import support.DriverManager;

public class WebSteps {
    private WebLoginPage login;
    private WebInventoryPage inventory;

    @Given("I am on the Sauce Demo login page")
    public void openLogin() {
        login = new WebLoginPage(DriverManager.get());
        login.open();
    }

    @When("I login with valid credentials")
    public void loginOk() {
        login.login("standard_user", "secret_sauce");
        inventory = new WebInventoryPage(DriverManager.get());
        inventory.waitLoaded();
    }

    @When("I add any product to the cart")
    public void addProduct() {
        inventory.addAnyProduct();
    }

    @Then("cart icon shows 1 item")
    public void verifyCart() {
        Assert.assertEquals("1", inventory.cartCount());
    }
}
