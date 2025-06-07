package tests;

import com.codeborne.selenide.WebDriverRunner;
import data.PageTitleText;
import global.WebShopSetUpBasePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.components.PageTitle;
import pages.pom.MainPage;
import pages.pom.RegisterPage;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты для главной страницы")
public class MainPageTest {
    private MainPage mainPage;

    @BeforeEach
    public void openBasePage(){
        WebShopSetUpBasePage.openBasePage();
        mainPage = page(MainPage.class);
    }

    @Test
    @DisplayName("Открыть страницу Register")
    public void openRegisterPage(){
        mainPage.registerButton.click();
        assertEquals(WebDriverRunner.url(), "https://demowebshop.tricentis.com/register",
                "Страница регистрации не открылась/изменился url");
        String actualTitle = new PageTitle().getPageTitle();
        String expectedTitle = PageTitleText.REGISTER.title;

        assertEquals(expectedTitle, actualTitle,
                "При открытии страницы register титул не соответствует странице/не отображается");
    }

    @Test
    @DisplayName("Открыть страницу Log in")
    public void openLoginPage(){

    }
    @Test
    @DisplayName("Открыть страницу Log out")
    public void openLogoutPage(){

    }

    @Test
    @DisplayName("Кнопка Log out не отображается, если пользователь не авторизован")
    public void openLogoutNotVisibleWhenUserNotAuthPage(){

    }

    @Test
    @DisplayName("Кнопка Log in не отображается, если пользователь авторизован")
    public void openLoginNotVisibleWhenUserAuthPage(){

    }
}
