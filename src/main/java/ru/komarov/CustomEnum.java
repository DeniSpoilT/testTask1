package ru.komarov;

import java.util.HashMap;
import java.util.Map;

public final class CustomEnum {
    private final String name;
    private final int ordinal;
    private static int ordinalCount = 0;
    private static final Map<Integer, CustomEnum> values = new HashMap();

    public CustomEnum(String name) {
        this.name = name;
        ordinal = ordinalCount++;
        values.put(ordinal, this);
    }

    public String name() {
        return this.name;
    }

    public int ordinal() {
        return this.ordinal;
    }

    public static String[] values() {
        return values.values().stream()
                .map(currentEnum -> currentEnum.name())
                .toArray(String[]::new);

    }

    public static CustomEnum valueOf(String name) {
        for (CustomEnum customEnum: values.values()){
            if(customEnum.name().equals(name)){
                return customEnum;
            }
        }
        throw new RuntimeException("No enum constant " + name);
    }

    public static CustomEnum valueOf(int ordinal){
        try {
           return values.get(ordinal);
        } catch (Exception e) {
            throw new RuntimeException("No enum constant with " + ordinal);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
