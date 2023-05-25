package Tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Tools {

    public Tools clickButton(By CLICK_BUTTON) {
        $(CLICK_BUTTON).shouldBe(visible, Duration.ofSeconds(2)).hover();
        $(CLICK_BUTTON).click();
        return this;
    }

    public Tools sendKeysButton(By SENDKEYS_BUTTON, String key) {
        $(SENDKEYS_BUTTON).shouldBe(visible, Duration.ofSeconds(2)).hover();
        $(SENDKEYS_BUTTON).clear();
        $(SENDKEYS_BUTTON).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
        $(SENDKEYS_BUTTON).sendKeys(key);
        return this;
    }

    public String Parser() throws IOException {
        Document doc = Jsoup.connect("https://www.mtsbank.ru/chastnim-licam/ipoteka/")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();

        Elements listNews = doc.select("b");

        String s = listNews.text();

        s = s.replaceAll(",", ".");

        String[] percents = s.split("%");

        Collection<Float> chisla = new ArrayList<>();

        for (int j = 0; j < percents.length - 2; j++) {
            System.out.println(percents[j]);
            percents[j] = percents[j].substring(percents[j].lastIndexOf(" "), percents[j].length());
            chisla.add(Float.parseFloat(percents[j]));
            System.out.println(chisla);
        }

        s=Collections.min(chisla).toString();
        s = s.replace(".", ",");

        return s;
    }
}
