package tests;

import global.WebShopSetUpBasePage;
import helpers.UserGenerator;
import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.pom.MainPage;
import pages.pom.RegisterPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static data.SystemMessages.successfulRegistration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {
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
    static Stream<Arguments> positiveRequiredDataForRegistration(){
        return Stream.of(
                Arguments.of(UserGenerator.generateValidUserFullData())
        );
    }

    @ParameterizedTest(name = "Регистрация пользователя позитивный тест со всеми полями")
    @MethodSource("positiveFullDataForRegistration")
    public void positiveRegistrationTest(User user){
        registerPage.fillForm(
                user.getGender(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getPasswordConfirm())
                .clickRegisterButton();
        assertEquals(registerPage.getRegistrationResult(), successfulRegistration,
                "Сообщение о регистрации либо некорректное, либо отсутствует");
    }
    @ParameterizedTest(name = "Регистрация пользователя позитивный тест только с обязательными полями")
    @MethodSource("positiveFullDataForRegistration")
    public void positiveRegistrationOnlyRequiredTest(User user){
        registerPage.fillFormOnlyRequiredData(
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getPasswordConfirm())
                .clickRegisterButton();
        assertEquals(registerPage.getRegistrationResult(), successfulRegistration,
                "Сообщение о регистрации либо некорректное, либо отсутствует");
    }
}
