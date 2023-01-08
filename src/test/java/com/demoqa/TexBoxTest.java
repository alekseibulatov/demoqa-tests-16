package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class TexBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue("user");
        $("#userEmail").setValue("user@email.com");
        $("#currentAddress").setValue("SPb, Moscow str. ");
        $("#permanentAddress").setValue("SPb, Sadovaya str. ");
        $("#submit").click();
        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text("user"));
        $("#output #email").shouldHave(text("user@email.com"));
        $("#output").$("#currentAddress").shouldHave(text("SPb, Moscow str. "));
        $("#output").$("#permanentAddress").shouldHave(text("SPb, Sadovaya str. "));
    }
}
