package tasks.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tasks.page.GoogleCloudCalculatorEstimatedPage;
import tasks.page.GoogleCloudPage;
import tasks.service.ComputeEngineService;

public class GoogleCloudCalculatorTest extends CommonConditions {

    private static final String SEARCH_INPUT_TEXT = "Google Cloud Platform Pricing Calculator";
    private static final String MANUALLY_CALCULATED_PRICE = "1,082.77";

    @Test(description = "Hurt Me Plenty")
    public void calculatedPriceAndParametersAreCorrect() {
        GoogleCloudCalculatorEstimatedPage calculatedPage = new GoogleCloudPage(driver)
                .openPage()
                .searchForInput(SEARCH_INPUT_TEXT)
                .openCalculator()
                .calculateComputeEnginePrice(new ComputeEngineService().getComputeEngineHardcore());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculatedPage.getEstimatedVMClass(), "regular");
        softAssert.assertEquals(calculatedPage.getEstimatedInstanceType(), "n1-standard-8");
        softAssert.assertEquals(calculatedPage.getEstimatedLocation(), "Frankfurt");
        softAssert.assertEquals(calculatedPage.getEstimatedLocalSSD(), "2x375");
        softAssert.assertEquals(calculatedPage.getEstimatedUsage(), "1 Year");
        softAssert.assertEquals(calculatedPage.getEstimatedPrice(), MANUALLY_CALCULATED_PRICE);
        softAssert.assertAll();
    }

    @Test(description = "Hardcore")
    public void calculatedPriceFromEmailEqualsManuallyCalculatedPrice() {
        String calculatedPrice = new GoogleCloudPage(driver)
                .openPage()
                .searchForInput(SEARCH_INPUT_TEXT)
                .openCalculator()
                .calculateComputeEnginePrice(new ComputeEngineService().getComputeEngineHardcoreFromProperty())
                .sendEstimatedByEmail()
                .getPriceFromEmail();
        Assert.assertEquals(calculatedPrice, MANUALLY_CALCULATED_PRICE);
    }

}
