package tasks.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tasks.driver.DriverSingleton;
import tasks.util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
    }

//    @AfterMethod(alwaysRun = true)
//    public void browserQuit() {
//        DriverSingleton.closeDriver();
//    }

}
