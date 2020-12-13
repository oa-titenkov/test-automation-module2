package tasks.page.pastebinselenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PastebinCreatedPage {

    private final SelenideElement correctCreationTextArea = $(byXpath("//div[@class='de1']"));
    private final SelenideElement expectedSyntax = $(byXpath("//div[@class='left']"));
    private final SelenideElement expectedCodeArea = $(byXpath("//textarea"));

    public boolean checkForCorrectPasteCreation() {
        return correctCreationTextArea.waitUntil(Condition.visible, 10000).exists();
    }

    public String getSyntax() {
        return expectedSyntax.getText().split(" ")[0];
    }

    public String getCode() {
        return expectedCodeArea.getText();
    }

}
