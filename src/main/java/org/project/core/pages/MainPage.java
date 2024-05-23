package org.project.core.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private static final By ACTIVE_MENU_FEED = By.xpath(".//a[@data-l='t,userMain' and contains(@class, 'ac')]");
    private static final By MOMENTS = By.xpath(".//button[@data-l='t,to_moments']");
    private static final By HOBBIES = By.xpath(".//button[@data-l='t,to_hobbies']");
    private static final By USER_AVATAR = By.xpath(".//div[@id='hook_Block_Avatar']");
    private static final By FRIENDS_ONLINE = By.xpath(".//div[@id='online-fr_block']");
    private static final By USER_NAME = By.xpath(".//a[@data-l='t,userPage']");

    private static final String MENU_FEED_ON_MAIN_PAGE = "Feed button should be enabled and active on Main page";
    private static final String MOMENTS_ON_MAIN_PAGE = "Block with moments should be enabled on Main page";
    private static final String HOBBIES_ON_MAIN_PAGE = "Block with hobbies should be enabled on Main page";
    private static final String USER_AVATAR_ON_MAIN_PAGE = "User avatar should be enabled on Main page";
    private static final String FRIENDS_ONLINE_ON_MAIN_PAGE = "Block with friends online should be enabled on Main page";
    private static final String USER_NAME_FOR_GET_NAME = "User name should be enabled for get name";

    public MainPage() {
        this.checkPage();
    }

    @Override
    public MainPage checkPage() {
        $(ACTIVE_MENU_FEED).shouldBe(enabled.because(MENU_FEED_ON_MAIN_PAGE));
        $(MOMENTS).shouldBe(enabled.because(MOMENTS_ON_MAIN_PAGE));
        $(HOBBIES).shouldBe(enabled.because(HOBBIES_ON_MAIN_PAGE));
        $(USER_AVATAR).shouldBe(enabled.because(USER_AVATAR_ON_MAIN_PAGE));
        $(FRIENDS_ONLINE).shouldBe(enabled.because(FRIENDS_ONLINE_ON_MAIN_PAGE));
        return this;
    }

    public String getShouldHaveName() {
        return $(USER_NAME).shouldHave(visible.because(USER_NAME_FOR_GET_NAME)).getText();
    }
}