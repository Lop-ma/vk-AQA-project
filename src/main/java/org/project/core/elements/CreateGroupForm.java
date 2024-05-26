package org.project.core.elements;

import org.openqa.selenium.By;
import org.project.core.loadable.LoadableElements;
import org.project.core.pages.GroupPage;
import org.project.core.valueObjects.Group;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CreateGroupForm extends LoadableElements {
    private static final By CREATE_FORM = By.xpath(".//*[@class='modal-new_center']");
    private static final By CREATE_BUTTON = By.xpath(".//*[@name='button_create']");
    private static final By CLOSE_BUTTON = By.xpath(".//*[@id='nohook_modal_close']");
    private static final By NAME_INPUT = By.xpath(".//*[@id='field_name']");
    private static final By SELECT_CATEGORY = By.xpath(".//div[@data-module='GroupCategorySelect']/.//*[contains(@class, 'svg-ic')]");

    private static final String START_CATEGORY_LOCATOR = ".//div[contains(@class, 'tree') and @data-value='";
    private static final String END_CATEGORY_LOCATOR = "']";

    private static final String CREATE_FORM_ON_CREATE_GROUP_FORM = "Create form should be enabled on create group form";
    private static final String CREATE_BUTTON_ON_CREATE_GROUP_FORM = "Button create group should be visible on create group form";
    private static final String CLOSE_BUTTON_ON_CREATE_GROUP_FORM = "Clos button should be enabled on create group form";
    private static final String NAME_INPUT_FOR_SET_GROUP_NAME = "Name input should be enabled for set group name";
    private static final String SELECT_CATEGORY_FOR_SET_GROUP_CATEGORY = "Select category button should be enabled for set group category";
    private static final String CATEGORY_FOR_SET_GROUP_CATEGORY = "Block with category should be enabled for set group category";
    private static final String CREATE_BUTTON_FOR_CREATE_GROUP = "Button create group should be enabled for create group";

    private final Group group;

    public CreateGroupForm(Group group) {
        this.group = group;
        this.check();
    }

    public CreateGroupForm check() {
        $(CREATE_FORM)
                .shouldBe(enabled.because(CREATE_FORM_ON_CREATE_GROUP_FORM));
        $(CREATE_BUTTON)
                .shouldBe(visible.because(CREATE_BUTTON_ON_CREATE_GROUP_FORM));
        $(CLOSE_BUTTON)
                .shouldBe(enabled.because(CLOSE_BUTTON_ON_CREATE_GROUP_FORM));
        return this;
    }

    public CreateGroupForm setGroupName() {
        $(NAME_INPUT)
                .shouldBe(enabled.because(NAME_INPUT_FOR_SET_GROUP_NAME))
                .setValue(group.name());
        return this;
    }

    public CreateGroupForm setGroupCategory() {
        $(SELECT_CATEGORY)
                .shouldBe(enabled.because(SELECT_CATEGORY_FOR_SET_GROUP_CATEGORY))
                .hover()
                .click();
        $(By.xpath(START_CATEGORY_LOCATOR + group.category().getCategoryName() + END_CATEGORY_LOCATOR))
                .shouldBe(enabled.because(CATEGORY_FOR_SET_GROUP_CATEGORY))
                .click();
        return this;
    }

    public GroupPage clickCreateGroup() {
        $(CREATE_BUTTON)
                .shouldBe(enabled.because(CREATE_BUTTON_FOR_CREATE_GROUP))
                .click();
        return new GroupPage();
    }

    public GroupPage createGroup() {
        return this
                .setGroupName()
                .setGroupCategory()
                .clickCreateGroup();
    }
}
