package org.project.core.pages;

import org.openqa.selenium.By;
import org.project.core.loadable.LoadableElements;
import org.project.core.valueObjects.User;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends LoadableElements {
    private static final By INPUT_LOGIN = By.xpath(".//*[@id='field_email']");
    private static final By INPUT_PASSWORD = By.xpath(".//*[@id='field_password']");
    private static final By LOGIN_BUTTON = By.xpath(".//*[@data-l='t,sign_in']");
    private static final By ERROR_MESSAGE = By.xpath(".//div[@class='input-e login_error']");

    private static final String INPUT_LOGIN_ON_LOGIN_PAGE = "Login input field should be enabled on Login page";
    private static final String INPUT_PASSWORD_ON_LOGIN_PAGE = "Password input field should be enabled on Login page";
    private static final String LOGIN_BUTTON_ON_LOGIN_PAGE = "Login button should be enabled on Login page";
    private static final String INPUT_LOGIN_FOR_SET_LOGIN = "Login input field should be enabled for set user login";
    private static final String INPUT_PASSWORD_FOR_SET_PASSWORD = "Password input field should be enabled for set user password";
    private static final String LOGIN_BUTTON_FOR_LOGIN_USER = "Login button should be enabled for login user";
    private static final String ERROR_MESSAGE_FOR_GET_ERROR_TEXT = "Error message should be enabled for get error text";

    public LoginPage() {
        this.check();
    }

    @Override
    public LoginPage check() {
        $(INPUT_LOGIN).shouldBe(enabled.because(INPUT_LOGIN_ON_LOGIN_PAGE));
        $(INPUT_PASSWORD).shouldBe(enabled.because(INPUT_PASSWORD_ON_LOGIN_PAGE));
        $(LOGIN_BUTTON).shouldBe(enabled.because(LOGIN_BUTTON_ON_LOGIN_PAGE));
        return this;
    }

    private LoginPage setLoginInLoginForm(User user) {
        $(INPUT_LOGIN)
                .shouldBe(enabled.because(INPUT_LOGIN_FOR_SET_LOGIN))
                .setValue(user.getLogin());
        return this;
    }

    private LoginPage setPasswordInLoginForm(User user) {
        $(INPUT_PASSWORD)
                .shouldBe(enabled.because(INPUT_PASSWORD_FOR_SET_PASSWORD))
                .setValue(user.getPassword());
        return this;
    }

    public LoginPage login(User user) {
        this
                .setLoginInLoginForm(user)
                .setPasswordInLoginForm(user);
        $(LOGIN_BUTTON)
                .shouldBe(enabled.because(LOGIN_BUTTON_FOR_LOGIN_USER))
                .click();
        return this;
    }

    public MainPage successLogin(User user) {
        this.login(user);
        return new MainPage();
    }

    public String getErrorLoginMessage(User user) {
        this.login(user);
        return $(ERROR_MESSAGE)
                .shouldBe(enabled.because(ERROR_MESSAGE_FOR_GET_ERROR_TEXT))
                .getText();
    }
}