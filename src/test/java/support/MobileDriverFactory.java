package support;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;

public class MobileDriverFactory {

    public static AndroidDriver createAndroid() throws Exception {
        String appiumUrl = System.getProperty("appiumUrl", "http://127.0.0.1:4723/");
        String apkPath = resolveApkPath();
        String deviceName = System.getProperty("deviceName", "Android Emulator");
        String platformVersion = System.getProperty("platformVersion", "16");

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName(deviceName)
                .setApp(apkPath)
                .setAppPackage("com.swaglabsmobileapp")
                .setAppActivity("com.swaglabsmobileapp.MainActivity")
                .setNewCommandTimeout(Duration.ofSeconds(300))
                .amend("autoGrantPermissions", true)
                .amend("noReset", false);

        //instrumentation timeout
        options.amend("uiautomator2ServerLaunchTimeout", 120000);
        options.amend("uiautomator2ServerInstallTimeout", 120000);
        options.amend("adbExecTimeout", 120000);
        options.amend("appWaitDuration", 120000);
        options.amend("appWaitActivity", "com.swaglabsmobileapp.*");

        AndroidDriver driver = new AndroidDriver(URI.create(appiumUrl).toURL(), options);
        // Avoid general waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        System.out.println(">>> MOBILE SESSION ID: " + driver.getSessionId());

        return driver;
    }

    private static String resolveApkPath() {
        URL resource = MobileDriverFactory.class
                .getClassLoader()
                .getResource("Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        if (resource == null) {
            throw new RuntimeException("APK not found in src/test/resources");
        }

        return Paths.get(resource.getPath()).toAbsolutePath().toString();
    }
}
