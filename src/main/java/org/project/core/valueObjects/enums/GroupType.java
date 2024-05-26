package org.project.core.valueObjects.enums;

public enum GroupType {
    PAGE ("Публичная или бизнес страница"),
    INTEREST ("Группа по интересам"),
    HAPPENING ("Мероприятие");

    private final String type;

    GroupType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return type;
    }
}
