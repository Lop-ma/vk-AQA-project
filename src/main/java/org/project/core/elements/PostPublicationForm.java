package org.project.core.elements;

import org.openqa.selenium.By;
import org.project.core.loadable.LoadableElements;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PostPublicationForm extends LoadableElements {
    private static final By POST_PUBLICATION_WINDOW = By.xpath(".//*[@id='mtLayerMain']");
    private static final By POST_BUTTON = By.xpath(".//*[@data-l='t,button.submit']");
    private static final By CLOSE_FORM_BUTTON = By.xpath(".//button[contains(@class, 'close-button')]");
    private static final By INPUT_FOR_NOTE = By.xpath(".//div[contains(@class, 'ok-posting-handler')]/div");
    private static final By PUBLICATION_MESSAGE = By.xpath(".//div[@class='tip-block_cnt']");

    private static final String PUBLICATION_WINDOW_ON_PUBLICATION_FORM = "Publication window should be enabled on publication form";
    private static final String POST_BUTTON_ON_PUBLICATION_FORM = "Post button should be visible on publication form";
    private static final String CLOSE_FORM_BUTTON_ON_PUBLICATION_FORM = "Close form button should be enabled on publication form";
    private static final String PUBLICATION_WINDOW_FOR_CLICK_INPUT = "Publication window should be enabled for click on input";
    private static final String INPUT_FOR_CLICK_INPUT = "Text input should be enabled for click on input";
    private static final String PUBLICATION_WINDOW_FOR_INPUT_TEXT = "Publication window should be enabled for input post text";
    private static final String INPUT_FOR_INPUT_TEXT = "Input should be enabled for input post text";
    private static final String PUBLICATION_WINDOW_FOR_POST_NOTE = "Publication window should be enabled for post note";
    private static final String POST_BUTTON_FOR_POST_NOTE = "Post button should be enabled for post note";
    private static final String PUBLICATION_MESSAGE_FOR_GET_MESSAGE = "Publication message should be visible for get message";

    public PostPublicationForm() {
        this.check();
    }

    @Override
    public PostPublicationForm check() {
        $(POST_PUBLICATION_WINDOW)
                .shouldBe(enabled.because(PUBLICATION_WINDOW_ON_PUBLICATION_FORM))
                .$(POST_BUTTON)
                .shouldBe(visible.because(POST_BUTTON_ON_PUBLICATION_FORM));
        $(CLOSE_FORM_BUTTON)
                .shouldBe(enabled.because(CLOSE_FORM_BUTTON_ON_PUBLICATION_FORM));
        return this;
    }

    public PostPublicationForm inputPostText(String textInPost) {
        $(POST_PUBLICATION_WINDOW)
                .shouldBe(enabled.because(PUBLICATION_WINDOW_FOR_CLICK_INPUT))
                .$(INPUT_FOR_NOTE)
                .shouldBe(enabled.because(INPUT_FOR_CLICK_INPUT))
                .click();
        $(POST_PUBLICATION_WINDOW)
                .shouldBe(enabled.because(PUBLICATION_WINDOW_FOR_INPUT_TEXT))
                .$(INPUT_FOR_NOTE)
                .shouldBe(enabled.because(INPUT_FOR_INPUT_TEXT))
                .setValue(textInPost);
        return this;
    }

    public PostPublicationForm clickPostButton() {
        $(POST_PUBLICATION_WINDOW)
                .shouldBe(enabled.because(PUBLICATION_WINDOW_FOR_POST_NOTE))
                .$(POST_BUTTON)
                .shouldBe(enabled.because(POST_BUTTON_FOR_POST_NOTE))
                .click();
        return this;
    }

    public PostPublicationForm publishPost(String textInPost) {
        return this
                .inputPostText(textInPost)
                .clickPostButton();
    }

    public String getShouldHavePostMessage() {
        return $(PUBLICATION_MESSAGE)
                .shouldBe(visible.because(PUBLICATION_MESSAGE_FOR_GET_MESSAGE))
                .getText();
    }
}
