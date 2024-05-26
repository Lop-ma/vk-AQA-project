package org.project.core.valueObjects.enums;

public enum GroupCategory {
    CARS ("Автомобили"),
    GARDENING ("Садоводство"),
    PLANETARIUM ("Планетарий");

    private final String category;

    GroupCategory(String category) {
        this.category = category;
    }

    public String getCategoryName() {
        return category;
    }
}
