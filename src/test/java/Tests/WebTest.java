package Tests;

import Pages.*;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.switchTo;

public class WebTest extends BaseTest {
    HomePage home = new HomePage();

    LoanPage loan = new LoanPage();

    CardsPage cards = new CardsPage();

    MortgagePage mortgage = new MortgagePage();

    TheChepiestMortgagePage cheapiestMortgage = new TheChepiestMortgagePage();

    OfficesAndAtmPage officesAndAtmPage = new OfficesAndAtmPage();

    SmallBusinessPage smallBusinessPage = new SmallBusinessPage();

    PaymentAccountPage paymentAccountPage = new PaymentAccountPage();

    PickUpPaymentAccountPage pickUpPaymentAccountPage = new PickUpPaymentAccountPage();

    VkPage vkPage = new VkPage();

    @org.junit.jupiter.api.Test
    @Description("На странице кредита подается заявка на кредит с ошибкой в возрасте. Проверяется вывод сообщений 'Возраст клиента должен быть не более 70 лет'")
    @DisplayName("Неккоректный ввод возраста при оформлении кредита")
    @Severity(value = SeverityLevel.NORMAL)
    public void takeLoanMTS() throws InterruptedException {
        home.openHomePage()
                .chooseLoan();
        loan.offerLoan()
                .failureOfferLoanIncorrectAge();
 }

    @org.junit.jupiter.api.Test
    @Description("На странице дебеторской карты подается заявка с ошибкой в ФИО. Проверяется вывод сообщений 'Используйте только кириллицу', 'Нет отчества'")
    @DisplayName("Неккоректный ввод ФИО при оформлении карты")
    @Severity(value = SeverityLevel.NORMAL)
    public void takeCardMTS() throws InterruptedException{
        home.openHomePage()
                .chooseCards();
        cards.chooseMtsCard()
                .notAllowInfoBank()
                .offerCard()
                .failureOfferCardIncorrectFullNameEnglish()
                .failureOfferCardIncorrectSurname();
 }

    @org.junit.jupiter.api.Test
    @Description("На странице ипотеки подается заявка с ошибкой в почте. Проверяется вывод сообщений 'Введите верный электронный адрес'")
    @DisplayName("Неккоректный ввод почты при оформлении ипотеки")
    @Severity(value = SeverityLevel.NORMAL)
    public void takeMortgageMTS() throws IOException,InterruptedException {
        home.openHomePage()
                .chooseMortgage();
        mortgage.chooseMortgage();
        cheapiestMortgage.offerMortgage()
                .failureOfferCardIncorrectEmail();
    }

    @ParameterizedTest
    @ValueSource(strings={"Москва","Санкт-Петербург"})
    @Description("Ищется ближайший банкомат в городе")
    @DisplayName("Проверка поиска банкомата")
    @Severity(value = SeverityLevel.NORMAL)
    public void takeATMAdress(String region) throws InterruptedException {
        home.openHomePage()
                .chooseATM();
        officesAndAtmPage.filtration()
                .region(region)
                .assertRegion(region)
                .chooseATMOnMap();
    }

    @org.junit.jupiter.api.Test
    @Description("На странице расчетного счета подается заявка с ошибкой в ИНН. Проверяется вывод сообщений 'ИНН некорректный, проверьте правильность написания'.")
    @DisplayName("Неккоректный ввод ИНН при оформлении расчетного счета")
    @Severity(value = SeverityLevel.NORMAL)
    public void takePaymentAccount() throws InterruptedException {
        home.openHomePage().chooseSmallBusiness();
        smallBusinessPage.choosePaymentAccount();
        paymentAccountPage.pickUpPaymentAccount();
        pickUpPaymentAccountPage.calculatePaymentAccount()
                .offerPaymentAccount()
                .failureOfferCardIncorrectInn();
    }

    @org.junit.jupiter.api.Test
    @Description("На главной странице сайта нажимается кнопка соцсети 'VK', проверяется открытие официальной страницы МТС банка")
    @DisplayName("Проверка кнопки со ссылкой на VK и проверка правильности ссылки на официальный паблик МТС банка в VK")
    @Severity(value = SeverityLevel.TRIVIAL)
    public void takeVk() throws InterruptedException {
        home.openHomePage()
                .chooseVk();
        switchTo().window(1);
        vkPage.assertNameAndOfficiality();
    }
}