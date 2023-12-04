package remote;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class LoginRemoteBrowserTest {


    @Test
    public void incorrectCredentialsTest() {

        Selenide.open("http://51.250.6.164:3000/signin");

        $x("//*[@data-name='username-input']").setValue("your_username");
        $x("//*[@data-name='password-input']").setValue("your_password");
        $x("//*[@data-name='signIn-button']").click();
        $x("//*[@data-name='authorizationError-popup']").shouldBe(Condition.exist, Condition.visible);

    }
    @BeforeAll
    public static void setUpAll(){
        Configuration.remote = "http://34.68.42.160:4444" + "/wd/hub";;
        Configuration.browser = "Chrome";
        Configuration.browserVersion = "114.0";
        Configuration.browserSize = "1920x1080";

        Configuration.browserCapabilities.setCapability("selenoid:options",
                Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));
    }



    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }
}
