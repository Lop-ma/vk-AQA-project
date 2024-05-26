package org.project.core.steps;

import com.codeborne.selenide.Selenide;
import org.project.core.pages.LoginPage;
import org.project.core.pages.MainPage;
import org.project.core.pages.UserPage;
import org.project.core.valueObjects.Post;
import org.project.core.valueObjects.User;

import static org.project.core.valueObjects.testDate.TestBot.useTestBot;
import static org.project.core.valueObjects.testDate.TestPost.useTestPost;

public class LoginAndPostSteps {
    public Post LoginAndPreparePost() {
        User user = useTestBot();
        new LoginPage()
                .successLogin(user);

        return useTestPost();
    }

    public Post LoginAndPostNoteAndGoToUserPage() {
        Post post = LoginAndPreparePost();
        MainPage mainPage = new MainPage();
        mainPage
                .postNoteFromMainPage(post);
        mainPage
                .goToUserPage();
        Selenide.refresh();
        return post;
    }

    public void GoToUserPageAndDeletePost(Post post) {
        UserPage userPage = new MainPage()
                .goToUserPage();
        Selenide.refresh();
        userPage.deletePost(post);
    }

    public void DeletePost(Post post) {
        new UserPage()
                .deletePost(post);
    }
}
