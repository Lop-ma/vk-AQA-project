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
import org.project.core.valueObjects.enums.GroupCategory;
import org.project.tests.BeforeTestLogin;

import static org.project.core.valueObjects.testDate.TestGroup.useTestGroup;

public class ChangeGroupCategoryTest extends BeforeTestLogin {

    Group group;
    GroupPage groupPage;
    String oldCategory;

    @BeforeEach
    public void createMainPage() {
        group = useTestGroup();
        groupPage = new MainPage()
                .goToGroupsPage()
                .openMyGroups()
                .findAndOpenGroup(group);
        oldCategory = groupPage.getGroupCategory();
    }

    @Test
    @DisplayName("Test change category existing group")
    @Tag("group")
    public void testChangeGroupCategory() {
        String newCategory = GroupCategory.PLANETARIUM.getCategoryName();

        String actualResult = groupPage
                .changeGroupCategory(newCategory)
                .getGroupCategory();
        String errorMessage = "Change group category failed";
        Assertions.assertEquals(newCategory, actualResult, errorMessage);
    }

    @AfterEach
    public void returnOldName() {
        groupPage.changeGroupCategory(oldCategory);
    }
}
