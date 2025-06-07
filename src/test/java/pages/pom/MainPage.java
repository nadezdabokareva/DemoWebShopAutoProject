package pages.pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(xpath = "$(\"a[href='/register']\")")
    public SelenideElement registerButton;
    @FindBy(xpath = "$(\"a[href='/login']\")\n")
    public SelenideElement loginButton;
    @FindBy(xpath = "$(\"a[href='/logout']\")\n")
    public SelenideElement logoutButton;

}
