package org.example.Character;

import java.util.Objects;

public class Spell {

    private String spellName;

    public Spell(String spellName) {
        this.spellName = spellName;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spell spell = (Spell) o;
        return Objects.equals(spellName, spell.spellName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(spellName);
    }

    @Override
    public String toString() {
        return "Spells{" +
                "spellName='" + spellName + '\'' +
                '}';
    }
}
