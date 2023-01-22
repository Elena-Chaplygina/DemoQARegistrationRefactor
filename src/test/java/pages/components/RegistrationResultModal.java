package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {

    private final String TITLE_TEXT = "Thanks for submitting the form";
    private SelenideElement modalTable = $(".modal-content"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            tableContent = $(".table-responsive");


    public void verifyModalAppears() {
        modalTable.should(appear);
        modalTitle.shouldHave(text(TITLE_TEXT));
    }

    public void verifyResult(String key, String value) {
        tableContent.$(byText(key))
                .parent().shouldHave(text(value));

    }

}
