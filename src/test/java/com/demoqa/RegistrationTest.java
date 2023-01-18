package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

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
        $(".main-header").shouldHave(Condition.text("Practice Form"));
        $("#firstName").setValue("Aleksei");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("sdd@qaguru.ru");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("+79008763421"); //
        $("#dateOfBirthInput").click();
        $(".react-datepicker").shouldBe(Condition.visible);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1981");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--028").click();

        sleep(5000);


    }

    @AfterAll
    static void afterAll() {

    }
}
