package tests;

import global.WebShopSetUpBasePage;
import helpers.UserGenerator;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.pom.MainPage;
import pages.pom.RegisterPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
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

    static Stream<Arguments> positiveFullDataForRegistration(){
        return Stream.of(
                Arguments.of(UserGenerator.generateValidUserFullData())
        );
    }

    @Test()
    @DisplayName("Нажать кнопку регистрация без заполнения полей")
    public void clickRegisterButtonWithoutFillFieldsTest(){
        registerPage.clickRegisterButton();
        assertTrue(registerPage.checkThatErrorsIsVisible(),
        "Ошибки не отображаются, если не заполнены обязательные поля");
    }

    @ParameterizedTest(name = "Зарегистрировать пользователя с некорректным email {0}")
    @ValueSource(strings = {
            "testEmailWithot.gmail.com",
            "testEmailWithoutEnd@",
            "testEmailWithoutDomain@gmail.",
            "тестовыйпочтовый@нб.рф",
            "123",
            "email WthSpace@gmail.com"})
    public void registerUserWithIncorrectEmailTest(String email){
        registerPage
                .fillFormOnlyRequiredData(
                "Test First Name",
                "Test Last Name",
                email,
                "123456789",
                "123456789"
        )
                        .clickRegisterButton();
        assertTrue(registerPage.wrongEmailErrorIsVisible(),
                "При введении некорректного email нет ошибки. Введенный email: " + email);
    }

    @ParameterizedTest(name = "Зарегистрировать пользователя с некорректным password {0}")
    @ValueSource(strings = {
            "12345"})
    public void registerUserWithIncorrectPasswordTest(String password){

        registerPage
                .fillFormOnlyRequiredData(
                        "Test First Name",
                        "Test Last Name",
                        RandomStringUtils.randomAlphabetic(10) + "@" + "testDom.com",
                        password,
                        password
                )
                .clickRegisterButton();
        assertTrue(registerPage.wrongPasswordErrorIsVisible(),
                "При введении некорректного пароля нет ошибки. Введенный пароль: " + password);
    }

    @ParameterizedTest(name = "Зарегистрировать юзера с уже существующим email {0}")
    @MethodSource("positiveFullDataForRegistration")
    public void registerUserWithExistingEmailTest(User user){
        String existingEmail = user.getEmail();
        registerPage.fillForm(
                        user.getGender(),
                        user.getFirstName(),
                        user.getLastName(),
                        existingEmail,
                        user.getPassword(),
                        user.getPasswordConfirm())
                .clickRegisterButton();

        mainPage.logoutButton.click();

        mainPage.registerButton.click();
        registerPage
                .fillForm(
                        user.getGender(),
                        user.getFirstName(),
                        user.getLastName(),
                        existingEmail,
                        user.getPassword(),
                        user.getPasswordConfirm())
                .clickRegisterButton();

        assertTrue(registerPage.emailAlreadyExist(),
                "При регистрации с уже существующем email нет ошибки, email:" + existingEmail);
    }

    @ParameterizedTest(name = "Зарегистрировать юзера с несовпадающими password и confirm password {0}")
    @MethodSource("positiveFullDataForRegistration")
    public void registerUserWithDifferentPasswordAndConfirmPasswordEmailTest(User user){
        String password = user.getEmail();
        String confirmPassword = "Test1234";
        registerPage.fillForm(
                        user.getGender(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        password,
                        confirmPassword)
                .clickRegisterButton();

        assertTrue(registerPage.checkPasswordsNotMatchError(),
                "При регистрации с несовпадающими паролями нет ошибки, пароль первый:" + password +
                        "Подтверждающий пароль:" + confirmPassword);
    }


}
