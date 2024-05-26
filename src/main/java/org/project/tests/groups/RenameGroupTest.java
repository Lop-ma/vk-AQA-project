package org.project.tests.groups;

import org.project.core.pages.GroupPage;
import org.project.core.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.valueObjects.Group;
import org.project.tests.BeforeTestLogin;

import static org.project.core.valueObjects.testDate.TestGroup.useTestGroup;

public class RenameGroupTest extends BeforeTestLogin {

    Group group;
    GroupPage groupPage;
    String oldName;

    @BeforeEach
    public void createMainPage() {
        group = useTestGroup();
        groupPage = new MainPage()
                .goToGroupsPage()
                .openMyGroups()
                .findAndOpenGroup(group);
        oldName = groupPage.getGroupName();
    }

    @Test
    @DisplayName("Test rename existing group")
    @Tag("group")
    public void testRenameGroup() {
        String newName = "NewName";
        if (oldName.equals(newName)) {
            newName = "SuperNewName";
        }

        String actualResult = groupPage
                .changeGroupName(newName)
                .getGroupName();
        String errorMessage = "Rename group failed";
        Assertions.assertEquals(newName, actualResult, errorMessage);
    }

    @AfterEach
    public void returnOldName() {
        groupPage.changeGroupName(oldName);
    }
}
