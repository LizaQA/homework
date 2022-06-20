package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPages {

    public RegistrationFormPages setFirstName(String name) {
        $("#firstName").setValue(name);
        return this;
    }

    public RegistrationFormPages setGender() {
        $(byText("Female")).click();
        return this;
    }

    public RegistrationFormPages setLastName(String name) {
        $("#lastName").setValue(name);
        return this;
    }

    public RegistrationFormPages setUserEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationFormPages setUserNumber(String number) {
        $("#userNumber").setValue(number);
        return this;
    }

    public RegistrationFormPages setDate(String day, String month, String year) {
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public RegistrationFormPages setSubject(String subject) {
        $(By.xpath("//div[@class = 'subjects-auto-complete__input']/input")).setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPages setHobbies() {
        $(byText("Sports")).click();
        return this;
    }

    public RegistrationFormPages setPictures() {
        $("#uploadPicture").uploadFromClasspath("dog.png");
        return this;
    }

    public RegistrationFormPages setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationFormPages setState(String state) {
        $("#state").click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationFormPages setCity(String city) {
        $("#city").click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationFormPages clickSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPages deleteElements() {
        executeJavaScript("$('header').remove()");
        executeJavaScript("$('.playgound-header').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

}