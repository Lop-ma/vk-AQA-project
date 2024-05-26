package org.project.tests.groups;

import org.project.core.pages.GroupPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.project.core.steps.LoginAndGroupSteps;
import org.project.core.valueObjects.enums.GroupCategory;
import org.project.tests.BaseTest;

public class ChangeGroupCategoryTest extends BaseTest {

    private final LoginAndGroupSteps steps = new LoginAndGroupSteps();
    GroupPage groupPage;
    String oldCategory;

    @BeforeEach
    public void createMainPage() {
        oldCategory = steps
                .loginAndFindGroupAndGetGroupCategory();
        groupPage = new GroupPage();
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
        steps.changeGroupCategory(oldCategory);
    }
}
