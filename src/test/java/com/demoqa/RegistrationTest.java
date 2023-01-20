package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successRegistration() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Aleksei");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("sdd@qaguru.ru");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("79008763421"); //
        $("#dateOfBirthInput").click();
        $(".react-datepicker").shouldBe(Condition.visible);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1981");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFromClasspath("original.jpg");
        $("#currentAddress").setValue("SPb. Street ");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Aleksei Ivanov"), text("sdd@qaguru.ru"),
                text("Male"), text("7900876342"), text("03 March,1981"), text("Maths"),
                text("Sports"), text("original.jpg"), text("SPb. Street"), text("NCR Delhi"));

    }
}
