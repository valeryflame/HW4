import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void verifySoftAssertions() {
        open("selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-pages-box").should(appear);
        if ($$("button").findBy(text("Show 3 more pages")).exists()) {
            $$("button").findBy(text("Show 3 more pages")).scrollTo().click();
        }
        $(".wiki-pages-box").$$("li").findBy(text("SoftAssertions")).should(appear).click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $(".wiki-pages-box").shouldHave(text("Using JUnit5 extend test class"));
    }
}
