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


public class GoogleCloudCalculatorPage extends AbstractPage {

  public GoogleCloudCalculatorPage(WebDriver driver) {
    super(driver);
  }

  private WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
  private final Logger logger = LogManager.getRootLogger();


  @FindBy(xpath = "//iframe[contains(@name,'goog')]")
  private WebElement mainFrame;

  @FindBy(xpath = "//div[@class='tab-holder compute']")
  private WebElement computeEngineButton;

  @FindBy(xpath = "//input[@id='input_60']")
  private WebElement inputInstances;

  @FindBy(xpath = "//input[@id='input_61']")
  private WebElement inputInstancesReason;

  @FindBy(id = "select_value_label_53")
  private WebElement operatingSystemSoftwareDropdown;

  @FindBy(id = "select_value_label_54")
  private WebElement VMClassDropdown;

  @FindBy(id = "select_86")
  private WebElement machineTypeDropdown;

  @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
  private WebElement addGPUsCheckbox;

  @FindBy(id = "select_value_label_370")
  private WebElement numberOfGPUsDropdown;

  @FindBy(id = "select_value_label_371")
  private WebElement GPUTypeDropdown;

  @FindBy(id = "select_value_label_192")
  private WebElement localSSDDropdown;

  @FindBy(id = "select_value_label_58")
  private WebElement datacenterLocationDropdown;

  @FindBy(id = "select_value_label_59")
  private WebElement committedUsageDropdown;

  @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
  private WebElement addToEstimateButton;

  public GoogleCloudCalculatorEstimatedPage calculateComputeEnginePrice(ComputeEngine computeEngine) {
    driver.switchTo().frame(mainFrame);
    driver.switchTo().frame("myFrame");
    wait.until(ExpectedConditions.visibilityOf(inputInstances));
    computeEngineButton.click();
    inputInstances.sendKeys(computeEngine.getNumberOfInstances());
    inputInstancesReason.sendKeys(computeEngine.getInstancesReason());
    operatingSystemSoftwareDropdown.click();
    parseElement(computeEngine.getOperationSystemSoftware(),"").click();
    VMClassDropdown.click();
    parseElement(computeEngine.getVMClass(),"75").click();
    machineTypeDropdown.click();
    parseElement(computeEngine.getInstanceType(),"").click();
    if(!computeEngine.getGPUNumber().equals("")) addGPUsCheckbox.click();
    wait.until(ExpectedConditions.visibilityOf(numberOfGPUsDropdown));
    numberOfGPUsDropdown.click();
    parseElement(computeEngine.getGPUNumber(),"377").click();
    GPUTypeDropdown.click();
    parseElement(computeEngine.getGPUType(),"").click();
    localSSDDropdown.click();
    parseElement(computeEngine.getLocalSSD(),"").click();
    datacenterLocationDropdown.click();
    parseElement(computeEngine.getLocation(),"204").click();
    committedUsageDropdown.click();
    parseElement(computeEngine.getCommittedUsage(),"93").click();
    addToEstimateButton.click();
    logger.info("Price estimated");
    return new GoogleCloudCalculatorEstimatedPage(driver);
  }

  private WebElement parseElement(String input, String id) {
    if(id.equals("")) {
      return wait.until(ExpectedConditions.visibilityOf(driver.findElement
              (By.xpath("//div[contains(text(),'" + input + "')]/ancestor::md-option"))));
    }
    else {
      return wait.until(ExpectedConditions.visibilityOf(driver.findElement
              (By.xpath("//div[contains(text(),'" + input + "')]/ancestor::md-option[@id='select_option_" +id+"']"))));
    }

  }

  protected AbstractPage openPage() {
    return null;
  }
}
