package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestPractice extends TestBase {
    @Test
    void fillForm() {

        //Объявление переменных
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = testData.randomItem(testData.gender),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                subjectFirst = "h",
                subjectFirstFull = "History",
                subjectSecond = "m",
                subjectSecondFull = "Maths",
                hobby = testData.randomItem(testData.hobbies),
                fileName = "doc.txt",
                address = faker.address().streetAddress(),
                state = testData.randomItem(testData.state),
                city = testData.getСity(state),
                birthday = sdf.format(faker.date().birthday()),
                birthdayArr[] = birthday.split("\\."),
                dataOfBirth = birthdayArr[1],
                monthOfBirth = testData.switchToMonth(birthdayArr[1]),
                yearOfBirth = birthdayArr[2];

        //Настройка окружения
        step("Open form", () -> {
            registrationPage.openPage();
        });

        //Заполнение формы
        step("Fill form", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(userEmail)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setBirthDay(dataOfBirth, monthOfBirth, yearOfBirth)
                    .setSubject(subjectFirst, subjectFirstFull)
                    .setSubject(subjectSecond, subjectSecondFull)
                    .setHobby(hobby)
                    .uploadFile(fileName)
                    .setCurrentAddress(address)
                    .setResidence(state, city)
                    .clickBtnSubmit();
        });

        //Проверка результата
        step("Verify results", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", userEmail)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", userNumber)
                    .verifyResult("Date of Birth", dataOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .verifyResult("Subjects", subjectFirstFull + ", " + subjectSecondFull)
                    .verifyResult("Hobbies", hobby)
                    .verifyResult("Picture", fileName)
                    .verifyResult("Address", address)
                    .verifyResult("State and City", state + " " + city)
                    .clickBtnClose();

        });

    }
}
