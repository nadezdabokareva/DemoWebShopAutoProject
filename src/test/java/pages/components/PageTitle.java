package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class PageTitle {
    private SelenideElement pageTitle = $(byClassName("page-title"));

    public String getPageTitle(){
        String pageTitleText = pageTitle.getText();
        return pageTitleText;
    }
}
