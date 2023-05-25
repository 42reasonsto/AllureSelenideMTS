package Pages;

import Tools.Tools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PaymentAccountPage {
    Tools tools = new Tools();

    private By CHOOSE_PAYMENT_ACCOUNT=By.xpath("//*[@class='Wrapper-sc-48arcs-1 eXAjGp']");

    @Step("Выбор кнопки 'Подобрать тариф'")
    public PaymentAccountPage pickUpPaymentAccount() {
        tools.clickButton(CHOOSE_PAYMENT_ACCOUNT);
        return this;
    }
}
