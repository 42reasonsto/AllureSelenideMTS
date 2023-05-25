package Pages;

import Data.Data;
import Data.RandomData.RandomNumber;
import Tools.Tools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PickUpPaymentAccountPage {
    Tools tools = new Tools();

    Data data = Data.builder()
            .countExternalTransfer("50")
            .sum("900000000")
            .cashDeposit("500000")
            .cashWithdrawal("100000")
            .creditingMoney("150000")
            .mail("@gmail.com")
            .nameOrganization("ИП@#$ Морозов Test")
            .fullName("Морозов Т#ст Тестович")
            .build();

    private final By COUNT_EXTERNAL_TRANSFER = By.xpath("//*[@data-testid='input-slider']");

    private final By SUM_TRANSFER = By.xpath("(//*[@data-testid='input-slider'])[2]");

    private final By CASH_DEPOSIT = By.xpath("(//*[@data-testid='input-slider'])[3]");

    private final By CASH_WITHDRAWAL = By.xpath("(//*[@data-testid='input-slider'])[4]");

    private final By CREDITING_MONEY = By.xpath("(//*[@data-testid='input-slider'])[5]");

    private final By PROFITABLE_ACCOUNT = By.xpath("(//*[@class='Inner-sc-1rfqasg-0 jviKiO ContentWrapper-sc-48arcs-3 jKrHAG'])[8]");

    private final By PHONE_NUMBER = By.xpath("//*[@name='phone']");

    private final By EMAIL = By.xpath("//*[@name='email']");

    private final By INN = By.xpath("//*[@name='companyINN']");

    private final By DATA_ORGANIZATION_MANUALLY = By.xpath("//*[@id='form']/form/div[2]/div[3]/label/div[1]");

    private final By NAME_ORGANIZATION = By.xpath("//*[@name='companyName']");

    private final By ORGANIZATION_FORM = By.xpath("//*[@class='InputWrapper-sc-j3a9iz-3 ypIQB']");

    private final By IP = By.xpath("(//*[@class='Wrapper-sc-1vydk7-0 qtifC Label-sc-1uyl36s-2 gPjQZi'])[2]");

    private final By CONTACT_NAME = By.xpath("//*[@name='managementName']");

    private final By NEXT_BUTTON = By.xpath("//*[@class='styled__BottomContainer-w5xpkp-0 ejWUgm']");

    private final By ASSERT_INN = By.xpath("(//*[@class='Wrapper-sc-1vydk7-0 OlnRe HelperText-sc-jsokzo-0 hByJHf'])[2]");

    @Step("Расчет расчетного счета")
    public PickUpPaymentAccountPage calculatePaymentAccount() {
        tools.sendKeysButton(COUNT_EXTERNAL_TRANSFER, data.getCountExternalTransfer());
        tools.sendKeysButton(SUM_TRANSFER, data.getSum());
        tools.sendKeysButton(CASH_DEPOSIT, data.getCashDeposit());
        tools.sendKeysButton(CASH_WITHDRAWAL, data.getCashWithdrawal());
        tools.sendKeysButton(CREDITING_MONEY, data.getCreditingMoney());
        return this;
    }

    @Step("Оформление расчетного счета")
    public PickUpPaymentAccountPage offerPaymentAccount() {
        tools.clickButton(PROFITABLE_ACCOUNT);
        tools.clickButton(DATA_ORGANIZATION_MANUALLY);
        tools.sendKeysButton(PHONE_NUMBER, RandomNumber.phoneNumber());
        tools.sendKeysButton(EMAIL, data.getMail());
        tools.sendKeysButton(INN, RandomNumber.innNumber());
        tools.sendKeysButton(NAME_ORGANIZATION, data.getNameOrganization());
        tools.clickButton(ORGANIZATION_FORM);
        tools.clickButton(IP);
        tools.sendKeysButton(CONTACT_NAME, data.getFullName());
        tools.clickButton(NEXT_BUTTON);
        return this;
    }

    @Step("Проверка вывода сообщения о неправильном вводе ИНН с надписью 'ИНН некорректный, проверьте правильность написания'")
    public PickUpPaymentAccountPage failureOfferCardIncorrectInn() {
        $(ASSERT_INN).shouldBe(visible);
        $(ASSERT_INN).shouldHave(text("ИНН некорректный, проверьте правильность написания"));
        return this;
    }
}
