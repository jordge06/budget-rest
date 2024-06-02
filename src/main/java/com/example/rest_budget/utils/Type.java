package com.example.rest_budget.utils;

public enum Type {

    FOOD(1, "Food"),
    BILLS(2, "Bills"),
    ALLOWANCE(3, "Allowance"),
    OTHERS(4, "Others");

    private final int id;
    private final String name;

    Type(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Type getById(int id) {
        for (Type type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with id " + id);
    }

    public static Type getByName(String name) {
        for (Type type : values()) {
            if (type.name.equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with name " + name);
    }
}
