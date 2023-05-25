package Tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {
    @BeforeEach
    public void setUpClass() {
        WebDriverManager.chromedriver().driverVersion("103").setup();
        System.setProperty("chromeoptions.args", "--no-sandbox");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    /*
    Для мобильной эмуляции
    @BeforeEach
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
        Selenide.clearBrowserCookies();
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
    }*/

    @AfterEach
    public void turnDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
