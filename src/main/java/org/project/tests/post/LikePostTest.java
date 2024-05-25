package org.project.tests.post;

import com.codeborne.selenide.Selenide;
import org.project.core.pages.MainPage;
import org.project.core.pages.UserPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.valueObjects.Post;
import org.project.tests.BeforeTestLogin;

import static org.project.core.valueObjects.testDate.TestPost.useTestPost;

public class LikePostTest extends BeforeTestLogin {
    MainPage mainPage;
    Post post;
    UserPage userPage;

    @BeforeEach
    public void createMainPage() {
        mainPage = new MainPage();
        post = useTestPost();
        mainPage.postNoteFromMainPage(post);
        userPage = mainPage.goToUserPage();
        Selenide.refresh();
    }

    @Test
    @DisplayName("Test like post on User page")
    @Tag("post")
    @Tag("like")
    public void testSuccessPutLike() {
        boolean actualResult = userPage.likePost(post);
        String errorMessage = "Put like on last post user failed";

        Assertions.assertTrue(actualResult, errorMessage);
    }

    @AfterEach
    public void clearUserPage() {
        userPage.deletePost(post);
    }
}
