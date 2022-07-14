package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormWithTestDataTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        executeJavaScript("$('header').remove()");
        executeJavaScript("$('.playgound-header').remove()");
        executeJavaScript("$('footer').remove()");
        $("[id=firstName]").setValue("Liza");
        $("[id=lastName]").setValue("QA");
        $("[id=userEmail]").setValue("LizaQA@mail.ru");
        $(byText("Female")).click();
        $("[id=userNumber]").setValue("79159999999");
        // заметка на будущее "[class = имя_класса]" тоже самое что и ".имя_класса", обе этих опции это поиск элемента по имени класса
        $("[class = react-datepicker-wrapper]").click();
        $("[class = react-datepicker__month-select]").selectOptionByValue("2");
        $("[class = react-datepicker__year-select]").selectOptionByValue(String.valueOf("1996"));
        $(".react-datepicker__day--012").click();
        $(By.xpath("//div[@class = 'subjects-auto-complete__input']/input")).setValue("English").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("dog.png");
        $("[id=currentAddress]").setValue("Home");
        $("[id = state]").click();
        $(byText("NCR")).click();
        $("[id = city]").click();
        $(byText("Delhi")).click();
        $("[id = submit]").click();
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
