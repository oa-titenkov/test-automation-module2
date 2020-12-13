package tasks.page.pastebinselenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import tasks.model.Paste;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PastebinCreatePage {

    private final static String HOME_URL = "https://pastebin.com/";

    private final SelenideElement codeArea = $(byId("postform-text"));
    private final SelenideElement pasteExpirationContainer =
            $(byXpath("//span[@aria-labelledby='select2-postform-expiration-container']"));
    private final SelenideElement syntaxHighlightingContainer =
            $(byXpath("//span[@aria-labelledby='select2-postform-format-container']"));
    private final SelenideElement pasteName = $(byId("postform-name"));
    private final SelenideElement createNewPasteButton = $(byXpath("//button[text()='Create New Paste']"));
    private final SelenideElement syntaxHighlightingInput = $(byXpath("//input[@class='select2-search__field']"));
    private final SelenideElement acceptPrivacyButton = $(byId("accept-choices"));


    public PastebinCreatePage openPage() {
        open(HOME_URL);
        $(codeArea).shouldBe(Condition.visible);
        getWebDriver().manage().window().maximize();
        return this;
    }

    public PastebinCreatedPage createPaste(Paste paste) {
        $(codeArea).shouldBe(Condition.visible);

        if (acceptPrivacyButton.is(Condition.visible)) {
            acceptPrivacyButton.click();
        }

        codeArea.sendKeys(paste.getPasteCode());
        pasteName.sendKeys(paste.getPasteName());
        pasteExpirationContainer.click();
        actions().moveToElement(pasteExpirationContainer)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        if (paste.getSyntaxHighlighting() != null) {
            executeJavaScript("arguments[0].scrollIntoView();", codeArea);
            syntaxHighlightingContainer.click();
            syntaxHighlightingInput.sendKeys(paste.getSyntaxHighlighting());
            syntaxHighlightingInput.sendKeys(Keys.ENTER);
        }
        createNewPasteButton.shouldBe(Condition.visible).click();
        return page(PastebinCreatedPage.class);
    }
}

