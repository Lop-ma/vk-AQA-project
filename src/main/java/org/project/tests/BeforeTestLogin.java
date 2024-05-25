package org.project.tests;

import org.junit.jupiter.api.BeforeEach;
import org.project.core.pages.LoginPage;
import org.project.core.valueObjects.User;

import static org.project.core.valueObjects.testDate.TestBot.useTestBot;

public class BeforeTestLogin extends BaseTest {
    LoginPage loginPage;
    User user;

    @BeforeEach
    public void UserLogin() {
        loginPage = new LoginPage();
        user = useTestBot();
        loginPage.successLogin(user);
    }
}
