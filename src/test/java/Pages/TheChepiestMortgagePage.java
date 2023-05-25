package Pages;

import Data.RandomData.RandomNumber;
import Data.Data;
import Tools.Tools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TheChepiestMortgagePage {
    Data data = Data.builder()
            .sum("5000000")
            .term("36")
            .initialFee("2000000")
            .date("25.05.2003")
            .mail("'hi' or 1=1--")
            .fullName("кОНСТаНТИНОПОЛЬСКИЙ-пЕТРОВ-иВАНОВ-розОв аБДУРАХМАНГАДЖИ-кОНСТАНТИН-иВАН-пЕтр кОНСТАНТиНОВИЧ-анАстасИЕвна")
            .region("Moscow")
            .build();

    Tools selTools = new Tools();

    private final By MORTGAGE_CALCULATION = By.xpath("(//*[@data-testid='button'])[2]");

    private final By COST_REAL_STATE = By.xpath("//*[@data-testid='input-slider']");

    private final By AN_INITIAL_FEE = By.xpath("(//*[@data-testid='input-slider'])[2]");

    private final By MORTGAGE_TERM = By.xpath("(//*[@data-testid='input-slider'])[3]");

    public final By FULL_NAME = By.xpath("//*[@name='fullName']");

    private final By DATA_OF_BIRTH = By.xpath("//*[@name='birthDate']");

    private final By PHONE_NUMBER = By.xpath("//*[@name='mobile']");

    private final By EMAIL = By.xpath("//*[@type='email']");

    private final By REGION = By.xpath("//*[@name='region']");

    private final By CHOOSE_REGION = By.xpath("//*[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']");

    private final By BUTTON_NEXT = By.xpath("(//*[@class='Inner-sc-1rfqasg-0 jviKiO Inner-sc-48arcs-0 bqTsRY'])[5]");

    private final By ASSERT_EMAIL = By.xpath("//*[@class='Wrapper-sc-1vydk7-0 OlnRe HelperText-sc-jsokzo-0 hByJHf']");

    @Step("Заполнение анкеты")
    public TheChepiestMortgagePage offerMortgage () {
        selTools.clickButton(MORTGAGE_CALCULATION);
        selTools.sendKeysButton(COST_REAL_STATE, data.getSum());
        selTools.sendKeysButton(AN_INITIAL_FEE, data.getInitialFee());
        selTools.sendKeysButton(MORTGAGE_TERM, data.getTerm());
        selTools.sendKeysButton(FULL_NAME, data.getFullName());
        selTools.sendKeysButton(DATA_OF_BIRTH, data.getDate());
        selTools.sendKeysButton(PHONE_NUMBER, RandomNumber.phoneNumber());
        selTools.sendKeysButton(EMAIL, data.getMail());
        selTools.sendKeysButton(REGION, data.getRegion());
        selTools.clickButton(CHOOSE_REGION);
        selTools.clickButton(BUTTON_NEXT);
        return this;
    }

    @Step("Проверка вывода сообщения об неправильном вводе почты 'Введите верный электронный адрес'")
    public TheChepiestMortgagePage failureOfferCardIncorrectEmail() {
        $(ASSERT_EMAIL).shouldBe(visible);
        $(ASSERT_EMAIL).shouldHave(text("Введите верный электронный адрес"));
        return this;
    }
}
