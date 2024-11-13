# D&D Character Creator Console App

**A console-based character creator for Dungeons & Dragons sessions.** This application allows you to fully customize your character by setting specific attributes, bonuses, and other game-relevant details.

## Features
- Create custom D&D characters with detailed attributes and bonuses.
- Specify attributes like Strength, Dexterity, Intelligence, and other core D&D stats.
- Calculate character bonuses based on chosen attributes.
- Easily modify and view your character details within the console.
- Lightweight and fully runnable from the command line—no additional dependencies required!

## Installation
To use this application, follow these steps:
1. Clone this repository:
   ```bash
   git clone https://github.com/Mefjuu94/D-D.git
   ```
2. Navigate to the project directory:
   ```bash
   cd D-D
   ```
3. Install dependencies and build the project: This project uses Gradle to manage dependencies. To download and install all necessary libraries, use the following command:
   ```bash
   ./gradlew build
   ```
   This command will:

a. Download all dependencies specified in the build.gradle file (e.g., JUnit, Mockito, Jackson).

b. Compile the source code.

c. Run tests if any are configured to do so automatically.

4. Run the application: Once the dependencies are installed and the project is built, you can run the application with:
   ```bash
   ./gradlew run
   ```

 5. Run Tests: To run the tests separately, use:
   ```bash
   ./gradlew test
   ```

## Usage
1. Launch the application.
2. Follow the console prompts to create and customize your character.
3. Choose various attributes and enter values to shape your character's strengths and weaknesses.
4. Save your character details or adjust them as needed during gameplay.

### Example
Here's an example of how the character creation flow might look in the console:
```plaintext
Set name of your character:
Aldon
Names used: []
Select your Race:
0. dragonborn
1. dwarf
2. elf
3. gnome
4. half-elf
5. half-orc
6. halfling
7. human
8. tiefling
4
Your choice: half-elf
Select your Class:
0. barbarian
1. bard
2. cleric
3. druid
4. fighter
5. monk
6. paladin
7. ranger
8. rogue
9. sorcerer
10. warlock
11. wizard
9
Your choice: sorcerer

Select your (3) spells by number:
0. Burning Hands
1. Charm Person
2. Color Spray
3. Comprehend Languages
4. Detect Magic
5. Disguise Self
6. Expeditious Retreat
7. False Life
8. Feather Fall
9. Fog Cloud
10. Jump
11. Mage Armor
12. Magic Missile
13. Shield
14. Silent Image
15. Sleep
16. Thunderwave
0
Your choice: Burning Hands
Select next Spell
3
Your choice: Comprehend Languages
Select next Spell
6
Your choice: Expeditious Retreat
Select next Spell
What's your character backstory?
*MAX 300 AND MIN 3 SIGN!
Best backstory ever!
*character name: Aldon
*race: "Half-Elf"
*race bonuses: 
- CHA | value: 2
*speed: 30
*size: "Medium"
*languages: Common, Elvish
*race proficiencies: none
*backstory:
Best backstory ever!
*features: 
- Draconic Resilience
- Dragon Ancestor
- Dragon Ancestor: Black - Acid Damage
- Dragon Ancestor: Blue - Lightning Damage
- Dragon Ancestor: Brass - Fire Damage
- Dragon Ancestor: Bronze - Lightning Damage
- Dragon Ancestor: Copper - Acid Damage
- Dragon Ancestor: Gold - Fire Damage
- Dragon Ancestor: Green - Poison Damage
- Dragon Ancestor: Red - Fire Damage
- Dragon Ancestor: Silver - Cold Damage
- Dragon Ancestor: White - Cold Damage
- Sorcerous Origin
- Spellcasting: Sorcerer
*class name: "Sorcerer"
*class skills: 
- Arcana
- Deception
- Insight
- Intimidation
- Persuasion
- Religion
*class proficiencies: 
- Daggers
- Darts
- Slings
- Quarterstaffs
- Crossbows, light
- Saving Throw: CON
- Saving Throw: CHA
*starting equipment: 
- Dagger | quantity: 2
*spells: 
- Burning Hands
- Comprehend Languages
- Expeditious Retreat

```

## Character Attributes
Each character has several core attributes that define their abilities in-game:

• Strength,	measuring	physical	power

• Dexterity, measuring	agility

• Constitution,	measuring	endurance

• Intelligence,	measuring	reasoning	and	memory

• Wisdom,	measuring	perception	and	insight

• Charisma,	measuring	force	of	personality

Bonuses and special abilities are calculated based on these attributes.
