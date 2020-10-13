package tasks.page.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tasks.page.AbstractPage;

import java.util.List;

public class GoogleCloudCalculatorEstimatedPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//md-card-content[@id='resultBlock']//div[@class='md-list-item-text ng-binding']")
    private List<WebElement> results;
    @FindBy(xpath = "//md-card-content[@id='resultBlock']//b[@class='ng-binding']")
    private WebElement estimatedCost;
    @FindBy(id = "email_quote")
    private WebElement emailEstimateButton;
    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement emailInput;
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;
    @FindBy(xpath = "//iframe[contains(@name,'goog')]")
    private WebElement iFrame;

    public GoogleCloudCalculatorEstimatedPage(WebDriver driver) {
        super(driver);
    }

    public String getEstimatedVMClass() {
        return results.get(1).getText().split(" ")[2];
    }

    public String getEstimatedInstanceType() {
        return results.get(2).getText().split(" ")[2];
    }

    public String getEstimatedLocation() {
        return results.get(3).getText().split(" ")[1];
    }

    public String getEstimatedLocalSSD() {
        return results.get(4).getText().split(" ")[5];
    }

    public String getEstimatedUsage() {
        return results.get(5).getText().split(" ")[2] + " " + results.get(5).getText().split(" ")[3];
    }

    public String getEstimatedPrice() {
        return estimatedCost.getText().split(" ")[4];
    }


    public TenMinutesMailHomePage sendEstimatedByEmail() {
        TenMinutesMailHomePage emailPage = new TenMinutesMailHomePage(driver);
        emailEstimateButton.click();
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        String emailAddress = emailPage.openPage().copyEmailAddress();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOf(iFrame));
        driver.switchTo().frame(iFrame);
        driver.switchTo().frame("myFrame");
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(emailAddress);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sendEmailButton);
        sendEmailButton.sendKeys(Keys.ENTER);
        logger.info("Sent price to mail: " + emailAddress);
        return emailPage;
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
