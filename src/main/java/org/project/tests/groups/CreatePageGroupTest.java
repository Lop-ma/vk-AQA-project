package org.project.tests.groups;

import org.project.core.pages.GroupPage;
import org.project.core.pages.GroupsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.steps.LoginAndGroupSteps;
import org.project.core.valueObjects.Group;
import org.project.tests.BaseTest;

public class CreatePageGroupTest extends BaseTest {
    private final LoginAndGroupSteps steps = new LoginAndGroupSteps();
    private Group group;
    private GroupsPage groupsPage;
    private GroupPage groupPage;
    private String groupName;

    @BeforeEach
    public void createMainPage() {
        groupName = "Best group about cars";
        group = steps
                .loginAndGoToGroupsPageAndReturnGroup(groupName);
        groupsPage = new GroupsPage();
    }

    @Test
    @DisplayName("Test create group with type Page")
    @Tag("group")
    public void testCreatePageGroup() {
        groupPage = groupsPage
                .clickButtonCreateGroup(group)
                .chooseTypeGroup()
                .createGroup();

        String actualResult = groupPage.getGroupName();
        String errorMessage = "Create group with type Page failed";
        Assertions.assertEquals(groupName, actualResult, errorMessage);
    }

    @AfterEach
    public void returnOldName() {
        steps.deleteGroup();
    }
}

