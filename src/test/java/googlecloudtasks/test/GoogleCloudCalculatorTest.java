package googlecloudtasks.test;

import googlecloudtasks.page.GoogleCloudCalculatorEstimatedPage;
import googlecloudtasks.page.GoogleCloudPage;
import googlecloudtasks.service.ComputeEngineService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudCalculatorTest extends CommonConditions {

  private static final String SEARCH_INPUT_TEXT = "Google Cloud Platform Pricing Calculator";
  private static final String MANUALLY_CALCULATED_PRICE = "1,082.77";

  @Test(description = "Hurt Me Plenty")
  public void calculatedPriceAndParametersAreCorrect() {
    GoogleCloudCalculatorEstimatedPage calculatedPage = new GoogleCloudPage(driver)
            .openPage()
            .searchForInput(SEARCH_INPUT_TEXT)
            .openCalculator()
            .calculateComputeEnginePrice(new ComputeEngineService().hardcoreTaskFormFill());
    Assert.assertTrue(calculatedPage.checkEstimatedParameters());
    Assert.assertEquals(calculatedPage.checkEstimatedPrice().split(" ")[4], MANUALLY_CALCULATED_PRICE);
  }

  @Test(description = "Hardcore")
  public void calculatedPriceFromEmailEqualsManuallyCalculatedPrice() {
    String calculatedPrice = new GoogleCloudPage(driver)
            .openPage()
            .searchForInput(SEARCH_INPUT_TEXT)
            .openCalculator()
            .calculateComputeEnginePrice(new ComputeEngineService().hardcoreTaskFillFromProperty())
            .sendEstimatedByEmail()
            .checkForCorrectPriceInEmail();
    Assert.assertEquals(calculatedPrice, MANUALLY_CALCULATED_PRICE);
  }


}
