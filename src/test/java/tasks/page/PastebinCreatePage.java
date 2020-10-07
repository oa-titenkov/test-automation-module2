package tasks.page;

import org.openqa.selenium.*;
import tasks.model.Paste;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PastebinCreatePage extends AbstractPage {

    private final static String HOME_URL = "https://pastebin.com/";

    public PastebinCreatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "postform-text")
    private WebElement codeArea;

    @FindBy(xpath = "//span[@aria-labelledby='select2-postform-expiration-container']")
    private WebElement pasteExpirationContainer;

    @FindBy(xpath = "//span[@aria-labelledby='select2-postform-format-container']")
    private WebElement syntaxHighlightingContainer;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPasteButton;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement syntaxHighlightingInput;

    @FindBy(id = "accept-choices")
    private WebElement acceptPrivacyButton;

    public PastebinCreatePage openPage() {
        this.driver.get(HOME_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(codeArea));
        return this;
    }

    public PastebinCreatedPage createPaste(Paste paste) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if(driver.findElements(By.id("accept-choices")).size() != 0) {
            acceptPrivacyButton.click();
        }
        codeArea.sendKeys(paste.getPasteCode());
        pasteName.sendKeys(paste.getPasteName());
        pasteExpirationContainer.click();
        Actions focusOnDropDown = new Actions(driver).moveToElement(pasteExpirationContainer);
        focusOnDropDown.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        if(paste.getSyntaxHighlighting() != null) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView();", syntaxHighlightingContainer);
            syntaxHighlightingContainer.click();
            syntaxHighlightingInput.sendKeys(paste.getSyntaxHighlighting());
            syntaxHighlightingInput.sendKeys(Keys.ENTER);
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        createNewPasteButton.click();
        return new PastebinCreatedPage(driver);
    }


}
