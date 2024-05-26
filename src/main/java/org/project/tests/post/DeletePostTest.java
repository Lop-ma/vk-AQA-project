package org.project.tests.post;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.pages.UserPage;
import org.project.core.steps.LoginAndPostSteps;
import org.project.core.valueObjects.Post;
import org.project.tests.BaseTest;

public class DeletePostTest extends BaseTest {
    private final LoginAndPostSteps steps = new LoginAndPostSteps();
    private UserPage userPage;
    private Post post;

    @BeforeEach
    public void createMainPage() {
        post = steps.LoginAndPostNoteAndGoToUserPage();
        userPage = new UserPage();
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
