package org.project.core.valueObjects.testDate;

import org.project.core.valueObjects.Group;
import org.project.core.valueObjects.enums.GroupCategory;
import org.project.core.valueObjects.enums.GroupType;

public class TestGroup {
    public static Group useTestGroup() {
        return new Group(
                "Лимон",
                GroupCategory.GARDENING,
                GroupType.PAGE
        );
    }
}
