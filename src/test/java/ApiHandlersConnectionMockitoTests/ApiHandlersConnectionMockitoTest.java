import org.example.ApiServiceConnections.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ApiHandlersConnectionMockitoTest {

    public static final String URLProficences = "https://www.dnd5eapi.co/api/races/";

    @Mock
    private HttpResponse<String> response;
    @Mock
    private HttpClient client;
    @Mock
    private HttpRequest request;

    public void setResponse(String responseBody, int statusCode) {
        when(response.statusCode()).thenReturn(statusCode);
        lenient().when(response.body()).thenReturn(responseBody);
    }

    //**********Class Features Handler**********
    private ClassFeaturesHandler classFeaturesHandler;
    private final String classFeaturesResponseBody = "{\"count\":2,\"results\":[{\"index\":\"bardic-inspiration-d6\",\"name\":\"Bardic Inspiration (d6)\",\"url\":\"/api/features/bardic-inspiration-d6\"},{\"index\":\"spellcasting-bard\",\"name\":\"Spellcasting: Bard\",\"url\":\"/api/features/spellcasting-bard\"}]}\n";


    @Test
    public void response404() {
        setResponse("",404);
        classFeaturesHandler = new ClassFeaturesHandler(client);
        when(response.statusCode()).thenReturn(404);
        System.out.println(response.statusCode());

        Assertions.assertEquals(404, response.statusCode());
    }

    @Test
    public void happyPathToResponseFeaturesHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse(classFeaturesResponseBody, 200);
        request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[1] + "/levels/1/features")).GET().build();
        classFeaturesHandler = new ClassFeaturesHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertEquals(classFeaturesResponseBody, classFeaturesHandler.getClassFeatures(1).body());
    }

    @Test
    public void UnHappyPathToResponseFeaturesHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse("", 200);
        request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[1] + "/levels/1/features")).GET().build();
        classFeaturesHandler = new ClassFeaturesHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertNotEquals(classFeaturesResponseBody, classFeaturesHandler.getClassFeatures(1).body());
    }

    @Test
    public void UnHappyPathToResponseFeaturesHandlerBadIndex() throws IOException, InterruptedException, URISyntaxException {
        String otherAnswer = "{\"count\":8,\"results\":[{\"index\":\"fighter-fighting-style\",\"name\":\"Fighting Style\",\"url\":\"/api/features/fighter-fighting-style\"},{\"index\":\"fighter-fighting-style-archery\",\"name\":\"Fighting Style: Archery\",\"url\":\"/api/features/fighter-fighting-style-archery\"},{\"index\":\"fighter-fighting-style-defense\",\"name\":\"Fighting Style: Defense\",\"url\":\"/api/features/fighter-fighting-style-defense\"},{\"index\":\"fighter-fighting-style-dueling\",\"name\":\"Fighting Style: Dueling\",\"url\":\"/api/features/fighter-fighting-style-dueling\"},{\"index\":\"fighter-fighting-style-great-weapon-fighting\",\"name\":\"Fighting Style: Great Weapon Fighting\",\"url\":\"/api/features/fighter-fighting-style-great-weapon-fighting\"},{\"index\":\"fighter-fighting-style-protection\",\"name\":\"Fighting Style: Protection\",\"url\":\"/api/features/fighter-fighting-style-protection\"},{\"index\":\"fighter-fighting-style-two-weapon-fighting\",\"name\":\"Fighting Style: Two-Weapon Fighting\",\"url\":\"/api/features/fighter-fighting-style-two-weapon-fighting\"},{\"index\":\"second-wind\",\"name\":\"Second Wind\",\"url\":\"/api/features/second-wind\"}]}\n";
        setResponse(otherAnswer, 200);
        request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[2] + "/levels/1/features")).GET().build();
        classFeaturesHandler = new ClassFeaturesHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertNotEquals(classFeaturesResponseBody, classFeaturesHandler.getClassFeatures(2).body());
    }


    //**********Class Information Handler**********
    private final String classInformationResponseBody = "{\"index\":\"druid\",\"name\":\"Druid\",\"hit_die\":8,\"proficiency_choices\":[{\"desc\":\"Choose two from Arcana, Animal Handling, Insight, Medicine, Nature, Perception, Religion, and Survival\",\"choose\":2,\"type\":\"proficiencies\",\"from\":{\"option_set_type\":\"options_array\",\"options\":[{\"option_type\":\"reference\",\"item\":{\"index\":\"skill-arcana\",\"name\":\"Skill: Arcana\",\"url\":\"/api/proficiencies/skill-arcana\"}},{\"option_type\":\"reference\",\"item\":{\"index\":\"skill-animal-handling\",\"name\":\"Skill: Animal Handling\",\"url\":\"/api/proficiencies/skill-animal-handling\"}},{\"option_type\":\"reference\",\"item\":{\"index\":\"skill-insight\",\"name\":\"Skill: Insight\",\"url\":\"/api/proficiencies/skill-insight\"}},{\"option_type\":\"reference\",\"item\":{\"index\":\"skill-medicine\",\"name\":\"Skill: Medicine\",\"url\":\"/api/proficiencies/skill-medicine\"}},{\"option_type\":\"reference\",\"item\":{\"index\":\"skill-nature\",\"name\":\"Skill: Nature\",\"url\":\"/api/proficiencies/skill-nature\"}},{\"option_type\":\"reference\",\"item\":{\"index\":\"skill-perception\",\"name\":\"Skill: Perception\",\"url\":\"/api/proficiencies/skill-perception\"}},{\"option_type\":\"reference\",\"item\":{\"index\":\"skill-religion\",\"name\":\"Skill: Religion\",\"url\":\"/api/proficiencies/skill-religion\"}},{\"option_type\":\"reference\",\"item\":{\"index\":\"skill-survival\",\"name\":\"Skill: Survival\",\"url\":\"/api/proficiencies/skill-survival\"}}]}}],\"proficiencies\":[{\"index\":\"light-armor\",\"name\":\"Light Armor\",\"url\":\"/api/proficiencies/light-armor\"},{\"index\":\"medium-armor\",\"name\":\"Medium Armor\",\"url\":\"/api/proficiencies/medium-armor\"},{\"index\":\"shields\",\"name\":\"Shields\",\"url\":\"/api/proficiencies/shields\"},{\"index\":\"clubs\",\"name\":\"Clubs\",\"url\":\"/api/proficiencies/clubs\"},{\"index\":\"daggers\",\"name\":\"Daggers\",\"url\":\"/api/proficiencies/daggers\"},{\"index\":\"javelins\",\"name\":\"Javelins\",\"url\":\"/api/proficiencies/javelins\"},{\"index\":\"maces\",\"name\":\"Maces\",\"url\":\"/api/proficiencies/maces\"},{\"index\":\"quarterstaffs\",\"name\":\"Quarterstaffs\",\"url\":\"/api/proficiencies/quarterstaffs\"},{\"index\":\"sickles\",\"name\":\"Sickles\",\"url\":\"/api/proficiencies/sickles\"},{\"index\":\"spears\",\"name\":\"Spears\",\"url\":\"/api/proficiencies/spears\"},{\"index\":\"darts\",\"name\":\"Darts\",\"url\":\"/api/proficiencies/darts\"},{\"index\":\"slings\",\"name\":\"Slings\",\"url\":\"/api/proficiencies/slings\"},{\"index\":\"scimitars\",\"name\":\"Scimitars\",\"url\":\"/api/proficiencies/scimitars\"},{\"index\":\"herbalism-kit\",\"name\":\"Herbalism Kit\",\"url\":\"/api/proficiencies/herbalism-kit\"},{\"index\":\"saving-throw-int\",\"name\":\"Saving Throw: INT\",\"url\":\"/api/proficiencies/saving-throw-int\"},{\"index\":\"saving-throw-wis\",\"name\":\"Saving Throw: WIS\",\"url\":\"/api/proficiencies/saving-throw-wis\"}],\"saving_throws\":[{\"index\":\"int\",\"name\":\"INT\",\"url\":\"/api/ability-scores/int\"},{\"index\":\"wis\",\"name\":\"WIS\",\"url\":\"/api/ability-scores/wis\"}],\"starting_equipment\":[{\"equipment\":{\"index\":\"leather-armor\",\"name\":\"Leather Armor\",\"url\":\"/api/equipment/leather-armor\"},\"quantity\":1},{\"equipment\":{\"index\":\"explorers-pack\",\"name\":\"Explorer's Pack\",\"url\":\"/api/equipment/explorers-pack\"},\"quantity\":1}],\"starting_equipment_options\":[{\"desc\":\"(a) a wooden shield or (b) any simple weapon\",\"choose\":1,\"type\":\"equipment\",\"from\":{\"option_set_type\":\"options_array\",\"options\":[{\"option_type\":\"counted_reference\",\"count\":1,\"of\":{\"index\":\"shield\",\"name\":\"Shield\",\"url\":\"/api/equipment/shield\"}},{\"option_type\":\"choice\",\"choice\":{\"desc\":\"any simple weapon\",\"choose\":1,\"type\":\"equipment\",\"from\":{\"option_set_type\":\"equipment_category\",\"equipment_category\":{\"index\":\"simple-weapons\",\"name\":\"Simple Weapons\",\"url\":\"/api/equipment-categories/simple-weapons\"}}}}]}},{\"desc\":\"(a) a scimitar or (b) any simple melee weapon\",\"choose\":1,\"type\":\"equipment\",\"from\":{\"option_set_type\":\"options_array\",\"options\":[{\"option_type\":\"counted_reference\",\"count\":1,\"of\":{\"index\":\"scimitar\",\"name\":\"Scimitar\",\"url\":\"/api/equipment/scimitar\"}},{\"option_type\":\"choice\",\"choice\":{\"desc\":\"any simple melee weapon\",\"choose\":1,\"type\":\"equipment\",\"from\":{\"option_set_type\":\"equipment_category\",\"equipment_category\":{\"index\":\"simple-melee-weapons\",\"name\":\"Simple Melee Weapons\",\"url\":\"/api/equipment-categories/simple-melee-weapons\"}}}}]}},{\"desc\":\"druidic focus\",\"choose\":1,\"type\":\"equipment\",\"from\":{\"option_set_type\":\"equipment_category\",\"equipment_category\":{\"index\":\"druidic-foci\",\"name\":\"Druidic Foci\",\"url\":\"/api/equipment-categories/druidic-foci\"}}}],\"class_levels\":\"/api/classes/druid/levels\",\"multi_classing\":{\"prerequisites\":[{\"ability_score\":{\"index\":\"wis\",\"name\":\"WIS\",\"url\":\"/api/ability-scores/wis\"},\"minimum_score\":13}],\"proficiencies\":[{\"index\":\"light-armor\",\"name\":\"Light Armor\",\"url\":\"/api/proficiencies/light-armor\"},{\"index\":\"medium-armor\",\"name\":\"Medium Armor\",\"url\":\"/api/proficiencies/medium-armor\"},{\"index\":\"shields\",\"name\":\"Shields\",\"url\":\"/api/proficiencies/shields\"}]},\"subclasses\":[{\"index\":\"land\",\"name\":\"Land\",\"url\":\"/api/subclasses/land\"}],\"spellcasting\":{\"level\":1,\"spellcasting_ability\":{\"index\":\"wis\",\"name\":\"WIS\",\"url\":\"/api/ability-scores/wis\"},\"info\":[{\"name\":\"Cantrips\",\"desc\":[\"At 1st level, you know two cantrips of your choice from the druid spell list. You learn additional druid cantrips of your choice at higher levels, as shown in the Cantrips Known column of the Druid table.\"]},{\"name\":\"Preparing and Casting Spells\",\"desc\":[\"The Druid table shows how many spell slots you have to cast your spells of 1st level and higher. To cast one of these druid spells, you must expend a slot of the spell's level or higher. You regain all expended spell slots when you finish a long rest.\",\"You prepare the list of druid spells that are available for you to cast, choosing from the druid spell list. When you do so, choose a number of druid spells equal to your Wisdom modifier + your druid level (minimum of one spell). The spells must be of a level for which you have spell slots.\",\"For example, if you are a 3rd-level druid, you have four 1st-level and two 2nd-level spell slots. With a Wisdom of 16, your list of prepared spells can include six spells of 1st or 2nd level, in any combination. If you prepare the 1st-level spell cure wounds, you can cast it using a 1st-level or 2nd-level slot. Casting the spell doesn't remove it from your list of prepared spells.\",\"You can also change your list of prepared spells when you finish a long rest. Preparing a new list of druid spells requires time spent in prayer and meditation: at least 1 minute per spell level for each spell on your list.\"]},{\"name\":\"Spellcasting Ability\",\"desc\":[\"Wisdom is your spellcasting ability for your druid spells, since your magic draws upon your devotion and attunement to nature. You use your Wisdom whenever a spell refers to your spellcasting ability. In addition, you use your Wisdom modifier when setting the saving throw DC for a druid spell you cast and when making an attack roll with one.\",\"Spell save DC = 8 + your proficiency bonus + your Wisdom modifier.\",\"Spell attack modifier = your proficiency bonus + your Wisdom modifier.\"]},{\"name\":\"Ritual Casting\",\"desc\":[\"You can cast a druid spell as a ritual if that spell has the ritual tag and you have the spell prepared.\"]},{\"name\":\"Spellcasting Focus\",\"desc\":[\"You can use a druidic focus (see chapter 5, \\\"Equipment\\\") as a spellcasting focus for your druid spells.\"]}]},\"spells\":\"/api/classes/druid/spells\",\"url\":\"/api/classes/druid\"}\n";
    private ClassInformationHandler classInformationHandler;

    @Test
    public void happyPathToResponseInformationHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse(classInformationResponseBody, 200);
        request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[3] )).GET().build();
        classInformationHandler = new ClassInformationHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertEquals(classInformationResponseBody, classInformationHandler.getClassInformation(3).body());
    }

    @Test
    public void UnHappyPathToResponseInformationHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse("", 200);
        request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[3] )).GET().build();
        classInformationHandler = new ClassInformationHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertNotEquals(classInformationResponseBody, classInformationHandler.getClassInformation(3).body());
    }


    //**********Class Proficences Handler**********
    //TODO at time when making this test and API Connection response of body is EMPTY:
    private final String classProficencesResponseBody = "{\"count\":0,\"results\":[]}";
    private ClassProficenciesHandler classProficencesHandler;

    @Test
    public void happyPathToResponseProficenciesHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse(classProficencesResponseBody, 200);
        request = HttpRequest.newBuilder(new URI(URLProficences + ApiConnectionConstants.RACES[4] + "/proficiencies")).GET().build();
        classProficencesHandler = new ClassProficenciesHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertEquals(classProficencesResponseBody, classProficencesHandler.getProficiencies(4).body());
    }

    @Test
    public void UnHappyPathToResponseProficenciesHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse("", 200);
        request = HttpRequest.newBuilder(new URI(URLProficences + ApiConnectionConstants.RACES[4] + "/proficiencies")).GET().build();
        classProficencesHandler = new ClassProficenciesHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertNotEquals(classProficencesResponseBody, classProficencesHandler.getProficiencies(4).body());
    }


    //**********Class Resources Handler**********
    private final String classResourcesResponseBody = "{\"level\":1,\"ability_score_bonuses\":0,\"prof_bonus\":2,\"features\":[{\"index\":\"otherworldly-patron\",\"name\":\"Otherworldly Patron\",\"url\":\"/api/features/otherworldly-patron\"},{\"index\":\"pact-magic\",\"name\":\"Pact Magic\",\"url\":\"/api/features/pact-magic\"}],\"spellcasting\":{\"cantrips_known\":2,\"spells_known\":2,\"spell_slots_level_1\":1,\"spell_slots_level_2\":0,\"spell_slots_level_3\":0,\"spell_slots_level_4\":0,\"spell_slots_level_5\":0,\"spell_slots_level_6\":0,\"spell_slots_level_7\":0,\"spell_slots_level_8\":0,\"spell_slots_level_9\":0},\"class_specific\":{\"invocations_known\":0,\"mystic_arcanum_level_6\":0,\"mystic_arcanum_level_7\":0,\"mystic_arcanum_level_8\":0,\"mystic_arcanum_level_9\":0},\"index\":\"warlock-1\",\"class\":{\"index\":\"warlock\",\"name\":\"Warlock\",\"url\":\"/api/classes/warlock\"},\"url\":\"/api/classes/warlock/levels/1\"}\n";
    private ClassResourcesHandler classResourcesHandler;

    @Test
    public void happyPathToResponseResourcesHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse(classResourcesResponseBody, 200);
        request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[10] + "/levels/1")).GET().build();
        classResourcesHandler = new ClassResourcesHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertEquals(classResourcesResponseBody, classResourcesHandler.getClassResources(10).body());
    }

    @Test
    public void UnHappyPathToResponseResourcesHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse("", 200);
        request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[10] + "/levels/1")).GET().build();
        classResourcesHandler = new ClassResourcesHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertNotEquals(classResourcesResponseBody, classResourcesHandler.getClassResources(10).body());
    }

    //**********Class Resources Handler**********
    private final String classSpellsResponseBody = "{\"count\":27,\"results\":[{\"index\":\"alarm\",\"name\":\"Alarm\",\"url\":\"/api/spells/alarm\"},{\"index\":\"burning-hands\",\"name\":\"Burning Hands\",\"url\":\"/api/spells/burning-hands\"},{\"index\":\"charm-person\",\"name\":\"Charm Person\",\"url\":\"/api/spells/charm-person\"},{\"index\":\"color-spray\",\"name\":\"Color Spray\",\"url\":\"/api/spells/color-spray\"},{\"index\":\"comprehend-languages\",\"name\":\"Comprehend Languages\",\"url\":\"/api/spells/comprehend-languages\"},{\"index\":\"detect-magic\",\"name\":\"Detect Magic\",\"url\":\"/api/spells/detect-magic\"},{\"index\":\"disguise-self\",\"name\":\"Disguise Self\",\"url\":\"/api/spells/disguise-self\"},{\"index\":\"expeditious-retreat\",\"name\":\"Expeditious Retreat\",\"url\":\"/api/spells/expeditious-retreat\"},{\"index\":\"false-life\",\"name\":\"False Life\",\"url\":\"/api/spells/false-life\"},{\"index\":\"feather-fall\",\"name\":\"Feather Fall\",\"url\":\"/api/spells/feather-fall\"},{\"index\":\"find-familiar\",\"name\":\"Find Familiar\",\"url\":\"/api/spells/find-familiar\"},{\"index\":\"floating-disk\",\"name\":\"Floating Disk\",\"url\":\"/api/spells/floating-disk\"},{\"index\":\"fog-cloud\",\"name\":\"Fog Cloud\",\"url\":\"/api/spells/fog-cloud\"},{\"index\":\"grease\",\"name\":\"Grease\",\"url\":\"/api/spells/grease\"},{\"index\":\"hideous-laughter\",\"name\":\"Hideous Laughter\",\"url\":\"/api/spells/hideous-laughter\"},{\"index\":\"identify\",\"name\":\"Identify\",\"url\":\"/api/spells/identify\"},{\"index\":\"illusory-script\",\"name\":\"Illusory Script\",\"url\":\"/api/spells/illusory-script\"},{\"index\":\"jump\",\"name\":\"Jump\",\"url\":\"/api/spells/jump\"},{\"index\":\"longstrider\",\"name\":\"Longstrider\",\"url\":\"/api/spells/longstrider\"},{\"index\":\"mage-armor\",\"name\":\"Mage Armor\",\"url\":\"/api/spells/mage-armor\"},{\"index\":\"magic-missile\",\"name\":\"Magic Missile\",\"url\":\"/api/spells/magic-missile\"},{\"index\":\"protection-from-evil-and-good\",\"name\":\"Protection from Evil and Good\",\"url\":\"/api/spells/protection-from-evil-and-good\"},{\"index\":\"shield\",\"name\":\"Shield\",\"url\":\"/api/spells/shield\"},{\"index\":\"silent-image\",\"name\":\"Silent Image\",\"url\":\"/api/spells/silent-image\"},{\"index\":\"sleep\",\"name\":\"Sleep\",\"url\":\"/api/spells/sleep\"},{\"index\":\"thunderwave\",\"name\":\"Thunderwave\",\"url\":\"/api/spells/thunderwave\"},{\"index\":\"unseen-servant\",\"name\":\"Unseen Servant\",\"url\":\"/api/spells/unseen-servant\"}]}\n";
    private ClassSpellsHandler classSpellsHandler;

    @Test
    public void happyPathToSpellsResourcesHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse(classSpellsResponseBody, 200);
        request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[11] + "/levels/" + 1 + "/spells")).GET().build();
        classSpellsHandler = new ClassSpellsHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertEquals(classSpellsResponseBody, classSpellsHandler.getClassSpells(11).body());
    }

    @Test
    public void UnHappyPathToResponseSpellsHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse("", 200);
        request = HttpRequest.newBuilder(new URI(ApiConnectionConstants.URL + ApiConnectionConstants.CLASSES[11] + "/levels/" + 1 + "/spells")).GET().build();
        classSpellsHandler = new ClassSpellsHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertNotEquals(classSpellsResponseBody, classSpellsHandler.getClassSpells(11).body());
    }

    //**********Class Race Handler**********
    private final String classRaceInfoResponseBody = "{\"index\":\"tiefling\",\"name\":\"Tiefling\",\"speed\":30,\"ability_bonuses\":[{\"ability_score\":{\"index\":\"int\",\"name\":\"INT\",\"url\":\"/api/ability-scores/int\"},\"bonus\":1},{\"ability_score\":{\"index\":\"cha\",\"name\":\"CHA\",\"url\":\"/api/ability-scores/cha\"},\"bonus\":2}],\"alignment\":\"Tieflings might not have an innate tendency toward evil, but many of them end up there. Evil or not, an independent nature inclines many tieflings toward a chaotic alignment.\",\"age\":\"Tieflings mature at the same rate as humans but live a few years longer.\",\"size\":\"Medium\",\"size_description\":\"Tieflings are about the same size and build as humans. Your size is Medium.\",\"starting_proficiencies\":[],\"languages\":[{\"index\":\"common\",\"name\":\"Common\",\"url\":\"/api/languages/common\"},{\"index\":\"infernal\",\"name\":\"Infernal\",\"url\":\"/api/languages/infernal\"}],\"language_desc\":\"You can speak, read, and write Common and Infernal.\",\"traits\":[{\"index\":\"darkvision\",\"name\":\"Darkvision\",\"url\":\"/api/traits/darkvision\"},{\"index\":\"hellish-resistance\",\"name\":\"Hellish Resistance\",\"url\":\"/api/traits/hellish-resistance\"},{\"index\":\"infernal-legacy\",\"name\":\"Infernal Legacy\",\"url\":\"/api/traits/infernal-legacy\"}],\"subraces\":[],\"url\":\"/api/races/tiefling\"}\n";
    private RaceInformationHandler classRaceInformationHandler;

    @Test
    public void happyPathToRaceInformationHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse(classRaceInfoResponseBody, 200);
        request = HttpRequest.newBuilder(new URI(URLProficences + ApiConnectionConstants.RACES[8])).GET().build();
        classRaceInformationHandler = new RaceInformationHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertEquals(classRaceInfoResponseBody, classRaceInformationHandler.getRaceInformation(8).body());
    }

    @Test
    public void UnHappyPathToResponseRaceInformationHandlerBody() throws IOException, InterruptedException, URISyntaxException {
        setResponse("", 200);
        request = HttpRequest.newBuilder(new URI(URLProficences + ApiConnectionConstants.RACES[8])).GET().build();
        classRaceInformationHandler = new RaceInformationHandler(client);
        when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);

        Assertions.assertNotEquals(classRaceInfoResponseBody, classRaceInformationHandler.getRaceInformation(8).body());
    }

}
