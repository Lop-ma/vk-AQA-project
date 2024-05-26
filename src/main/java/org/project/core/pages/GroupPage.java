package org.project.core.pages;

import org.openqa.selenium.By;
import org.project.core.loadable.LoadableElements;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends LoadableElements {
    private static final By GROUP_AVATAR = By.xpath(".//div[@class='entity-avatar']");
    private static final By GROUP_NAME = By.xpath(".//div[@class='group-name_t']");
    private static final By GROUP_CATEGORY = By.xpath(".//div[@class='group-name_info']");
    private static final By GROUP_FEED = By.xpath(".//div[@class='group-feed']");
    private static final By THREE_DOT_MENU = By.xpath(".//button[contains(@class, 'u-menu_a toggle-dropdown')]/*");
    private static final By GROUP_SETTINGS = By.xpath(".//a[@class='u-menu_a ' and text()='Настройки']");
    private static final By DELETE_GROUP = By.xpath(".//a[@class='u-menu_a ' and text()='Удалить']");
    private static final By CONFIRM_DELETE_BUTTON = By.xpath(".//input[@name='button_delete']");

    private static final String GROUP_AVATAR_ON_GROUP_PAGE = "Group avatar should be enabled on group page";
    private static final String GROUP_NAME_ON_GROUP_PAGE = "Group name should be visible on group page";
    private static final String GROUP_CATEGORY_ON_GROUP_PAGE = "Group category should be visible on group page";
    private static final String GROUP_FEED_ON_GROUP_PAGE = "Group feed should be enabled on group page";
    private static final String THREE_DOT_MENU_FOR_OPEN_MENU = "Three dot menu button should be enabled for open menu";
    private static final String DELETE_GROUP_BUTTON_FOR_DELETE_GROUP = "Delete group button should be enabled for delete group";
    private static final String CONFIRM_DELETE_BUTTON_FOR_CONFIRM_DELETE = "Confirm delete button should be enabled for confirm delete";
    private static final String GROUP_SETTINGS_FOR_OPEN_SETTINGS = "Group settings button should be enabled for open settings";
    private static final String GROUP_NAME_FOR_GET_NAME = "Group name should be visible for get group name";
    private static final String GROUP_CATEGORY_FOR_GET_CATEGORY = "Group category should be visible for get group category";

    public GroupPage() {
        this.check();
    }

    @Override
    public GroupPage check() {
        $(GROUP_AVATAR)
                .shouldBe(enabled.because(GROUP_AVATAR_ON_GROUP_PAGE));
        $(GROUP_NAME)
                .shouldBe(visible.because(GROUP_NAME_ON_GROUP_PAGE));
        $(GROUP_CATEGORY)
                .shouldBe(visible.because(GROUP_CATEGORY_ON_GROUP_PAGE));
        $(GROUP_FEED)
                .shouldBe(enabled.because(GROUP_FEED_ON_GROUP_PAGE));
        return this;
    }

    private GroupPage openMenu() {
        $(THREE_DOT_MENU)
                .shouldBe(enabled.because(THREE_DOT_MENU_FOR_OPEN_MENU))
                .hover()
                .click();
        return this;
    }

    private GroupPage clickDeleteGroup() {
        $(DELETE_GROUP)
                .shouldBe(enabled.because(DELETE_GROUP_BUTTON_FOR_DELETE_GROUP))
                .click();
        return this;
    }

    private void confirmDelete() {
        $(CONFIRM_DELETE_BUTTON)
                .shouldBe(enabled.because(CONFIRM_DELETE_BUTTON_FOR_CONFIRM_DELETE))
                .click();
    }

    private GroupSettingsPage openSettings() {
        $(GROUP_SETTINGS)
                .shouldBe(enabled.because(GROUP_SETTINGS_FOR_OPEN_SETTINGS))
                .click();
        return new GroupSettingsPage();
    }

    public GroupPage changeGroupName(String newName) {
        return this
                .openMenu()
                .openSettings()
                .renameGroup(newName)
                .saveSettings()
                .closeSettings();
    }

    public GroupPage changeGroupCategory(String newCategory) {
        return this
                .openMenu()
                .openSettings()
                .changeCategory(newCategory)
                .saveSettings()
                .closeSettings();
    }

    public String getGroupName() {
        return $(GROUP_NAME)
                .shouldBe(visible.because(GROUP_NAME_FOR_GET_NAME))
                .getText();
    }

    public String getGroupCategory() {
        return $(GROUP_CATEGORY)
                .shouldBe(visible.because(GROUP_CATEGORY_FOR_GET_CATEGORY))
                .getText();
    }

    public void deleteGroup() {
        this
                .openMenu()
                .clickDeleteGroup()
                .confirmDelete();
    }
}
