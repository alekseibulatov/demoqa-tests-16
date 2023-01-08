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
        String userName = "Aleksei";
        String userEmail = "user@email.com";
        String userCurrentAddress = "SPb, Moscow str.";
        String userPermanentAddress = "SPb, Sadovaya str.";
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(userCurrentAddress);
        $("#permanentAddress").setValue(userPermanentAddress);
        $("#submit").click();
        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output").$("#currentAddress").shouldHave(text(userCurrentAddress));
        $("#output").$("#permanentAddress").shouldHave(text(userPermanentAddress));
    }
}
