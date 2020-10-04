package googlecloudtasks.page;

import googlecloudtasks.model.ComputeEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleCloudCalculatorEstimatedPage extends AbstractPage {

    public GoogleCloudCalculatorEstimatedPage(WebDriver driver) {
        super(driver);
    }

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

    public boolean checkEstimatedParameters() {
        if(!results.get(1).getText().contains("regular")) return false;
        else if(!results.get(2).getText().contains("n1-standard-8")) return false;
        else if(!results.get(3).getText().contains("Frankfurt")) return false;
        else if(!results.get(4).getText().contains("2x375 GiB")) return false;
        else return results.get(5).getText().contains("1 Year");
    }

    public String checkEstimatedPrice() {
        return estimatedCost.getText();
    }


    public TenMinutesMailHomePage sendEstimatedByEmail() {
        TenMinutesMailHomePage emailPage = new TenMinutesMailHomePage(driver);
        emailEstimateButton.click();
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        String emailAddress = emailPage.openPage().copyEmailAdress();
        WebElement frame = driver.findElement(By.xpath("//iframe[contains(@name,'goog')]"));
        driver.switchTo().frame(frame);
        driver.switchTo().frame("myFrame");
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(emailAddress);
        sendEmailButton.click();
        logger.info("Sent price to mail: " + emailAddress);
        return emailPage;
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
