import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void automationPracticeForm() {
        open("/automation-practice-form");
        //Name
        $("#firstName").setValue("dfsla");
        $("#lastName").setValue("fcydtru");
        //Email
        $("#userEmail").setValue("fd@mail.ru");
        //Gender
        $("#genterWrapper").$(byText("Other")).click();
        //Phone
        $("#userNumber").setValue("9771231212");
        //Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("August")).click();
        $(".react-datepicker__year-select").$(byText("1989")).click();
        $(".react-datepicker__month").$(byText("18")).click();
        //Themes
        $("#subjectsInput").setValue("m");
        $(byText("Maths")).click();
        //Hobby
        $("#hobbiesWrapper").$(byText("Music")).click();
        //Picture
        $("#uploadPicture").uploadFromClasspath("Picture.png");
        //Address
        $("#currentAddress").setValue("Улица Еркинова 85");
        //State and city
        //Button
        $("#submit").click();

    }
}
