package pastebintasks.test;

import pastebintasks.model.Paste;
import pastebintasks.page.PastebinCreatePage;
import pastebintasks.page.PastebinLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinPasteCreationTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        new PastebinLoginPage(driver)
                .openPage()
                .loginIntoWebsite();
    }

    @Test(description = "I Can Win")
    public void pasteCorrectlyCreatedTest() {
        Paste paste = new Paste("Hello from WebDriver", "10 Minutes", "helloweb");
        //PastebinCreatePage page = new PastebinCreatePage(driver);
        boolean expectedPasteCreation = new PastebinCreatePage(driver)
                .openPage()
                .createPaste(paste)
                .checkForCorrectPasteCreation();
        Assert.assertTrue(expectedPasteCreation, "Paste was created incorrectly!");
    }

    @Test(description = "Bring It On")
    public void pasteCorrectlyCreatedWithSyntaxTest() {
        String pasteCode = "git config --global user.name  \"New Sheriff in Town\"" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
                "git push origin master --force";
        Paste paste = new Paste(
                pasteCode,
                "10 Minutes",
                "how to gain dominance among developers",
                "Bash");
        boolean expectedPasteCreation = new PastebinCreatePage(driver)
                .openPage()
                .createPaste(paste)
                .checkForCorrectPasteCreation();
        Assert.assertTrue(expectedPasteCreation, "Incorrect paste!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
