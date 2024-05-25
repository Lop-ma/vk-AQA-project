package org.project.core.pages;

import org.openqa.selenium.By;
import org.project.core.elements.PostOnFeed;
import org.project.core.loadable.LoadableElements;
import org.project.core.valueObjects.Post;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class UserPage extends LoadableElements {
    private static final By PROFILE_USER_NAME = By.xpath(".//a[@class='profile-user-info_name']");
    private static final By USER_AVATAR = By.xpath(".//div[@class='entity-avatar']");
    private static final By ABOUT_USER = By.xpath(".//div[contains(@id, 'AboutUser')]");
    private static final By USER_FEED = By.xpath(".//div[@class='user-feed']");

    private static final String START_POST_LOCATOR = ".//*[@class='feed-w' and .//div[contains(text(), '";
    private static final String END_POST_LOCATOR = "')]]";

    private static final String PROFILE_USER_NAME_ON_USER_PAGE = "Profile user name should be enabled on User page";
    private static final String USER_AVATAR_ON_USER_PAGE = "User avatar should be enabled on User page";
    private static final String ABOUT_USER_ON_USER_PAGE = "Block about user should be enabled on User page";
    private static final String USER_FEED_ON_USER_PAGE = "User feed should be enabled on User page";

    public UserPage() {
        this.check();
    }

    @Override
    public UserPage check() {
        $(PROFILE_USER_NAME).shouldBe(visible.because(PROFILE_USER_NAME_ON_USER_PAGE));
        $(USER_AVATAR).shouldBe(enabled.because(USER_AVATAR_ON_USER_PAGE));
        $(ABOUT_USER).shouldBe(enabled.because(ABOUT_USER_ON_USER_PAGE));
        $(USER_FEED).shouldBe(enabled.because(USER_FEED_ON_USER_PAGE));
        return this;
    }

    public PostOnFeed findPost(Post post) {
        return new PostOnFeed(
                $(By.xpath(START_POST_LOCATOR + post.text() + END_POST_LOCATOR))
        );
    }

    public String deletePost(Post post) {
        return this
                .findPost(post)
                .deletePost()
                .getTextDeleteMessage();
    }

    public boolean likePost(Post post) {
        return this
                .findPost(post)
                .likePost()
                .shouldHaveLikeOnPost();
    }
}
