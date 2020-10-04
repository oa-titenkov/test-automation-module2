package pastebintasks.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinCreatedPage extends AbstractPage {


  @FindBy(xpath ="//div[@class='de1']")
  private WebElement expectedTextArea;

  PastebinCreatedPage(WebDriver driver) {
    super(driver);
  }

  public boolean checkForCorrectPasteCreation() {
    WebDriverWait wait = new WebDriverWait(driver,10);
    try{
      wait.until(ExpectedConditions.visibilityOf(expectedTextArea));
      return true;
    } catch(TimeoutException exc) {
      return false;
    }
  }

  protected AbstractPage openPage() {
    throw new RuntimeException("You only checking for visibility on this page");
  }

}
