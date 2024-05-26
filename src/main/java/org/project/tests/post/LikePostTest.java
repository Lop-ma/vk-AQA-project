package org.project.tests.post;

import org.project.core.pages.UserPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.steps.LoginAndPostSteps;
import org.project.core.valueObjects.Post;
import org.project.tests.BaseTest;

public class LikePostTest extends BaseTest {

    private final LoginAndPostSteps steps = new LoginAndPostSteps();

    Post post;
    UserPage userPage;

    @BeforeEach
    public void createMainPage() {
        post = steps.LoginAndPostNoteAndGoToUserPage();
        userPage = new UserPage();
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
        steps.DeletePost(post);
    }
}
