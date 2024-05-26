package org.project.core.pages;

import org.openqa.selenium.By;
import org.project.core.elements.ChooseGroupTypeForm;
import org.project.core.loadable.LoadableElements;
import org.project.core.valueObjects.Group;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends LoadableElements {
    private static final By GROUPS_CATALOG_HEADER = By.xpath(".//div[@class='groups-catalog-header']");
    private static final By GROUP_SEARCH_INPUT = By.xpath(".//group-search-input");
    private static final By RECOMMENDATIONS_CATALOG = By.xpath(".//div[@class='portlet groups-catalog']");
    private static final By HOLDER_BUTTON_MY = By.xpath(".//*[@id='my-groups-menu-holder']");
    private static final By MY_GROUPS_BUTTON = By.xpath(".//*[@id='hook_Block_ShortcutMenu']/.//*[contains(text(), 'Мои группы')]");
    private static final By CREATE_GROUP_BUTTON = By.xpath(".//*[contains(@href, 'UserGroups_createGroup')]");

    private static final String START_GROUP_LOCATOR = ".//div[@class='ugrid_i' and .//*[contains(text(), '";
    private static final String END_GROUP_LOCATOR = "')]]";

    private static final String GROUPS_CATALOG_HEADER_ON_GROUPS_PAGE = "";
    private static final String GROUP_SEARCH_INPUT_ON_GROUPS_PAGE = "";
    private static final String RECOMMENDATIONS_CATALOG_ON_GROUPS_PAGE = "";
    private static final String HOLDER_BUTTON_MY_FOR_OPEN_MY_GROUPS = "";
    private static final String MY_GROUPS_BUTTON_FOR_OPEN_MY_GROUPS = "";
    private static final String GROUP_CARD_FOR_OPEN_GROUP_PAGE = "";


    public GroupsPage() {
        this.check();
    }

    @Override
    public GroupsPage check() {
        $(GROUPS_CATALOG_HEADER)
                .shouldBe(enabled.because(GROUPS_CATALOG_HEADER_ON_GROUPS_PAGE));
        $(GROUP_SEARCH_INPUT)
                .shouldBe(visible.because(GROUP_SEARCH_INPUT_ON_GROUPS_PAGE));
        $(RECOMMENDATIONS_CATALOG)
                .shouldBe(enabled.because(RECOMMENDATIONS_CATALOG_ON_GROUPS_PAGE));
        return this;
    }

    public GroupsPage openMyGroups() {
        $(HOLDER_BUTTON_MY)
                .shouldBe(enabled.because(HOLDER_BUTTON_MY_FOR_OPEN_MY_GROUPS))
                .click();
        $(MY_GROUPS_BUTTON)
                .shouldBe(enabled.because(MY_GROUPS_BUTTON_FOR_OPEN_MY_GROUPS))
                .click();
        return this;
    }

    public GroupPage findAndOpenGroup(Group group) {
        $(By.xpath(START_GROUP_LOCATOR + group.getName() + END_GROUP_LOCATOR))
                .shouldBe(enabled.because(GROUP_CARD_FOR_OPEN_GROUP_PAGE))
                .click();
        return new GroupPage();
    }

    public ChooseGroupTypeForm clickButtonCreateGroup(Group group) {
        $(CREATE_GROUP_BUTTON)
                .shouldBe(enabled.because(GROUP_CARD_FOR_OPEN_GROUP_PAGE))
                .click();
        return new ChooseGroupTypeForm(group);
    }
}
