package org.project.core.elements;

import org.openqa.selenium.By;
import org.project.core.loadable.LoadableElements;
import org.project.core.pages.GroupsPage;
import org.project.core.pages.UserPage;
import org.project.core.valueObjects.Post;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu extends LoadableElements {
    private static final By NAVIGATION_MENU = By.xpath(".//*[@role='navigation']/div");
    private static final By PUBLISH_BUTTON = By.xpath(".//button[@data-l='t,pf_dropdown']");
    private static final By PUBLISH_NOTE = By.xpath(".//span[@data-l='t,feed.posting.ui.input']");
    private static final By TO_USER_PAGE = By.xpath(".//*[@data-l='t,userPage']");
    private static final By TO_GROUPS_PAGE = By.xpath(".//*[@data-l='t,userAltGroup']");

    private static final String MENU_BLOCK_ON_NAVIGATION_MENU = "Block with menu should be enabled on navigation menu";
    private static final String BUTTON_TO_USER_PAGE_ON_NAVIGATION_MENU = "Button for go to User Page should be enabled on navigation menu";
    private static final String PUBLISH_BUTTON_FOR_POST_NOTE = "Publish button should be enabled for post note";
    private static final String PUBLISH_NOTE_BUTTON_FOR_POST_NOTE = "Publish note button should be enabled for post note";
    private static final String NAVIGATION_MENU_FOR_GO_TO_USER_PAGE = "Navigation menu should be enabled for go to User page";
    private static final String BUTTON_TO_USER_PAGE_FOR_GO_TO_USER_PAGE = "Button redirect to User page should be enabled for go to User page";
    private static final String NAVIGATION_MENU_FOR_GO_TO_GROUPS_PAGE = "Navigation menu should be enabled for go to Groups page";
    private static final String BUTTON_TO_GROUPS_PAGE_FOR_GO_TO_GROUPS_PAGE = "Button redirect to Groups page should be enabled for go to Groups page";

    public NavigationMenu() {
        this.check();
    }

    @Override
    public NavigationMenu check() {
        $(NAVIGATION_MENU)
                .shouldBe(enabled.because(MENU_BLOCK_ON_NAVIGATION_MENU))
                .$(TO_USER_PAGE)
                .shouldBe(enabled.because(BUTTON_TO_USER_PAGE_ON_NAVIGATION_MENU));
        return this;
    }

    public String postNote(Post post) {
        $(PUBLISH_BUTTON)
                .shouldBe(enabled.because(PUBLISH_BUTTON_FOR_POST_NOTE))
                .click();
        $(PUBLISH_NOTE)
                .shouldBe(enabled.because(PUBLISH_NOTE_BUTTON_FOR_POST_NOTE))
                .click();

        return new PostPublicationForm()
                .publishPost(post.text())
                .getShouldHavePostMessage();
    }

    public UserPage goToUserPage() {
        $(NAVIGATION_MENU)
                .shouldBe(enabled.because(NAVIGATION_MENU_FOR_GO_TO_USER_PAGE))
                .$(TO_USER_PAGE)
                .shouldBe(enabled.because(BUTTON_TO_USER_PAGE_FOR_GO_TO_USER_PAGE))
                .click();
        return new UserPage();
    }

    public GroupsPage goToGroupsPage() {
        $(NAVIGATION_MENU)
                .shouldBe(enabled.because(NAVIGATION_MENU_FOR_GO_TO_GROUPS_PAGE))
                .$(TO_GROUPS_PAGE)
                .shouldBe(enabled.because(BUTTON_TO_GROUPS_PAGE_FOR_GO_TO_GROUPS_PAGE))
                .click();
        return new GroupsPage();
    }
}
