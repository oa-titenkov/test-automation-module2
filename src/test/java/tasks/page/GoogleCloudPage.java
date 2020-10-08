package tasks.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPage extends AbstractPage {

    private final static String HOME_URL = "https://cloud.google.com/";
    @FindBy(name = "q")
    private WebElement searchArea;

    public GoogleCloudPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPage openPage() {
        driver.get(HOME_URL);
        return this;
    }

    public GoogleCloudResultsPage searchForInput(String input) {
        searchArea.click();
        searchArea.sendKeys(input);
        searchArea.sendKeys(Keys.ENTER);
        return new GoogleCloudResultsPage(driver);
    }
}
