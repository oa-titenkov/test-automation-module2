package tasks.page.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tasks.page.AbstractPage;

public class PastebinLoginPage extends AbstractPage {

    private final static String HOME_URL = "https://pastebin.com/login";
    @FindBy(id = "loginform-username")
    private WebElement loginArea;
    @FindBy(id = "loginform-password")
    private WebElement passwordArea;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public PastebinLoginPage(WebDriver driver) {
        super(driver);
        this.driver.get(HOME_URL);
    }

    public PastebinLoginPage openPage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(loginArea));
        return this;
    }

    public PastebinLoginPage loginIntoWebsite() {
        loginArea.sendKeys("sohumble");
        passwordArea.sendKeys("ze*rMgA-aH?9EA&");
        loginButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.titleContains("'s"));
        return this;
    }
}
