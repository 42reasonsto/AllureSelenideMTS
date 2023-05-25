package Pages;

import Data.RandomData.RandomNumber;
import Data.Data;
import Tools.Tools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class LoanPage {
    Data data = Data.builder()
            .date("25.04.1953")
            .mail("test@gmail.com")
            .fullName("Г И-Д")
            .term("25")
            .sum("1000000")
            .build();

    Tools selTools = new Tools();

    private final By LOAN_CALCULATION = By.xpath("(//*[@class='Wrapper-sc-1vydk7-0 jLWLXd ButtonText-sc-48arcs-2 ivMpRV'])[2]");

    private final By COST_REAL_STATE_LOAN = By.xpath("(//*[@data-testid='input-slider'])[1]");

    private final By TERM_LOAN = By.xpath("(//*[@data-testid='input-slider'])[2]");

    private final By AUTO = By.xpath("(//*[@class='Wrapper-sc-1vydk7-0 qtifC Label-sc-1uyl36s-2 gPjQZi'])[2]");

    private final By TARGET_LOAN = By.xpath("(//*[@class='TextareaWrapper-sc-1ux9qvi-0 bUIboz'])[1]");

    private final By FULL_NAME = By.xpath("//*[@name='clientFio']");

    private final By DATA_OF_BIRTH = By.xpath("//*[@name='birthDate']");

    private final By PHONE_NUMBER = By.xpath("//*[@name='phoneNumber']");

    private final By EMAIL = By.xpath("//*[@type='email']");

    private final By BUTTON_NEXT = By.xpath("//*[@class='Wrapper-sc-48arcs-1 cMfwrv']");

    private final By ASSERT_AGE = By.xpath("//*[@class='Wrapper-sc-1vydk7-0 OlnRe HelperText-sc-jsokzo-0 hByJHf']");

    @Step("Заполнение анкеты")
    public LoanPage offerLoan() {
        selTools.clickButton(LOAN_CALCULATION);
        selTools.sendKeysButton(COST_REAL_STATE_LOAN, data.getSum());
        selTools.sendKeysButton(TERM_LOAN, data.getTerm());
        selTools.clickButton(TARGET_LOAN);
        selTools.clickButton(AUTO);
        selTools.sendKeysButton(FULL_NAME, data.getFullName());
        selTools.sendKeysButton(DATA_OF_BIRTH, data.getDate());
        selTools.sendKeysButton(PHONE_NUMBER, RandomNumber.phoneNumber());
        selTools.sendKeysButton(EMAIL, data.getMail());
        selTools.clickButton(BUTTON_NEXT);
        return this;
    }

    @Step("Проверка сообщения об ошибке в возрасте")
    public LoanPage failureOfferLoanIncorrectAge() {
        $(ASSERT_AGE).shouldBe(visible);
        $(ASSERT_AGE).shouldHave(text("Возраст клиента должен быть не более 70 лет"));
        return this;
    }
}
