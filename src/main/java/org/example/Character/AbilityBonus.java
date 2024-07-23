package org.example.Character;

import java.util.Objects;

public class AbilityBonus {

    private String name;
    private int value;

    public AbilityBonus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbilityBonus that = (AbilityBonus) o;
        return value == that.value && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "AbilityBonus{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
