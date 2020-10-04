package googlecloudtasks.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TenMinutesMailHomePage extends AbstractPage {

  public TenMinutesMailHomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "mail_address")
  private WebElement emailAddress;

  @FindBy(id = "inbox_count_number")
  private WebElement inboxCounter;

  @FindBy(xpath = "//div[@class='message_top']")
  private WebElement mailMessage;

  @FindBy(xpath = "//h3[contains(text(),'USD')]")
  private WebElement mailPrice;


  public TenMinutesMailHomePage openPage() {
    ((JavascriptExecutor) driver).executeScript("window.open()");
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get("https://10minutemail.com/");
    return this;
  }

  public String copyEmailAdress() {
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    wait.until(ExpectedConditions.attributeContains(emailAddress, "value", "@"));
    String emailAddressText = emailAddress.getAttribute("value");
    driver.switchTo().window(tabs.get(0));
    return emailAddressText;
  }

  public String checkForCorrectPriceInEmail() {
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.textToBePresentInElement(inboxCounter, "1"));
    mailMessage.click();
    return mailPrice.getText().split(" ")[1];
  }


}
