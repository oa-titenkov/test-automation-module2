package pastebintasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

  protected WebDriver driver;
  protected final int WAIT_TIMEOUT = 10;

  protected abstract AbstractPage openPage();

  public AbstractPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
}
