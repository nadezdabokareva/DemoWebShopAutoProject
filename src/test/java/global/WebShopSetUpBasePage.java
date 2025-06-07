package global;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import pages.pom.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class WebShopSetUpBasePage {
    public static final String BASE_URL = System.getProperty("siteUrl");
    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void openBasePage(){
        Configuration.baseUrl = getBaseUrl();
        open("/", MainPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}
