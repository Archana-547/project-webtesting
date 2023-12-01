package org.tallinn.Archana;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class StepTest {

    @Test
    public void  insertingIncorrectCredentialsAndCheckingTheErrorMessageTest() {
        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name=\"username-input\"]").setValue("aarchan");
        $x("//input[@data-name=\"password-input\"]").setValue("password");
        $x("//button[@data-name=\"signIn-button\"]").click();
        $x("//div[@data-name=\"authorizationError-popup\"]").shouldBe(Condition.exist,Condition.visible);

    }
    @Test
    public void testOrderPageDisplay() {
        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name=\"username-input\"]").setValue("archanaaqa");
        $x("//input[@data-name=\"password-input\"]").setValue("p5Twdy789");
        $x("//button[@data-name=\"signIn-button\"]").click();
        $x("//div[@data-name=\"order-page\"]").shouldBe(Condition.visible,Condition.text("order Details"));

    }
    @Test
    public void testLoginErrorAndRetry() {
        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name=\"username-input\"]").setValue("aarchan");
        $x("//input[@data-name=\"password-input\"]").setValue("password");
        $x("//button[@data-name=\"signIn-button\"]").click();
        $x("//div[@data-name=\"authorizationError-popup\"]").shouldBe(Condition.exist,Condition.visible);

        $x("//[input@data-name=\"username-input\"]").clear();
        $x("//input[@data-name=\"password-input\"]").clear();

        $x("//input[@data-name=\"username-input\"]").setValue("archanaaqa");
        $x("//input[@data-name=\"password-input\"]").setValue("p5Twdy789");
        $x("//div[@data-name=\"order-page\"]").shouldBe(Condition.visible,Condition.text("order Details"));

    }

    @Test
    public void testUsernameMinimumCharacterLimit() {
        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name=\"username-input\"]").setValue("a");
        $x("//button[@data-name=\"signIn-button\"]").click();

        $x("//div[@data-name=\"invalid-credentials \"]").shouldBe(Condition.text("Username should have minimum 2 characters"),Condition.visible);


    }
    @Test
    public void testPasswordMinimumCharacterLimit() {
        Selenide.open("http://51.250.6.164:3000/signin");
        $x("//input[@data-name=\"password-input\"]").setValue("pwd");
        $x("//button[@data-name=\"signIn-button\"]").click();
        $x("//div[@data-name=\"invalid-credentials \"]").shouldBe(Condition.text("password should have minimum 8characters"),Condition.visible);
    }

}

