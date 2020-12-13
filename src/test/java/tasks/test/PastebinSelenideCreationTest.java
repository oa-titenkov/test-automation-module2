package tasks.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tasks.model.Paste;
import tasks.page.pastebinselenide.PastebinCreatePage;
import tasks.page.pastebinselenide.PastebinCreatedPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PastebinSelenideCreationTest {

    @Test(description = "I Can Win")
    public void pasteCorrectlyCreated() {
        Paste paste = new Paste("Hello from WebDriver", "10 Minutes", "helloweb");
        boolean expectedPasteCreation = new PastebinCreatePage()
                .openPage()
                .createPaste(paste)
                .checkForCorrectPasteCreation();
        Assert.assertTrue(expectedPasteCreation, "Paste was created incorrectly!");
    }

    @Test(description = "Bring It On")
    public void pasteCorrectlyCreatedWithSyntax() {
        String pasteCode = "git config --global user.name  \"New Sheriff in Town\"" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
                "git push origin master --force";
        String pasteName = "how to gain dominance among developers";
        String expirationTime = "10 Minutes";
        String syntax = "Bash";

        Paste paste = new Paste(pasteCode, expirationTime, pasteName, syntax);
        PastebinCreatedPage pasteCreatedPage = new PastebinCreatePage()
                .openPage()
                .createPaste(paste);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pasteCreatedPage.checkForCorrectPasteCreation(), "Incorrect paste!");
        softAssert.assertEquals(getWebDriver().getTitle(), pasteName + " - Pastebin.com");
        softAssert.assertEquals(pasteCreatedPage.getSyntax(), syntax);
        softAssert.assertEquals(pasteCreatedPage.getCode(), pasteCode);
        softAssert.assertAll();

    }

}
