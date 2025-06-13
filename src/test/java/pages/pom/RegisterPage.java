package pages.pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;

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
    public SelenideElement firstNameError = $(byText("First name is required."));
    public SelenideElement lastNameError = $(byText("Last name is required."));
    public SelenideElement emailError = $(byText("Email is required."));
    public SelenideElement passwordError = $(byText("Password is required."));
    public SelenideElement confirmPasswordError = $(byText("Confirm password is required."));
    public SelenideElement wrongEmailError = $(byText("Wrong email"));
    public SelenideElement passwordIncorrectError = $(byText("The password should have at least 6 characters."));
    public SelenideElement emailAlreadyExistError = $(byText("The specified email already exists"));
    public SelenideElement passwordsNotMatchError = $(byText(" The password and confirmation password do not match."));

    public SelenideElement resultMessage = $(".result");

    //Титул страницы Регистрации
    public SelenideElement pageTitle = $(byText("Register"));

    @DisplayName("Заполнить форму регистрации полными данными")
    public RegisterPage fillForm(String gender,
                                 String firstName,
                                 String lastName,
                                 String email,
                                 String password,
                                 String passwordConfirm) {
        if (gender.equalsIgnoreCase("male")) {
            genderMale.click();
        } else if (gender.equalsIgnoreCase("female")) {
            genderFemale.click();
        }
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        confirmPasswordInput.setValue(passwordConfirm);
        return this;
    }
    @DisplayName("Заполнить форму регистрации только обязательными полями)")
    public RegisterPage fillFormOnlyRequiredData(String firstName,
                                                 String lastName,
                                                 String email,
                                                 String password,
                                                 String passwordConfirm) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        confirmPasswordInput.setValue(passwordConfirm);
        return this;
    }

    @DisplayName("Отправить форму")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @DisplayName("Получить подтверждение, что регистрация успешно завершена")
    public String getRegistrationResult(){
        String  result = resultMessage.getText();
        return result;
    }

    @DisplayName("Проверить, что отображаются ошибки о том, что не заполнены обязательные поля")
    public boolean checkThatErrorsIsVisible(){
        firstNameError.shouldBe(Condition.visible);
        lastNameError.shouldBe(Condition.visible);
        emailError.shouldBe(Condition.visible);
        passwordError.shouldBe(Condition.visible);
        return true;
    }

    @DisplayName("Проверить, что отображаются ошибка Wrong email")
    public boolean wrongEmailErrorIsVisible(){
        wrongEmailError.shouldBe(Condition.visible);
        return true;
    }

    @DisplayName("Проверить, что отображается ошибка с некорректной длиной password")
    public boolean wrongPasswordErrorIsVisible(){
        passwordIncorrectError.shouldBe(Condition.visible);
        return true;
    }

    @DisplayName("Проверить, что отображается ошибка, что такой email уже зарегистрирован")
    public boolean emailAlreadyExist(){
        emailAlreadyExistError.shouldBe(Condition.visible);
        return true;
    }

    @DisplayName("Проверить, что отображается ошибка, когда пароли не совпадают")
    public boolean checkPasswordsNotMatchError(){
        passwordsNotMatchError.shouldBe(Condition.visible);
        return true;
    }
}
