package Pages;

import Tools.Tools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.IOException;

public class MortgagePage {
    Tools selTools = new Tools();

    private final By PROGRAMS = By.xpath("(//*[@class='Wrapper-sc-1vydk7-0 jLWLXd TabText-sc-tyqhzb-3 faRXmE'])[2]");

    private final By MORE_PROGRAMS = By.xpath("(//*[@class='Inner-sc-1rfqasg-0 jviKiO Inner-sc-48arcs-0 bqTsRY'])[21]");

    @Step("Нажать на ипотеку с наименьшей ставкой")
    public MortgagePage chooseMortgage() throws IOException {
        selTools.clickButton(PROGRAMS);
        selTools.clickButton(MORE_PROGRAMS);

        String s= selTools.Parser();

        String xpathStart="//*[contains(text(),'";

        String xpathEnd="')]";

        By IPOTEKA = By.xpath(xpathStart+s+xpathEnd);

        selTools.clickButton(IPOTEKA);
        return this;
    }
}
