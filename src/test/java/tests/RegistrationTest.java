package tests;

import global.WebShopSetUpBasePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.pom.MainPage;
import pages.pom.RegisterPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationTest {
    private MainPage mainPage;
    private RegisterPage registerPage;

    @BeforeEach
    public void setUp(){
        WebShopSetUpBasePage.openBasePage();
        mainPage = page(MainPage.class);
        mainPage.registerButton.click();
    }

    static Stream<Arguments> positiveDataForRegistration(){
        return Stream.of();
    }

    @ParameterizedTest(name = "Регистрация пользователя позитивный тест")
    @MethodSource("positiveDataForRegistration")
    public void positiveRegistrationTest(){

    }
}
