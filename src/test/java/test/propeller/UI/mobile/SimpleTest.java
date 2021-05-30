package test.propeller.UI.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {
    @Rule
    public TextReport report = new TextReport();

    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.startMaximized = true;
    }
    @Test
    public void checkingWordInSearchResult() {
        open("https://yandex.ru");
        $(By.xpath("//*[@aria-label=\"Запрос\"]")).val("propellerads").pressEnter();
        $("#search-result").shouldHave(text("propellerads"));
    }
    @Test
    public void checkingNumberOfResults() {
        open("https://yandex.ru");
        $(By.xpath("//*[@aria-label=\"Запрос\"]")).val("propellerads").pressEnter();
        $$(".serp-item").shouldHave(sizeGreaterThan(5));
    }
}

