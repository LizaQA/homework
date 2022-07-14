package pages.components;

import pages.RegistrationFormPages;

import static com.codeborne.selenide.Selenide.$;

public class CalenderComponent {

    public void setDate(String day, String month, String year) {
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day).click();

    }

}
