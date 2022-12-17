package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $("#firstName").setValue("Aleksei");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("sdd@qaguru.ru");

        sleep(5000);

    }
    @AfterAll
    static void afterAll(){

    }
}
