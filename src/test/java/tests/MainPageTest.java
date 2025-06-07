package tests;

import global.WebShopSetUpBasePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты для главной страницы")
public class MainPageTest {

    @BeforeEach
    public void openBasePage(){
        WebShopSetUpBasePage.openBasePage();
    }

    @Test
    public void testConfig(){

    }
}
