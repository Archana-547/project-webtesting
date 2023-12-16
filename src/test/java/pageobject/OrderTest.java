package pageobject;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class OrderTest {
   OrderPage orderPage = new OrderPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("http://51.250.6.164:3000/signin");
        Selenide.localStorage().setItem("jwt","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcmNoYW5hYXFhIiwiZXhwIjoxNzAyMzQ4NDU2LCJpYXQiOjE3MDIzMzA0NTZ9.1TTIrC_G361ZsQus102n-w1ObyTE4mbXLSVaeYWElzk2sA9TXmTWIEGRoW3VtT9l5QfgXQ1A3RPNiYTaIUF83g");

        Selenide.refresh();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void creatingAnOrder() {
        orderPage.name.sendKeys("CustomerName");
        orderPage.phone.sendKeys("5676879");
        orderPage.comment.sendKeys("Comment");
        orderPage.orderButton.click();
    }


}
