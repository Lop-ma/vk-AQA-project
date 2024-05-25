package org.project.core.pages;

import org.openqa.selenium.By;
import org.project.core.elements.NavigationMenu;
import org.project.core.elements.PostPublicationForm;
import org.project.core.loadable.LoadableElements;
import org.project.core.valueObjects.Post;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends LoadableElements {
    private static final By ACTIVE_MENU_FEED = By.xpath(".//a[@data-l='t,userMain' and contains(@class, 'ac')]");
    private static final By MOMENTS = By.xpath(".//button[@data-l='t,to_moments']");
    private static final By HOBBIES = By.xpath(".//button[@data-l='t,to_hobbies']");
    private static final By USER_AVATAR = By.xpath(".//div[@id='hook_Block_Avatar']");
    private static final By FRIENDS_ONLINE = By.xpath(".//div[@id='online-fr_block']");
    private static final By USER_NAME = By.xpath(".//a[@data-l='t,userPage']");
    private static final By PUBLISH_BUTTON = By.xpath(".//button[@data-l='t,pf_dropdown']");
    private static final By PUBLISH_NOTE = By.xpath(".//span[@data-l='t,feed.posting.ui.input']");

    private static final String MENU_FEED_ON_MAIN_PAGE = "Feed button should be enabled and active on Main page";
    private static final String MOMENTS_ON_MAIN_PAGE = "Block with moments should be enabled on Main page";
    private static final String HOBBIES_ON_MAIN_PAGE = "Block with hobbies should be enabled on Main page";
    private static final String USER_AVATAR_ON_MAIN_PAGE = "User avatar should be enabled on Main page";
    private static final String FRIENDS_ONLINE_ON_MAIN_PAGE = "Block with friends online should be enabled on Main page";
    private static final String PUBLISH_BUTTON_FOR_POST_NOTE = "Publish button should be enabled for post note";
    private static final String PUBLISH_NOTE_BUTTON_FOR_POST_NOTE = "Publish note button should be enabled for post note";
    private static final String USER_NAME_FOR_GET_NAME = "Block with user name should be visible for get name";

    public MainPage() {
        this.check();
    }

    @Override
    public MainPage check() {
        $(ACTIVE_MENU_FEED).shouldBe(enabled.because(MENU_FEED_ON_MAIN_PAGE));
        $(MOMENTS).shouldBe(enabled.because(MOMENTS_ON_MAIN_PAGE));
        $(HOBBIES).shouldBe(enabled.because(HOBBIES_ON_MAIN_PAGE));
        $(USER_AVATAR).shouldBe(enabled.because(USER_AVATAR_ON_MAIN_PAGE));
        $(FRIENDS_ONLINE).shouldBe(enabled.because(FRIENDS_ONLINE_ON_MAIN_PAGE));
        return this;
    }

    public String postNoteFromMainPage(Post post) {
        $(PUBLISH_BUTTON)
                .shouldBe(enabled.because(PUBLISH_BUTTON_FOR_POST_NOTE))
                .click();
        $(PUBLISH_NOTE)
                .shouldBe(enabled.because(PUBLISH_NOTE_BUTTON_FOR_POST_NOTE))
                .click();

        return new PostPublicationForm()
                .publishPost(post.text())
                .getShouldHavePostMessage();
    }

    public String getShouldHaveName() {
        return $(USER_NAME)
                .shouldHave(visible.because(USER_NAME_FOR_GET_NAME))
                .getText();
    }

    public UserPage goToUserPage() {
        return new NavigationMenu()
                .goToUserPage();
    }
}