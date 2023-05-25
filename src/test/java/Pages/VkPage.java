package Pages;

import Tools.Tools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class VkPage {
    Tools tools = new Tools();

    private  final By NAME_CHANNEL = By.xpath("//*[@class='page_name']");

    private  final By CHECK_MARK = By.xpath("//*[@class='page_verified ']");

    @Step("Проверка правильности ссылки на официальный паблик МТС банка в VK")
    public VkPage assertNameAndOfficiality() {
        $(NAME_CHANNEL).shouldBe(visible);
        $(NAME_CHANNEL).shouldHave(text("МТС Банк"));
        $(CHECK_MARK).shouldHave(href("/verify"));
        return this;
    }
}
