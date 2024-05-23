package org.project.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private static final String BASE_URL = "https://ok.ru/";
    private static final String BROWSER = "chrome";
    private static final String URL = "/";

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browser = BROWSER;
    }

    @BeforeEach
    public void open() {
        Selenide.open(URL);
    }

    @AfterEach
    public void close() {
        Selenide.closeWebDriver();
    }
}
