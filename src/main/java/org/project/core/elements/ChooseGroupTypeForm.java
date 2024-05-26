package org.project.core.elements;

import org.openqa.selenium.By;
import org.project.core.loadable.LoadableElements;
import org.project.core.valueObjects.Group;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class ChooseGroupTypeForm extends LoadableElements {
    private static final By CREATE_PAGE = By.xpath(".//*[@data-l='t,PAGE']");
    private static final By CREATE_INTEREST = By.xpath(".//*[@data-l='t,INTEREST']");
    private static final By CREATE_HAPPENING = By.xpath(".//*[@data-l='t,HAPPENING']");

    private static final String CREATE_PAGE_BLOCK_ON_CHOOSE_GROUP_TYPE_FORM = "Create page block should be enabled on choose group type form";
    private static final String CREATE_INTEREST_ON_CHOOSE_GROUP_TYPE_FORM = "Create interest should be enabled on choose group type form";
    private static final String CREATE_HAPPENING_ON_CHOOSE_GROUP_TYPE_FORM = "Create happening should be enabled on choose group type form";
    private static final String CREATE_PAGE_FOR_CREATE_GROUP_PAGE = "Create page block should be enabled for create group page";
    private static final String CREATE_INTEREST_FOR_CREATE_GROUP_INTEREST = "Create interest should be enabled for create group interest";
    private static final String CREATE_HAPPENING_FOR_CREATE_GROUP_HAPPENING = "Create happening should be enabled for create group happening";

    private final Group group;

    public ChooseGroupTypeForm(Group group) {
        this.group = group;
        this.check();
    }

    public ChooseGroupTypeForm check() {
        $(CREATE_PAGE)
                .shouldBe(enabled.because(CREATE_PAGE_BLOCK_ON_CHOOSE_GROUP_TYPE_FORM));
        $(CREATE_INTEREST)
                .shouldBe(enabled.because(CREATE_INTEREST_ON_CHOOSE_GROUP_TYPE_FORM));
        $(CREATE_HAPPENING)
                .shouldBe(enabled.because(CREATE_HAPPENING_ON_CHOOSE_GROUP_TYPE_FORM));
        return this;
    }

    public CreateGroupForm chooseTypeGroup() {
        switch (group.type()) {
            case PAGE:
                $(CREATE_PAGE)
                        .shouldBe(enabled.because(CREATE_PAGE_FOR_CREATE_GROUP_PAGE))
                        .click();
                break;
            case INTEREST:
                $(CREATE_INTEREST)
                        .shouldBe(enabled.because(CREATE_INTEREST_FOR_CREATE_GROUP_INTEREST))
                        .click();
                break;
            case HAPPENING:
                $(CREATE_HAPPENING)
                        .shouldBe(enabled.because(CREATE_HAPPENING_FOR_CREATE_GROUP_HAPPENING))
                        .click();
                break;
        }
        return new CreateGroupForm(group);
    }
}
