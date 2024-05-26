package org.project.core.pages;

import org.openqa.selenium.By;
import org.project.core.loadable.LoadableElements;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupSettingsPage extends LoadableElements {

    private static final By GROUP_SETTINGS_MAIN = By.xpath(".//div[contains(@id, 'GroupSettingsMain')]");
    private static final By GROUP_SETTINGS_HEADER = By.xpath(".//div[contains(@id, 'GroupNavHeader')]");
    private static final By GROUP_SETTINGS_CATALOG = By.xpath(".//div[contains(@id, 'RightColumnAltGroupSettingsCatalog')]");
    private static final By INPUT_NAME = By.xpath(".//input[@id='field_name']");
    private static final By SELECT_CATEGORY = By.xpath(".//div[@data-module='GroupCategorySelect']/.//*[contains(@class, 'svg')]");

    private static final By SAVE_SETTINGS = By.xpath(".//*[@name='button_save_settings']");
    private static final By CANCEL_CHANGE = By.xpath(".//a[contains(@class, 'button-pro') and contains(text(), 'Отменить')]");

    private static final String START_CATEGORY_LOCATOR = ".//div[contains(@class, 'tree') and @data-value='";
    private static final String END_CATEGORY_LOCATOR = "']";

    private static final String GROUP_SETTINGS_MAIN_ON_GROUP_SETTINGS_PAGE = "";
    private static final String GROUP_SETTINGS_HEADER_ON_GROUP_SETTINGS_PAGE = "";
    private static final String GROUP_SETTINGS_CATALOG_ON_GROUP_SETTINGS_PAGE = "";
    private static final String INPUT_NAME_FOR_RENAME_GROUP = "";
    private static final String SELECT_CATEGORY_FOR_CHANGE_CATEGORY = "";
    private static final String CATEGORY_FOR_CHANGE_CATEGORY = "";
    private static final String SAVE_SETTINGS_BUTTON_FOR_SAVE_SETTINGS = "";
    private static final String CANCEL_CHANGE_FOR_CLOSE_SETTINGS = "";

    public GroupSettingsPage() {
        this.check();
    }

    @Override
    public GroupSettingsPage check() {
        $(GROUP_SETTINGS_MAIN)
                .shouldBe(enabled.because(GROUP_SETTINGS_MAIN_ON_GROUP_SETTINGS_PAGE));
        $(GROUP_SETTINGS_HEADER)
                .shouldBe(visible.because(GROUP_SETTINGS_HEADER_ON_GROUP_SETTINGS_PAGE));
        $(GROUP_SETTINGS_CATALOG)
                .shouldBe(enabled.because(GROUP_SETTINGS_CATALOG_ON_GROUP_SETTINGS_PAGE));
        return this;
    }

    public GroupSettingsPage renameGroup(String newName) {
        $(INPUT_NAME)
                .shouldBe(enabled.because(INPUT_NAME_FOR_RENAME_GROUP))
                .doubleClick()
                .setValue(newName);
        return this;
    }

    public GroupSettingsPage changeCategory(String newCategory) {
        $(SELECT_CATEGORY)
                .shouldBe(enabled.because(SELECT_CATEGORY_FOR_CHANGE_CATEGORY))
                .click();
        $(By.xpath(START_CATEGORY_LOCATOR + newCategory + END_CATEGORY_LOCATOR))
                .shouldBe(enabled.because(CATEGORY_FOR_CHANGE_CATEGORY))
                .click();
        return this;
    }

    public GroupSettingsPage saveSettings() {
        $(SAVE_SETTINGS)
                .shouldBe(enabled.because(SAVE_SETTINGS_BUTTON_FOR_SAVE_SETTINGS))
                .click();
        return this;
    }

    public GroupPage closeSettings() {
        $(CANCEL_CHANGE)
                .shouldBe(enabled.because(CANCEL_CHANGE_FOR_CLOSE_SETTINGS))
                .click();
        return new GroupPage();
    }
}
