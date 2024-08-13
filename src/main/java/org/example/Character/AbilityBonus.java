package org.example.Character;

import java.util.Objects;

public class AbilityBonus {

    private String bonusName;
    private int value;

    public AbilityBonus(String bonusName, int value) {
        this.bonusName = bonusName;
        this.value = value;
    }

    public String getBonusName() {
        return bonusName;
    }

    public void setBonusName(String bonusName) {
        this.bonusName = bonusName;
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
        return value == that.value && Objects.equals(bonusName, that.bonusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusName, value);
    }

    @Override
    public String toString() {
        return "AbilityBonus{" +
                "bonusName='" + bonusName + '\'' +
                ", value=" + value +
                '}';
    }
}
