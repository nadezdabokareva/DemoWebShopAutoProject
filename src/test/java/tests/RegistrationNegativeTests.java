package tests;

import global.WebShopSetUpBasePage;
import helpers.UserGenerator;
import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import pages.pom.MainPage;
import pages.pom.RegisterPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationNegativeTests {
    private MainPage mainPage;
    private RegisterPage registerPage;

    @BeforeEach
    public void setUp(){
        WebShopSetUpBasePage.openBasePage();
        mainPage = page(MainPage.class);
        registerPage = page(RegisterPage.class);
        mainPage.registerButton.click();
    }

    @AfterEach
    public void clean(){
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test()
    @DisplayName("Нажать кнопку регистрация без заполнения полей")
    public void clickRegisterButtonWithoutFillFieldsTest(){
        registerPage.clickRegisterButton();
        assertTrue(registerPage.checkThatErrorsIsVisible(),
        "Ошибки не отображаются, если не заполнены обязательные поля");
    }

    @ParameterizedTest(name = "Зарегистрировать пользователя с некорректным email")
    @CsvSource({
            "testEmailWithot.gmail.com",
            "testEmailWithoutEnd@",
            "testEmailWithoutDomain@gmail.",
            "тестовыйпочтовый@нб.рф",
            "",
            "email WthSpace@gmail.com"})
    public void registerUserWithIncorrectEmailTest(String email){
        registerPage.fillFormOnlyRequiredData(
                "Test First Name",
                "Test Last Name",
                email,
                "123456789",
                "123456789"
        );
    }

    @ParameterizedTest(name = "Зарегистрировать пользователя с некорректным password")
    @CsvSource({})
    public void registerUserWithIncorrectPasswordTest(){

    }

    @ParameterizedTest(name = "Зарегистрировать пользователя с некорректным confirm password")
    @CsvSource({})
    public void registerUserWithIncorrectConfirmPasswordTest(){

    }
}
