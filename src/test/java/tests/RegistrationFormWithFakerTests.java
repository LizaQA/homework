package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPages;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithFakerTests extends TestBase {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        registrationFormPages.deleteElements()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender()
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobbies()
                .setPictures()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", userEmail)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", userNumber)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);

    }
}

