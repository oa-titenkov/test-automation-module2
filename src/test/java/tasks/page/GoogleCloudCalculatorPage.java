package tasks.page;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import tasks.model.ComputeEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

public class GoogleCloudCalculatorPage extends AbstractPage {

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    private final WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    private final Logger logger = LogManager.getRootLogger();


    @FindBy(xpath = "//iframe[contains(@name,'goog')]")
    private WebElement mainFrame;

    @FindBy(xpath = "//div[@class='tab-holder compute']")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//input[@id='input_61']")
    private WebElement inputInstances;

    @FindBy(xpath = "//input[@id='input_62']")
    private WebElement inputInstancesReason;

    @FindBy(id = "select_value_label_54")
    private WebElement operatingSystemSoftwareDropdown;

    @FindBy(id = "select_value_label_55")
    private WebElement VMClassDropdown;

    @FindBy(id = "select_87")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(id = "select_value_label_371")
    private WebElement numberOfGPUsDropdown;

    @FindBy(id = "select_value_label_372")
    private WebElement GPUTypeDropdown;

    @FindBy(id = "select_option_378")
    private WebElement gpuNumberOption;

    @FindBy(id = "select_value_label_193")
    private WebElement localSSDDropdown;

    @FindBy(id = "select_value_label_59")
    private WebElement datacenterLocationDropdown;

    @FindBy(id = "select_value_label_60")
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
        getElement(computeEngine.getOperationSystemSoftware()).click();
        VMClassDropdown.click();
        getElement(computeEngine.getVMClass()).click();
        if(System.getProperty("browser").equals("firefox")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToEstimateButton);
        }
        wait.until(ExpectedConditions.visibilityOf(machineTypeDropdown)).click();
        getElement(computeEngine.getInstanceType()).click();
        if(!computeEngine.getGPUNumber().equals("")) {
            addGPUsCheckbox.click();
        }
        wait.until(ExpectedConditions.visibilityOf(numberOfGPUsDropdown)).click();
        gpuNumberOption.click();
        GPUTypeDropdown.click();
        getElement(computeEngine.getGPUType()).click();
        localSSDDropdown.click();
        getElement(computeEngine.getLocalSSD()).click();
        datacenterLocationDropdown.click();
        getElement(computeEngine.getLocation()).click();
        committedUsageDropdown.click();
        getElement(computeEngine.getCommittedUsage()).click();
        addToEstimateButton.click();

        logger.info("Price estimated");
        return new GoogleCloudCalculatorEstimatedPage(driver);
    }

    private WebElement getElement(String element) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("(//div[contains(text(),'" + element + "')]/parent::md-option)[last()]")
        )));
    }

    protected AbstractPage openPage() {
        return null;
    }
}
