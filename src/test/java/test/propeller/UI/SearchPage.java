package test.propeller.UI;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {
    public void searchFor(String text) {
        open("https://yandex.ru");
        $(By.xpath("//*[@id='text']")).val(text).pressEnter();
    }
}
