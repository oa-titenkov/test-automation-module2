package tasks.page.google;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tasks.page.AbstractPage;

import java.util.ArrayList;

public class TenMinutesMailHomePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    @FindBy(id = "mail_address")
    private WebElement emailAddress;
    @FindBy(id = "inbox_count_number")
    private WebElement inboxCounter;
    @FindBy(xpath = "//div[@class='message_top']")
    private WebElement mailMessage;
    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    private WebElement mailPrice;
    @FindBy(xpath = "//button[contains(text(),'I accept')]")
    private WebElement acceptPrivacyButton;
    @FindBy(xpath = "//button[contains(text(),'Agree')]")
    private WebElement agreePrivacyButton;

    public TenMinutesMailHomePage(WebDriver driver) {
        super(driver);
    }

    public TenMinutesMailHomePage openPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com/");
        return this;
    }

    public String copyEmailAddress() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.attributeContains(emailAddress, "value", "@"));
        String emailAddressText = emailAddress.getAttribute("value");
        if (driver.findElements(By.xpath("//button[contains(text(),'I accept')]")).size() != 0) {
            acceptPrivacyButton.click();
        }
        driver.switchTo().window(tabs.get(0));
        return emailAddressText;
    }

    public String getPriceFromEmail() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(inboxCounter, "1"));
        if (driver.findElements(By.xpath("//button[contains(text(),'I accept')]")).size() != 0) {
            acceptPrivacyButton.click();
        } else if (driver.findElements(By.xpath("//button[contains(text(),'Agree')]")).size() != 0) {
            agreePrivacyButton.click();
        }
        wait.until(ExpectedConditions.visibilityOf(mailMessage)).click();
        wait.until(ExpectedConditions.visibilityOf(mailPrice));
        String price = mailPrice.getText();
        logger.info("price " + price);
        return price.split(" ")[1];
    }

}
