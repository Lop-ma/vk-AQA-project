package org.project.tests.authorization;

import org.project.core.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.valueObjects.User;
import org.project.tests.BaseTest;

import static org.project.core.valueObjects.testDate.TestBot.useTestBot;

public class SuccessLoginTest extends BaseTest {
    private LoginPage loginPage;
    private User user;

    @BeforeEach
    public void createLoginPage() {
        loginPage = new LoginPage();
        user = useTestBot();
    }

    @Test
    @DisplayName("Test login to ok.ru with correct data")
    @Tag("login")
    public void testSuccessLogin() {
        String expectedResult = user.getName() + " " + user.getSurname();
        String actualResult = loginPage
                .successLogin(user)
                .getShouldHaveName();
        String errorMessage = "Login user failed";

        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }
}
