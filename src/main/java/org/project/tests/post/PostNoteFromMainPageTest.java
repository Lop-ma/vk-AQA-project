package org.project.tests.post;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.pages.MainPage;
import org.project.core.pages.UserPage;
import org.project.core.valueObjects.Post;
import org.project.tests.BeforeTestLogin;

import static org.project.core.valueObjects.testDate.TestPost.useTestPost;

public class PostNoteFromMainPageTest extends BeforeTestLogin {
    MainPage mainPage;
    UserPage userPage;
    Post post;

    @BeforeEach
    public void createMainPage() {
        mainPage = new MainPage();
        post = useTestPost();
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
        userPage = mainPage.goToUserPage();
        Selenide.refresh();
        userPage.deletePost(post);
    }
}
