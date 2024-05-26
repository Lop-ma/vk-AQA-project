package org.project.tests.groups;

import org.project.core.pages.GroupPage;
import org.project.core.pages.GroupsPage;
import org.project.core.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.valueObjects.Group;
import org.project.core.valueObjects.enums.GroupCategory;
import org.project.core.valueObjects.enums.GroupType;
import org.project.tests.BeforeTestLogin;

public class CreatePageGroupTest extends BeforeTestLogin {

    Group group;
    GroupsPage groupsPage;
    GroupPage groupPage;
    String groupName;

    @BeforeEach
    public void createMainPage() {
        groupName = "Best group about cars";
        groupsPage = new MainPage()
                .goToGroupsPage();
        group = new Group(
                groupName,
                GroupCategory.CARS,
                GroupType.PAGE
        );
    }

    @Test
    @DisplayName("Test create group with type Page")
    @Tag("group")
    public void testCreatePageGroup() {
        groupPage = groupsPage
                .clickButtonCreateGroup(group)
                .chooseTypeGroup()
                .createGroup();

        String actualResult = groupPage
                .getGroupName();
        String errorMessage = "Create group with type Page failed";
        Assertions.assertEquals(groupName, actualResult, errorMessage);
    }

    @AfterEach
    public void returnOldName() {
        groupPage.deleteGroup();
    }
}

