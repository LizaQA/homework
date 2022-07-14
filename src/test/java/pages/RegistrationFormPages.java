package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponent;
import pages.components.ResultsTableComponent;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPages extends TestBase {
    SelenideElement firstNameLocator = $("#firstName");
    SelenideElement genderLocator = $(byText(gender));
    SelenideElement lastNameLocator = $("#lastName");
    SelenideElement userEmailLocator = $("#userEmail");
    SelenideElement userNumberLocator = $("#userNumber");
    SelenideElement subjectsInputLocator = $("#subjectsInput");
    SelenideElement sportsLocator = $(byText(hobbies));
    SelenideElement uploadPictureLocator = $("#uploadPicture");
    SelenideElement currentAddressLocator = $("#currentAddress");
    SelenideElement submitLocator = $("#submit");
    SelenideElement stateLocator = $("#state");
    SelenideElement cityLocator = $("#city");
    SelenideElement dateOfBirthInputLocator = $("#dateOfBirthInput");
    SelenideElement modalContentLocator = $(".modal-content");
    CalenderComponent calenderComponent = new CalenderComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public RegistrationFormPages setFirstName(String name) {
        firstNameLocator.setValue(name);
        return this;
    }

    public RegistrationFormPages setGender() {
        genderLocator.click();
        return this;
    }

    public RegistrationFormPages setLastName(String name) {
        lastNameLocator.setValue(name);
        return this;
    }

    public RegistrationFormPages setUserEmail(String email) {
        userEmailLocator.setValue(email);
        return this;
    }

    public RegistrationFormPages setUserNumber(String number) {
        userNumberLocator.setValue(number);
        return this;
    }

    public RegistrationFormPages setSubject(String subject) {
        subjectsInputLocator.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPages setHobbies() {
        sportsLocator.click();
        return this;
    }

    public RegistrationFormPages setPictures() {
        uploadPictureLocator.uploadFromClasspath("dog.png");
        return this;
    }

    public RegistrationFormPages setAddress(String address) {
        currentAddressLocator.setValue(address);
        return this;
    }

    public RegistrationFormPages setState(String state) {
        stateLocator.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationFormPages setCity(String city) {
        cityLocator.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationFormPages clickSubmit() {
        submitLocator.click();
        return this;
    }

    public RegistrationFormPages deleteElements() {
        executeJavaScript("$('header').remove()");
        executeJavaScript("$('.playgound-header').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationFormPages setDateOfBirth(String day, String month, String year) {
        dateOfBirthInputLocator.click();
        calenderComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPages checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}