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

public class TestSuiteYandexSearch {
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
        new SearchPage().searchFor("propellerads");
        $(".main__center").shouldBe(visible);
    }
    @Test
    public void firstLinkInSearchResult() {
        new SearchPage().searchFor("propellerads");
        $$(".serp-item").shouldHave(sizeGreaterThan(5)).first().shouldHave(text("joinpropeller.com"));
    }
    @Test
    public void wordInSearchResult() {
        new SearchPage().searchFor("propellerads");
        $("#search-result").shouldHave(text("propellerads"));
    }
    @Test
    public void numberOfResults() {
        new SearchPage().searchFor("propellerads");
        $$(".serp-item").shouldHave(sizeGreaterThan(5));
    }
    @Test
    public void visibilityOfSearchResultAside() {
        new SearchPage().searchFor("propellerads");
        $("#search-result-aside").shouldBe(visible);
    }
    @Test
    public void textInSearchResultAside() {
        new SearchPage().searchFor("propellerads");
        $("#search-result-aside").shouldHave(text("Нашлось 9 тыс. результатов"));
    }
    @Test
    public void visibilityOfVKIconInSearchResults() {
        new SearchPage().searchFor("propellerads");
        $(By.xpath("//*[@aria-label='Изображение с сайта vk.com']")).scrollIntoView(true).shouldBe(visible);
    }
    @Test
    public void visibilityOfInstIconInSearchResults() {
        new SearchPage().searchFor("propellerads");
        $(By.xpath("//*[@aria-label='Изображение с сайта www.instagram.com']")).scrollIntoView(true).shouldBe(visible);
    }
    @Test
    public void visibilityOfTwitIconInSearchResults() {
        new SearchPage().searchFor("propellerads");
        $(By.xpath("//*[@aria-label='Изображение с сайта twitter.com']")).scrollIntoView(true).shouldBe(visible);
    }
}

