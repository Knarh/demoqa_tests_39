import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
        $(".css-1wa3eu0-placeholder").click();
        $(byText("NCR")).click();
        $(".css-1wa3eu0-placeholder").click();
        $(byText("Noida")).click();

        //Button
        $("#submit").click();

        //examination
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("dfsla fcydtru"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("fd@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9771231212"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("18 August,1989"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Picture.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Улица Еркинова 85"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));



    }
}
