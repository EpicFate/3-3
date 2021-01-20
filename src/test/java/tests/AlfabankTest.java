package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTest {
  @Test
  void DepositTest(){
    open("https://alfabank.ru/make-money/");

    $("body").shouldHave(text("Накопительные продукты"));
    $("#filter").$(byText("Депозиты")).parent().click();
    $(byText("Архивные счета и депозиты")).click();
    $$("[data-widget-name=CatalogCard]").shouldHaveSize(9);

  }

  @Test
  void SiblingTest(){
    open("https://alfabank.ru/make-money/");

    $("[data-test-id=tabs-list-tabTitle-0]").sibling(0).click();
    $("body").shouldHave(text("Страхованию подлежат"));

  }

  @Test
  void PrecedingTest(){
    open("https://alfabank.ru/make-money/");

    $("[data-test-id=tabs-list-tabTitle-2]").preceding(0).click();
    $("body").shouldHave(text("Страхованию подлежат"));

  }
  @Test
  void ClosestTest(){
    open("https://alfabank.ru/make-money/");

    $("body").shouldHave(text("Накопительные продукты"));
    $("#filter").$(byText("Депозиты")).closest("button").click();
    $(byText("Архивные счета и депозиты")).click();
    $$("[data-widget-name=CatalogCard]").shouldHaveSize(9);

  }
}
