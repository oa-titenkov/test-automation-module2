package googlecloudtasks.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "//button[contains(text(),'Agree')]")
    private WebElement acceptPrivacyButton;


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
        if(driver.findElements(By.xpath("//button[contains(text(),'Agree')]")).size() != 0) {
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
        if(driver.findElements(By.xpath("//button[contains(text(),'Agree')]")).size() != 0) {
            acceptPrivacyButton.click();
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        mailMessage.click();
        return mailPrice.getText().split(" ")[1];
    }

}
