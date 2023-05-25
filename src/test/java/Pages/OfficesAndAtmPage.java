package Pages;

import Data.Data;
import Tools.Tools;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class OfficesAndAtmPage {
    Tools tools = new Tools();

    private By FILTER = By.xpath("//*[@class='styled__Container-sc-szata3-0 jhjBtN']");

    private By OFFICES = By.xpath("(//*[@class='Wrapper-sc-1vydk7-0 qtifC'])[7]");

    private By SALON = By.xpath("(//*[@class='Wrapper-sc-1vydk7-0 qtifC'])[8]");

    private By SVYAZNOY_SHOP = By.xpath("(//*[@class='Wrapper-sc-1vydk7-0 qtifC'])[9]");

    private By REGION = By.xpath("(//*[@type='text'])[2]");

    private By REGION_CHOOSE = By.xpath("//*[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']");

    private By TERMINAL = By.xpath("//*[@class='ymaps-2-1-79-events-pane ymaps-2-1-79-user-selection-none']");

    @Step("Отфильтровать по терминалам и банкоматам работающим сейчас")
    public OfficesAndAtmPage filtration() {
        tools.clickButton(FILTER);
        tools.clickButton(OFFICES);
        tools.clickButton(SALON);
        return this;
    }

    @Step("Ввод места поиска банкомата")
    public OfficesAndAtmPage region(String region) {
        Data data = Data.builder()
                .region(region)
                .build();
        tools.clickButton(REGION);
        tools.sendKeysButton(REGION,data.getRegion());
        return this;
    }

    @Step("Нажать на банкомат на карте")
    public OfficesAndAtmPage chooseATMOnMap() {
        tools.clickButton(TERMINAL);
        return this;
    }

    @Step("Проверка введенного региона")
    public OfficesAndAtmPage assertRegion(String region) {
        $(REGION).shouldHave(value(region));
        return this;
    }
}
