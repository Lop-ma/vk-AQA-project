package org.project.core.pages;

import org.openqa.selenium.By;
import org.project.core.valueObjects.User;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final By INPUT_LOGIN = By.xpath(".//*[@id='field_email']");
    private static final By INPUT_PASSWORD = By.xpath(".//*[@id='field_password']");
    private static final By LOGIN_BUTTON = By.xpath(".//*[@data-l='t,sign_in']");
    private static final By ERROR_MESSAGE = By.xpath(".//div[@class='input-e login_error']");
    private static final String LOGIN = "technopol68";
    private static final String PASSWORD = "technopolisPassword";

    private static final String INPUT_LOGIN_ON_LOGIN_PAGE = "Login input field should be enabled on Login page";
    private static final String INPUT_LOGIN_SET_VALUE = "Login input field should be enabled for enter login";
    private static final String INPUT_PASSWORD_ON_LOGIN_PAGE = "Password input field should be enabled on Login page";
    private static final String INPUT_PASSWORD_SET_VALUE = "Password input field should be enabled for enter login";
    private static final String LOGIN_BUTTON_ON_LOGIN_PAGE = "Login button should be enabled on Login page";
    private static final String LOGIN_BUTTON_CLICK = "Login button should be enabled for click";
    private static final String ERROR_MESSAGE_GET_TEXT = "Error message should be enabled for get text";

    public LoginPage() {
        this.checkPage();
    }

    @Override
    public LoginPage checkPage() {
        $(INPUT_LOGIN).shouldBe(enabled.because(INPUT_LOGIN_ON_LOGIN_PAGE));
        $(INPUT_PASSWORD).shouldBe(enabled.because(INPUT_PASSWORD_ON_LOGIN_PAGE));
        $(LOGIN_BUTTON).shouldBe(enabled.because(LOGIN_BUTTON_ON_LOGIN_PAGE));
        return this;
    }

    public LoginPage login(User user) {
        $(INPUT_LOGIN).shouldBe(enabled.because(INPUT_LOGIN_SET_VALUE)).setValue(user.getLogin());
        $(INPUT_PASSWORD).shouldBe(enabled.because(INPUT_PASSWORD_SET_VALUE)).setValue(user.getPassword());
        $(LOGIN_BUTTON).shouldBe(enabled.because(LOGIN_BUTTON_CLICK)).click();
        return this;
    }

    public MainPage successLogin(User user) {
        this.login(user);
        return new MainPage();
    }

    public String getErrorLoginMessage(User user) {
        this.login(user);
        return $(ERROR_MESSAGE).shouldBe(enabled.because(ERROR_MESSAGE_GET_TEXT)).getText();
    }
}