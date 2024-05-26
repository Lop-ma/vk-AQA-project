package org.project.core.steps;

import org.project.core.pages.GroupPage;
import org.project.core.pages.LoginPage;
import org.project.core.pages.MainPage;
import org.project.core.valueObjects.Group;
import org.project.core.valueObjects.User;
import org.project.core.valueObjects.enums.GroupCategory;
import org.project.core.valueObjects.enums.GroupType;

import static org.project.core.valueObjects.testDate.TestBot.useTestBot;
import static org.project.core.valueObjects.testDate.TestGroup.useTestGroup;

public class LoginAndGroupSteps {

    public GroupPage loginAndFindGroup() {
        User user = useTestBot();
        new LoginPage()
                .successLogin(user);

        Group group = useTestGroup();
        return new MainPage()
                .goToGroupsPage()
                .openMyGroups()
                .findAndOpenGroup(group);
    }

    public String loginAndFindGroupAndGetGroupCategory() {
        return this
                .loginAndFindGroup()
                .getGroupCategory();
    }

    public String loginAndFindGroupAndGetGroupName() {
        return this
                .loginAndFindGroup()
                .getGroupName();
    }

    public Group loginAndGoToGroupsPageAndReturnGroup(String groupName) {
        User user = useTestBot();
        new LoginPage()
                .successLogin(user);

        new MainPage()
                .goToGroupsPage();

        return new Group(
                groupName,
                GroupCategory.CARS,
                GroupType.PAGE
        );
    }

    public void deleteGroup() {
        new GroupPage()
                .deleteGroup();
    }

    public void changeGroupCategory(String category) {
        new GroupPage()
                .changeGroupCategory(category);
    }

    public void changeGroupName(String name) {
        new GroupPage()
                .changeGroupName(name);
    }
}
