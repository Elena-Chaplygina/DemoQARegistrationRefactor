package tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationPage;

import java.text.SimpleDateFormat;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    TestData testData = new TestData();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    @BeforeAll
    public static void setUpp() {
        WebDriverProvider provider = new WebDriverProvider();
    }


    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Скриншот");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
