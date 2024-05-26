package org.project.tests.groups;

import org.project.core.pages.GroupPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.steps.LoginAndGroupSteps;
import org.project.tests.BaseTest;

public class RenameGroupTest extends BaseTest {
    private final LoginAndGroupSteps steps = new LoginAndGroupSteps();
    private GroupPage groupPage;
    private String oldName;

    @BeforeEach
    public void createMainPage() {
        oldName = steps
                .loginAndFindGroupAndGetGroupName();
        groupPage = new GroupPage();
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
        steps.changeGroupName(oldName);
    }
}
