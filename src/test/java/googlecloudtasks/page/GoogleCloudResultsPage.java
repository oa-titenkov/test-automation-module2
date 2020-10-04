package googlecloudtasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudResultsPage extends AbstractPage {

  @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']/..")
  private WebElement resultsPage;

  public GoogleCloudResultsPage(WebDriver driver) {
    super(driver);
  }

  protected AbstractPage openPage() {
    return null;
  }

  public GoogleCloudCalculatorPage openCalculator() {
    WebDriverWait wait = new WebDriverWait(driver,WAIT_TIMEOUT);
    wait.until(ExpectedConditions.visibilityOf(resultsPage));
    resultsPage.click();
    return new GoogleCloudCalculatorPage(driver);
  }
}
