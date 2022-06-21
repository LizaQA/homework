package pages;

import org.openqa.selenium.By;
import pages.components.CalenderComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPages {
    CalenderComponent calenderComponent = new CalenderComponent ();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
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
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public RegistrationFormPages setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
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

    public RegistrationFormPages setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
       calenderComponent.setDate("12","2","1996");

        return this;
    }
    public void checkResult (String key, String value) {

        resultsTableComponent.checkResult(key, value);
    }
}