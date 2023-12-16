package pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {
    public SelenideElement name = $x("//*[@data-name='username-input']");
    public SelenideElement phone =  $x("//*[@data-name='phone-input']");

    public SelenideElement comment =  $x("//*[@data-name='comment-input']");
    public SelenideElement orderButton =  $x("//button[@data-name='createOrder-button']");

}
