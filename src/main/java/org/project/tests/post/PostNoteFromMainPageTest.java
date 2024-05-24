package org.project.tests.post;

import org.project.core.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.tests.BeforeTestLogin;

public class PostNoteFromMainPageTest extends BeforeTestLogin {
    MainPage mainPage;

    @BeforeEach
    public void createMainPage() {
        mainPage = new MainPage();
    }

    @Test
    @DisplayName("Test publish post with note from Main page")
    @Tag("post")
    public void testSuccessPublishPost() {
        String expectedResult = "Заметка опубликована";
        String actualResult = mainPage.postNoteFromMainPage();
        String errorMessage = "Post note from Main page failed";

        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }
}
