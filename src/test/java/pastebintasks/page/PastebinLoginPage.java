package pastebintasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinLoginPage extends AbstractPage {

  private final static String HOME_URL = "https://pastebin.com/login";

  public PastebinLoginPage(WebDriver driver) {
    super(driver);
    this.driver.get(HOME_URL);
  }

  @FindBy(id = "loginform-username")
  private WebElement loginArea;

  @FindBy(id = "loginform-password")
  private WebElement passwordArea;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement loginButton;

  public PastebinLoginPage openPage() {
    new WebDriverWait(driver,20)
            .until(ExpectedConditions.visibilityOf(loginArea));
    return this;
  }

  public PastebinLoginPage loginIntoWebsite() {
    loginArea.sendKeys("sohumble");
    passwordArea.sendKeys("ze*rMgA-aH?9EA&");
    loginButton.click();
    new WebDriverWait(driver,5)
            .until(ExpectedConditions.titleContains("'s"));
    return this;
  }
}
