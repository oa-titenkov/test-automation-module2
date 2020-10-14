package tasks.page.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tasks.model.ComputeEngine;
import tasks.page.AbstractPage;

public class GoogleCloudCalculatorPage extends AbstractPage {

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
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckbox;
    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudCalculatorEstimatedPage calculateComputeEnginePrice(ComputeEngine computeEngine) {
        driver.switchTo().frame(mainFrame);
        driver.switchTo().frame("myFrame");

        wait.until(ExpectedConditions.visibilityOf(inputInstances));
        computeEngineButton.click();

        inputInstances.sendKeys(computeEngine.getNumberOfInstances());
        inputInstancesReason.sendKeys(computeEngine.getInstancesReason());

        getDropDown(computeEngine.getOperationSystemSoftware()).click();
        getElement(computeEngine.getOperationSystemSoftware()).click();

        getDropDown(computeEngine.getVMClass()).click();
        getElement(computeEngine.getVMClass()).click();

        if (System.getProperty("browser").equals("firefox")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToEstimateButton);
        }
        wait.until(ExpectedConditions.visibilityOf(getDropDown(computeEngine.getInstanceType()))).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(getElement(computeEngine.getInstanceType()))).click();

        if (!computeEngine.getGPUNumber().equals("")) {
            addGPUsCheckbox.click();
        }
        wait.until(ExpectedConditions.visibilityOf(getDropDown("GPUCount"))).click();
        getElement("GPUCount " + computeEngine.getGPUNumber()).click();
        getDropDown(computeEngine.getGPUType()).click();
        getElement(computeEngine.getGPUType()).click();

        getDropDown(computeEngine.getLocalSSD()).click();
        getElement(computeEngine.getLocalSSD()).click();

        getDropDown(computeEngine.getLocation()).click();
        getElement(computeEngine.getLocation()).click();

        getDropDown(computeEngine.getCommittedUsage()).click();
        getElement(computeEngine.getCommittedUsage()).click();

        addToEstimateButton.click();
        logger.info("Price estimated");
        return new GoogleCloudCalculatorEstimatedPage(driver);
    }

    private WebElement getElement(String element) {
        if (element.contains("GPUCount")) {
            int count = Integer.parseInt(element.split(" ")[1]) + 1;
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                    By.xpath("//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]'][" +
                            count + "]")
            )));
        }
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("(//div[contains(text(),'" + element + "')]/parent::md-option)[last()]")
        )));
    }

    private WebElement getDropDown(String element) {
        if (element.contains("GPUCount")) {
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                    By.xpath("//md-select[@placeholder='Number of GPUs']")
            )));
        }
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("(//div[contains(text(),'" + element + "')]/ancestor::md-select)[1]")
        )));
    }

    protected AbstractPage openPage() {
        return null;
    }
}
