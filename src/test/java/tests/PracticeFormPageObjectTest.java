package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPageObjectTest {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        registrationFormPages.deleteElements()
                .setFirstName("liza")
                .setLastName("QA")
                .setUserEmail("LizaQA@mail.ru")
                .setGender()
                .setUserNumber("79159999999")
                .setDate("12", "2", "1996")
                .setSubject("English")
                .setHobbies()
                .setPictures()
                .setAddress("Home")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        $("[class = modal-content]").shouldHave(
                text("Liza QA"),
                text("LizaQA@mail.ru"),
                text("Female"),
                text("7915999999"),
                text("12 March,1996"),
                text("English"),
                text("Sports"),
                text("dog.png"),
                text("Home"),
                text("NCR Delhi")
        );
    }
}
