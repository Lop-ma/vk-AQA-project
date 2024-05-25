package org.project.tests.post;

import com.codeborne.selenide.Selenide;
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

public class DeletePostTest extends BeforeTestLogin {
    MainPage mainPage;
    UserPage userPage;
    Post post;

    @BeforeEach
    public void createMainPage() {
        post = useTestPost();
        mainPage = new MainPage();
        mainPage.postNoteFromMainPage(post);
        userPage = mainPage.goToUserPage();
        Selenide.refresh();
    }

    @Test
    @DisplayName("Test publish post with note from Main page")
    @Tag("post")
    public void testSuccessPublishPost() {
        String expectedResult = "Тема удалена";
        String actualResult = userPage.deletePost(post);
        String errorMessage = "Delete last post from User page failed";

        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }
}
