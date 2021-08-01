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
        new SearchPage().searchFor("selenide");
        $(".main__center").shouldBe(visible);
    }
    @Test
    public void firstLinkInSearchResult() {
        new SearchPage().searchFor("selenide");
        $$(".serp-item").shouldHave(sizeGreaterThan(5)).first().shouldHave(text("ru.selenide.org"));
    }
    @Test
    public void wordInSearchResult() {
        new SearchPage().searchFor("selenide");
        $("#search-result").shouldHave(text("selenide"));
    }
    @Test
    public void numberOfResults() {
        new SearchPage().searchFor("selenide");
        $$(".serp-item").shouldHave(sizeGreaterThan(5));
    }
    @Test
    public void visibilityOfSearchResultAside() {
        new SearchPage().searchFor("selenide");
        $("#search-result-aside").shouldBe(visible);
    }
    @Test
    public void textInSearchResultAside() {
        new SearchPage().searchFor("selenide");
        $("#search-result-aside").shouldHave(text("Нашлось 103 млн результатов"));
    }
    @Test
    public void visibilityOfGithubLink() {
        new SearchPage().searchFor("selenide");
        $$(".serp-item").findBy(text("Github")).shouldBe(visible).shouldHave(text("Concise UI Tests with Java!"));
    }
    @Test
    public void visibilityOfTwitterLink() {
        new SearchPage().searchFor("selenide");
        $$(".serp-item").findBy(text("Twitter")).shouldBe(visible).shouldHave(text("Selenide is a library for writing concise, readable, boilerplate-free tests in Java using Selenium WebDriver."));
    }
    @Test
    public void visibilityOfYoutubeLink() {
        new SearchPage().searchFor("selenide");
        $$(".serp-item").findBy(text("Введение в Selenide")).shouldBe(visible).shouldHave(text("youtube.com"));
    }
}

