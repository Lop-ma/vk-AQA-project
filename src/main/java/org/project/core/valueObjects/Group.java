package org.project.core.valueObjects;

import org.project.core.valueObjects.enums.GroupCategory;
import org.project.core.valueObjects.enums.GroupType;

public class Group {

    private final String name;
    private final GroupCategory category;
    private final GroupType type;

    public Group(String name, GroupCategory category, GroupType type) {
        this.name = name;
        this.category = category;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public GroupCategory getCategory() {
        return category;
    }

    public GroupType getType() {
        return type;
    }
}
