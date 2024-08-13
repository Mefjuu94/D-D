package org.example.Character.Mappers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.example.Character.AbilityBonus;

import java.util.ArrayList;
import java.util.List;

public class MapAbilityBonus {

    public List<AbilityBonus> mapAbilityBonus(ArrayNode node) {

        List<AbilityBonus> abilityBonuses = new ArrayList<>();

        Object[] bonusName = node.findValuesAsText("name").toArray();
        Object[] bonusValue = node.findValuesAsText("bonus").toArray();

        for (int i = 0; i < bonusName.length; i++) {
            String name = bonusName[i].toString();
            int value = Integer.parseInt(bonusValue[i].toString());
            abilityBonuses.add(new AbilityBonus(name, value));
        }

        return abilityBonuses;
    }

}
