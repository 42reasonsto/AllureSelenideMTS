package Pages;

import Tools.Tools;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    Tools selTools = new Tools();

    private final By SLIDER = By.xpath("//*[@class='Transform-sc-o6z3ks-1 cUtKRc']");

    private final By CREDITY = By.xpath("(//*[@class='sc-jJEKmz ejANpH'])[3]");

    private final By CARDS = By.xpath("//*[@class='sc-jJEKmz ejANpH']");

    private  final By IPOTEKA = By.xpath("(//*[@class='sc-jJEKmz ejANpH'])[4]");

    private  final By OFFICES_ATM = By.xpath("(//*[@class='LinkWrapper-sc-a7l7fm-0 eaxjcO sc-cTkxnA hVRtzw'])[3]");

    private  final By SMALL_BUSINESS = By.xpath("(//*[@class='LinkWrapper-sc-a7l7fm-0 eaxjcO sc-cTkxnA hVRtzw'])[1]");

    private  final By VK = By.xpath("(//*[@class='sc-iJuVqt jPEFTR'])[2]");

    @Step("Открыть главную страницу МТС банка")
    public HomePage openHomePage() throws InterruptedException{
        Selenide.open("https://www.mtsbank.ru/");
        $(SLIDER).shouldNotBe(visible);
        Thread.sleep(30000);
        return this;
    }

    @Step("Нажать на вкладку 'Кредиты'")
    public HomePage chooseLoan() throws InterruptedException{
        selTools.clickButton(CREDITY);
        return this;
    }

    @Step("Нажать на вкладку 'Карты'")
    public HomePage chooseCards() throws InterruptedException{
        selTools.clickButton(CARDS);
        return this;
    }

    @Step("Нажать на вкладку 'Ипотека'")
    public HomePage chooseMortgage() throws InterruptedException{
        selTools.clickButton(IPOTEKA);
        return this;
    }

    @Step("Нажать на вкладку 'Офисы и банкоматы'")
    public HomePage chooseATM() throws InterruptedException{
        selTools.clickButton(OFFICES_ATM);
        return this;
    }

    @Step("Нажать на вкладку 'Малый бизнес и ИП'")
    public HomePage chooseSmallBusiness() throws InterruptedException{
        selTools.clickButton(SMALL_BUSINESS);
        return this;
    }

    @Step("Нажать на кнопку 'VK'")
    public HomePage chooseVk() throws InterruptedException{
        selTools.clickButton(VK);
        return this;
    }
}
