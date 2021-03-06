package tasks.page.pastebin;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tasks.model.Paste;
import tasks.page.AbstractPage;

public class PastebinCreatePage extends AbstractPage {

    private final static String HOME_URL = "https://pastebin.com/";
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

    public PastebinCreatePage(WebDriver driver) {
        super(driver);
    }

    public PastebinCreatePage openPage() {
        this.driver.get(HOME_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(codeArea));
        return this;
    }

    public PastebinCreatedPage createPaste(Paste paste) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(codeArea));
        if (driver.findElements(By.id("accept-choices")).size() != 0) {
            acceptPrivacyButton.click();
        }
        codeArea.sendKeys(paste.getPasteCode());
        pasteName.sendKeys(paste.getPasteName());
        pasteExpirationContainer.click();
        Actions focusOnDropDown = new Actions(driver).moveToElement(pasteExpirationContainer);
        focusOnDropDown.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        if (paste.getSyntaxHighlighting() != null) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView();", codeArea);
            syntaxHighlightingContainer.click();
            syntaxHighlightingInput.sendKeys(paste.getSyntaxHighlighting());
            syntaxHighlightingInput.sendKeys(Keys.ENTER);
        }
        wait.until(ExpectedConditions.visibilityOf(createNewPasteButton)).click();
        return new PastebinCreatedPage(driver);
    }


}
