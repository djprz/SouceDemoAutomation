# Souce Demo Automation


## Requirements

- Java 17 or higher
- Apache Maven 3.9.12
- Node.js (for Appium)

## Appium Setup

Install Appium and the UiAutomator2 driver:

````
npm i -g appium
appium driver install uiautomator2
appium server -p 4723
````

### Emulator

Android Studio > AVD Manager > Start

To get the emulator device name:

`````$ adb devices`````

## Executing tests

All tests

```mvn test```

if changing the parameters needed

````
mvn test -DappiumUrl="http://127.0.0.1:4723/" \
-DdeviceName="emulator-5554" \
-DplatformVersion="16"
````

### Filtering by tags

#### Only Web

````mvn test -Dcucumber.filter.tags="@web"````

#### Only Mobile

````
mvn test -Dcucumber.filter.tags="@mobile" \
-DappiumUrl="http://127.0.0.1:4723/" \
-DdeviceName="emulator-5554" \
-DplatformVersion="16"
````

#### Filtering by feature file

````
mvn test -Dcucumber.filter.tags="@web and not @mobile"
````

````
mvn test -Dcucumber.features="src/test/resources/features/web_login_add_to_cart.feature"
````


