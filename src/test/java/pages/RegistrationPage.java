package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    //Объявление переменных для настройки окружения
    private final String TITLE = "Student Registration Form",
            URL = "/automation-practice-form";
    private SelenideElement titlePage = $(".practice-form-wrapper"),

    //Объявление переменных для селекторов
    firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderClick = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            subjectList = $(".subjects-auto-complete__menu-list"),
            addressInput = $("#currentAddress"),
            hobbyClick = $("#hobbiesWrapper"),
            birthDayInput = $("#dateOfBirthInput"),
            fileUpload = $("#uploadPicture"),
            stateMenu = $("#stateCity-wrapper").$("#state"),
            cityMenu = $("#stateCity-wrapper").$("#city"),
            btnSubmit = $("#submit"),
            btnClose =         $("#closeLargeModal");

    public RegistrationPage openPage() {
        open(URL);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        titlePage.shouldHave(text(TITLE));
        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }


    public RegistrationPage setGender(String gender) {
        genderClick.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;

    }

    public RegistrationPage setSubject(String subjectChar, String subject) {
        subjectInput.setValue(subjectChar);
        subjectList.$(byText(subject)).click();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbyClick.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadFile(String file) {
        fileUpload.uploadFromClasspath(file);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setResidence(String state, String city) {
        stateMenu.click();
        $(byText(state)).click();

        cityMenu.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage clickBtnSubmit() {
        btnSubmit.click();
        return this;

    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultModal.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key,value);
        return this;
    }
    public RegistrationPage clickBtnClose() {
        btnClose.click();
        return this;

    }

}
