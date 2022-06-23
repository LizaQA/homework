package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPageObjectTest extends TestBase {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();
    String firstName = "Liza";
    String lastName = "QA";
    String userEmail = "LizaQA@mail.ru";
    String userNumber = "79159999999";
    String day = "12";
    String month = "2";
    String year = "1996";
    String subject = "English";
    String address = "Home";
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
                text("LizaQA@mail.ru"),
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
