package org.project.tests.post;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.pages.MainPage;
import org.project.core.steps.LoginAndPostSteps;
import org.project.core.valueObjects.Post;
import org.project.tests.BaseTest;

public class PostNoteFromMainPageTest extends BaseTest {
    private final LoginAndPostSteps steps = new LoginAndPostSteps();
    private MainPage mainPage;
    private Post post;

    @BeforeEach
    public void createMainPage() {
        post = steps.LoginAndPreparePost();
        mainPage = new MainPage();
    }

    @Test
    @DisplayName("Test publish post with note from Main page")
    @Tag("post")
    public void testSuccessPublishPost() {
        String expectedResult = "Заметка опубликована";
        String actualResult = mainPage.postNoteFromMainPage(post);
        String errorMessage = "Post note from Main page failed";

        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }

    @AfterEach
    public void clearUserPage() {
        steps.GoToUserPageAndDeletePost(post);
    }
}
