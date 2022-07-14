package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

import static utils.RandomUtils.*;

public class TestBase {
    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String userEmail =getRandomEmail();
    String address = faker.witcher().quote() ;
    String userNumber = "9154328356";
    protected String gender = getRandomGender();
    String day = String.valueOf(getRandomInt(10, 30));
    String month = String.valueOf(getRandomInt(1,9));
    String year = "1996";
    protected String subject = "English";
    protected String hobbies = "Sports";
    String state = "NCR";
    String city = "Delhi";
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
