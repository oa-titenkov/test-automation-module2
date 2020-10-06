package tasks.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinCreatedPage extends AbstractPage {


    @FindBy(xpath = "//div[@class='de1']")
    private WebElement correctCreationTextArea;

    @FindBy(xpath = "//div[@class='left']")
    private WebElement expectedSyntax;

    @FindBy(xpath = "//textarea")
    private WebElement expectedCodeArea;

    PastebinCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkForCorrectPasteCreation() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        try{
            wait.until(ExpectedConditions.visibilityOf(correctCreationTextArea));
            return true;
        } catch(TimeoutException exc) {
            return false;
        }
    }

    public String getSyntax() {
        return expectedSyntax.getText().split(" ")[0];
    }

    public String getCode() {
        return expectedCodeArea.getText();
    }


    protected AbstractPage openPage() {
        throw new RuntimeException("You only checking for visibility on this page");
    }

}
