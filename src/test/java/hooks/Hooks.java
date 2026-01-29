package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import support.DriverManager;
import support.MobileDriverFactory;
import support.WebDriverFactory;

public class Hooks {

    @Before("@web")
    public void setupWeb() {
        DriverManager.set(WebDriverFactory.create());
    }

    @Before("@mobile")
    public void setupMobile() throws Exception {
        System.out.println(">>> SETUP MOBILE HOOK");
        DriverManager.set(MobileDriverFactory.createAndroid());
    }

    @After
    public void teardown() {
        DriverManager.quit();
    }
}
