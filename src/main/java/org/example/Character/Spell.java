package org.example.Character;

public class Spell {

    String spellName;

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
    public String toString() {
        return "Spells{" +
                "spellName='" + spellName + '\'' +
                '}';
    }
}
