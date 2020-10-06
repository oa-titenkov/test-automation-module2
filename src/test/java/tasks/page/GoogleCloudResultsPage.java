package tasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudResultsPage extends AbstractPage {

    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']/..")
    private WebElement resultsPage;

    @FindBy(xpath = "//button[@class='devsite-snackbar-action']")
    private WebElement acceptPrivacyButton;

    public GoogleCloudResultsPage(WebDriver driver) {
        super(driver);
    }

    protected AbstractPage openPage() {
        return null;
    }

    public GoogleCloudCalculatorPage openCalculator() {
        WebDriverWait wait = new WebDriverWait(driver,WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(resultsPage));
        if(driver.findElements(By.xpath("//button[@class='devsite-snackbar-action']")).size() != 0) {
            acceptPrivacyButton.click();
        }
        resultsPage.click();
        return new GoogleCloudCalculatorPage(driver);
    }
}
