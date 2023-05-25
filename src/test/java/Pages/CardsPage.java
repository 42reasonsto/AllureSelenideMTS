package Pages;

import Data.RandomData.RandomNumber;
import Data.Data;
import Tools.Tools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CardsPage {
    Data data = Data.builder()
            .date("22.05.2005")
            .mail("admin@#$^&*()♠ ♣ ♥ ♦@gmail")
            .fullName("Yn Cho")
            .build();

    Tools seltools = new Tools();

    private final By MTS_CARD = By.xpath("//*[@data-testid='flexbox']");

    private final By PHONE_NUMBER = By.xpath("//*[@type='tel']");

    private final By FULL_NAME = By.xpath("//*[@name='clientFio']");

    private final By BIRTH_DATE = By.xpath("//*[@name='birthDate']");

    private final By EMAIL = By.xpath("//*[@type='email']");

    private final By ALLOW_INFO_BANK = By.xpath("(//*[@class='Wrapper-sc-cb89gg-0 bfTvzg'])[2]");

    private final By NEXT_BUTTON = By.xpath("(//*[@class='Inner-sc-1rfqasg-0 jviKiO Inner-sc-48arcs-0 bqTsRY'])[10]");

    private final By ASSERT_FIO = By.xpath("//*[@id='FABodyContainer']/form/div[1]/div[2]/div[2]");

    private final By ASSERT_PATRONYMIC = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[4]/div/div[3]/div/div[14]/div/div[2]/form/div[1]/div[2]/div[3]/label/div[2]/div");

    @Step("Нажать на карту 'КРЕДИТНАЯ КАРТА MTS CASHBACK 111 ДНЕЙ БЕЗ %'")
    public CardsPage chooseMtsCard() {
        seltools.clickButton(MTS_CARD);
        return this;
    }

    @Step("Убрать согласие на рекламные предложения по почте от банка")
    public CardsPage notAllowInfoBank() {
        seltools.clickButton(ALLOW_INFO_BANK);
        return this;
    }

    @Step("Заполнение анкеты")
    public CardsPage offerCard() {
        seltools.sendKeysButton(PHONE_NUMBER, RandomNumber.phoneNumber());
        seltools.sendKeysButton(FULL_NAME, data.getFullName());
        seltools.sendKeysButton(BIRTH_DATE, data.getDate());
        seltools.sendKeysButton(EMAIL, data.getMail());
        seltools.clickButton(NEXT_BUTTON);
        return this;
    }

    @Step("Проверка вывода сообщения об ошибке в вводе ФИО 'Используйте только кириллицу'")
    public CardsPage failureOfferCardIncorrectFullNameEnglish() {
        $(ASSERT_FIO).shouldBe(visible);
        $(ASSERT_FIO).shouldHave(text("Используйте только кириллицу"));
        return this;
    }

    @Step("Проверка вывода сообщения об ошибке в вводе ФИО 'Нет отчества'")
    public CardsPage failureOfferCardIncorrectSurname() {
        $(ASSERT_PATRONYMIC).shouldBe(visible);
        $(ASSERT_PATRONYMIC).shouldHave(text("Нет отчества"));
        return this;
    }
}
