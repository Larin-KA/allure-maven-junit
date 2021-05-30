package test.propeller.UI;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {
    @Rule
    public TextReport report = new TextReport();

    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.startMaximized = true;
    }
    @After
    public void shutDown() {
        closeWebDriver();
    }
    @Test
    public void visibilityOfSearchResult() {
        new YandexSearchPage().searchFor();
        $(".main__center").shouldBe(visible);
    }
    @Test
    public void wordInSearchResult() {
        new YandexSearchPage().searchFor();
        $("#search-result").shouldHave(text("propellerads"));
    }
    @Test
    public void numberOfResults() {
        new YandexSearchPage().searchFor();
        $$(".serp-item").shouldHave(sizeGreaterThan(5));
    }
    @Test
    public void visibilityOfSearchResultAside() {
        new YandexSearchPage().searchFor();
        $("#search-result-aside").shouldBe(visible);
    }
    @Test
    public void visibilityOfIconInSearchResults() {
        new YandexSearchPage().searchFor();
        $(".thumb__handle").shouldBe(visible);
    }
    @Test
    public void firstLinkInSearchResult() {
        new YandexSearchPage().searchFor();
        $(".serp-item").shouldHave(text("my.propellerads.com"));
    }

}

