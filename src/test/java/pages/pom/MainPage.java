package pages.pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    //Кнопки в верхнем меню
    @FindBy(xpath = "//a[@href='/register']")
    public SelenideElement registerButton;

    @FindBy(xpath = "//a[@href='/login']")
    public SelenideElement loginButton;

    @FindBy(xpath = "//a[@href='/logout']")
    public SelenideElement logoutButton;

}
