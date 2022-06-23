package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;

public class RegistrationFormWithRandomUtilsTests extends TestBase {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();
    String firstName = getRandomString(10);
    String lastName = getRandomString(10);
    String userEmail = getRandomEmail();
    String userNumber = "99999999999";
    String day = "" + getRandomInt(10, 30);
    String month = String.valueOf(getRandomInt(1,9));
    String year = "1996";
    String subject = "English";
    String address = getRandomString(10);
    String state = "NCR";
    String city = "Delhi";

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        registrationFormPages.deleteElements()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender("Male")
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
                text("Liza QA"),
                text(userNumber),
                text("Female"),
                text("79159999999"),
                text("12 March,1996"),
                text("English"),
                text("Sports"),
                text("dog.png"),
                text("Home"),
                text("NCR Delhi")
        );
    }
}

