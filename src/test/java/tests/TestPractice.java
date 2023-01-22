package tests;

import org.junit.jupiter.api.Test;

public class TestPractice extends TestBase {
    @Test
    void fillForm() {
        //Объявление переменных
        String userName = "Ivan",
                lastName = "Ivanov",
                userEmail = "ivanIvanovqaquru@mail.com",
                gender = "Male",
                userNumber = "9001234567",
                subjectFirst = "h",
                subjectFirstFull = "History",
                subjectSecond = "m",
                subjectSecondFull = "Maths",
                hobby = "Music",
                fileName = "doc.txt",
                address = "Lenina st, house 1",
                state = "Rajasthan",
                city = "Jaipur",
                dataOfBirth = "01",
                monthOfBirth = "May",
                yearOfBirth = "1996";


        //Настройка окружения
        registrationPage.openPage()

                //Заполнение формы
                .setFirstName(userName)
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
                .clickBtnSubmit()

                //Проверка результата
                .verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
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


    }
}
