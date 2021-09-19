package ru.solvo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWiki {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }


    @Test
    void shouldHaveExampleForJUnit5(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(byText("Show 2 more pages…")).scrollTo();
        $("#wiki-pages-box").$(byText("Show 2 more pages…")).click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
