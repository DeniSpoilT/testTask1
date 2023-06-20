package ru.komarov;

import java.util.*;

public final class CustomEnum {
    public static final String NO_ENUM_FOR_NAME = "No enum constant for name: ";
    public static final String NO_ENUM_FOR_ORDINAL = "No enum constant with ordinal: ";
    private final String name;
    private final int ordinal;
    private static int ordinalCount = 0;
    private static final List<CustomEnum> values = new ArrayList<>();

    public CustomEnum(String name) {
        this.name = name;
        ordinal = ordinalCount++;
        values.add(this);
    }

    public String name() {
        return this.name;
    }

    public int ordinal() {
        return this.ordinal;
    }

    public static CustomEnum[] values() {
        return values.toArray(CustomEnum[]::new);
    }

    public static CustomEnum valueOf(String name) {
        for (CustomEnum customEnum : values) {
            if (customEnum.name().equals(name)) {
                return customEnum;
            }
        }
        throw new RuntimeException(NO_ENUM_FOR_NAME + name);
    }

    public static CustomEnum valueOf(int ordinal) {
        try {
            return values.get(ordinal);
        } catch (Exception e) {
            throw new RuntimeException(NO_ENUM_FOR_ORDINAL + ordinal);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
