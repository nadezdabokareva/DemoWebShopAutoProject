package pages.pom;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {
    // Радиобаттон выбора пола
    public SelenideElement genderMale = $("#gender-male");
    public SelenideElement genderFemale = $("#gender-female");

    // Поля формы регистрации
    public SelenideElement firstNameInput = $("#FirstName");
    public SelenideElement lastNameInput = $("#LastName");
    public SelenideElement emailInput = $("#Email");
    public SelenideElement passwordInput = $("#Password");
    public SelenideElement confirmPasswordInput = $("#ConfirmPassword");

    // Кнопка регистрации
    public SelenideElement registerButton = $("#register-button");

    // Сообщения об ошибках
    public SelenideElement firstNameError = $("#FirstName-error");
    public SelenideElement lastNameError = $("#LastName-error");
    public SelenideElement emailError = $("#Email-error");
    public SelenideElement passwordError = $("#Password-error");
    public SelenideElement confirmPasswordError = $("#ConfirmPassword-error");

    // Сообщение об успешной регистрации
    public SelenideElement resultMessage = $(".result"); // например: "Your registration completed"

    //Титул страницы Регистрации
    public SelenideElement pageTitle = $(byText("Register"));

    public String getRegisterPageTitle(){

    }
    // Заполнение формы регистрации
    public RegisterPage fillForm(String gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        if (gender.equalsIgnoreCase("male")) {
            genderMale.click();
        } else if (gender.equalsIgnoreCase("female")) {
            genderFemale.click();
        }
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        confirmPasswordInput.setValue(confirmPassword);
        return this;
    }

    // Отправка формы
    public void clickRegisterButton() {
        registerButton.click();
    }
}
