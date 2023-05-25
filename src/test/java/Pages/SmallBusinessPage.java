package Pages;

import Tools.Tools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SmallBusinessPage {
    Tools tools = new Tools();

    private By PAYMENT_ACCOUNT = By.xpath("//*[@class='LinkWrapper-sc-a7l7fm-0 eaxjcO sc-pGacB fvZHkK']");

    @Step("Выбор вкладки 'Расчетного счет'")
    public SmallBusinessPage choosePaymentAccount() {
        tools.clickButton(PAYMENT_ACCOUNT);
        return this;
    }
}
