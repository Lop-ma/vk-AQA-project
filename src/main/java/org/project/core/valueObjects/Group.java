package org.project.core.valueObjects;

import org.project.core.valueObjects.enums.GroupCategory;
import org.project.core.valueObjects.enums.GroupType;

public record Group(String name, GroupCategory category, GroupType type) {

}
