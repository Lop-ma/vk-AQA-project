package org.project.core.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.project.core.loadable.LoadableElements;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class PostOnFeed extends LoadableElements {
    private static final By POST_HEADER = By.xpath(".//*[@class='feed-header']");
    private static final By POST_MENU = By.xpath(".//*[@data-l='t,feed-actions-menu']");
    private static final By DELETE_POST_BUTTON = By.xpath(".//div[text()='Удалить заметку']");
    private static final By CONFIRM_DELETE = By.xpath(".//a[contains(@class, 'form-actions_yes')]");
    private static final By DELETE_MESSAGE = By.xpath(".//div[@class='delete-stub_ac']");
    private static final By LIKE_BUTTON = By.xpath(".//li[@data-widget-item-type='like']");
    private static final By ACTIVE_LIKE = By.xpath(".//span[@data-l='t,unlike']");

    private static final String BLOCK_WITH_POST_IN_POST = "Block with post should be enabled on post";
    private static final String POST_HEADER_IN_POST = "Post header should be enabled on post";
    private static final String POST_MENU_IN_POST = "Post menu should be enabled on post";
    private static final String POST_FOR_OPEN_MENU = "Post should be enabled for open post menu";
    private static final String POST_MENU_FOR_OPEN_MENU = "Block with post menu should be enabled for open post menu";
    private static final String POST_FOR_DELETE_POST = "Post should be enabled for delete post";
    private static final String DELETE_BUTTON_FOR_DELETE_POST = "Delete button should be enabled for delete post";
    private static final String POST_FOR_CONFIRM_DELETE = "Post should be enabled for confirm delete";
    private static final String CONFIRM_DELETE_BUTTON_FOR_CONFIRM_DELETE = "Confirm delete button should be enabled for confirm delete";
    private static final String POST_FOR_CHECK_DELETE = "Post should be enabled for check delete";
    private static final String DELETE_MESSAGE_FOR_CHECK_DELETE = "Delete message should be visible for check delete";
    private static final String POST_FOR_LIKE_POST = "Post should be enabled for like post";
    private static final String LIKE_BUTTON_FOR_LIKE_POST = "Like button should be enabled for like post";
    private static final String POST_FOR_CHECK_LIKE_POST = "Post should be enabled for check like post";
    private static final String ACTIVE_LIKE_FOR_CHECK_LIKE_POST = "Active like should be enabled for check like post";

    private final SelenideElement post;

    public PostOnFeed(SelenideElement post) {
        this.post = post;
        this.check();
    }

    @Override
    public PostOnFeed check() {
        post
                .shouldBe(enabled.because(BLOCK_WITH_POST_IN_POST))
                .$(POST_HEADER)
                .shouldBe(enabled.because(POST_HEADER_IN_POST));
        post
                .$(POST_MENU)
                .shouldBe(enabled.because(POST_MENU_IN_POST));
        return this;
    }

    public PostOnFeed deletePost() {
        post
                .shouldBe(enabled.because(POST_FOR_OPEN_MENU))
                .$(POST_MENU)
                .shouldBe(enabled.because(POST_MENU_FOR_OPEN_MENU))
                .hover();
        post
                .shouldBe(enabled.because(POST_FOR_DELETE_POST))
                .$(DELETE_POST_BUTTON)
                .shouldBe(enabled.because(DELETE_BUTTON_FOR_DELETE_POST))
                .click();
        post
                .shouldBe(enabled.because(POST_FOR_CONFIRM_DELETE))
                .$(CONFIRM_DELETE)
                .shouldBe(enabled.because(CONFIRM_DELETE_BUTTON_FOR_CONFIRM_DELETE))
                .click();
        return this;
    }

    public String getTextDeleteMessage() {
        return post
                .shouldBe(enabled.because(POST_FOR_CHECK_DELETE))
                .$(DELETE_MESSAGE)
                .shouldHave(visible.because(DELETE_MESSAGE_FOR_CHECK_DELETE))
                .getText();
    }

    public PostOnFeed likePost() {
        post
                .shouldBe(enabled.because(POST_FOR_LIKE_POST))
                .$(LIKE_BUTTON)
                .shouldBe(enabled.because(LIKE_BUTTON_FOR_LIKE_POST))
                .click();
        return this;
    }

    public boolean shouldHaveLikeOnPost() {
        post
                .shouldBe(enabled.because(POST_FOR_CHECK_LIKE_POST))
                .$(ACTIVE_LIKE)
                .shouldBe(enabled.because(ACTIVE_LIKE_FOR_CHECK_LIKE_POST));
        return true;
    }
}
