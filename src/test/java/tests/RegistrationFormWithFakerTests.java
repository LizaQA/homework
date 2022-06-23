package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPages;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;

public class RegistrationFormWithFakerTests extends TestBase {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        registrationFormPages.deleteElements()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDate(day, month, year)
                .setSubject(subject)
                .setHobbies()
                .setPictures()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        $("[class = modal-content]").shouldHave(
                text(firstName + " " +lastName),
                text(userNumber),
                text(gender),
                text(userNumber),
                text(subject),
                text("Sports"),
                text("dog.png"),
                text(address ),
                text("NCR Delhi")
        );
    }
}

