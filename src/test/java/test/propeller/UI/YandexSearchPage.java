package test.propeller.UI;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexSearchPage {
    public void searchFor() {
        open("https://yandex.ru");
        $(By.xpath("//*[@aria-label=\"Запрос\"]")).val("propellerads").pressEnter();
    }
}
