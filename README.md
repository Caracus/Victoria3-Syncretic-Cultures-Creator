# Victoria 3 Syncretic Culture Creator

<!-- ABOUT THE PROJECT -->
### What does this do?
## Automates the creation of syncretic cultures
####aswell as the needed events, journal entries and decisions to make them appear organically like in the "Syncretic Cultures" mod on the steam workshop for Victoria


### Built With
- Kotlin
- Maven
- IntelliJ IDEA (any other compatible IDEA will do just fine)

## How to use it
1. Start under src/main/kotlin/./CreateSyncreticCultures.kt which orchestrates all the main functions
2. Pressing the green icon or starting it will launch the programm an create the mod files under target/generated-mod-files
3. If you just want to add a new culture you will have to adjust the config in the resources and add a namelist for the new culture

4. Example for a new configuration as json: 
```
[
  {
        "syncreticCultureName": "latino",
        "baseCultures": ["mexican", "central_american", "north_andean", "south_andean", "platinean", "caribeno"],
        "formabilityCriteria": "ANY",
        "optionalCultures": ["afro_caribeno"],
        "mutuallyExclusiveWith": ["hispanic"],
        "localization": "Latino",
        "color": "rgb{ 156 149 22 } #dark yellow",
        "religion": "catholic",
        "traits": "hispanophone european_heritage",
        "obsessions": "",
        "graphics": "european",
        "ethnicity": "caucasian"
  },
  {
    ......
  }
]
```
- syncreticCultureName: is the technical key the game will use
- baseCultures: are the cultures that will always be part of the syncretic cultures
- formabilityCriteria: "ALL" means all base base cultures are needed, "ANY" having any of the base cultures qualifies to form it
- optionalCultures: here go all cultures that deserve a decision pop up ingame that asks the player whether they want to include it or not as these are additions can be controverse or simply unwanted
- mutuallyExclusiveWith: those syncretic cultures you have created go here if they overlap with another created one as by design the player should only be able to form one syncretic culture over the span of the playthrough
- localization: The string that will show up ingame for the culture, this may differ from the technical key the game uses
- color to ethnicity are simply lines from the game, they are parsed 1:1 into the game files so other color formats like hsv will work here too
5. If you are looking for the correct keys for these inputs I suggest looking up the game files
6. Dont forget to create the name list under resources/z_name_lists
7. If you want to edit/optimize the script you will have to adjust the resource/templates and the creators/ depending on your goal
8. Of course you can also adapt the format of the json to your needs by changing the model class for it

### Why might this be interesting for other modders?
If you are playing with a mod that uses different cultures you can just adjust the configuration of this program,
press run and enjoy syncretic cultures in your mod aswell since all files created by this mod are completely standalone
and dont interfere with other modded files

### How to set it up
1. I suggest using the IntelliJ IDEA which has a free community edition.
2. Checkout the latest version via git or download it. (If you want to contribute directly you need git anyway)
3. Import the project into the IDEA via the pom.xml as a new project (File/Open/..) which will then be used to automatically build the project.

### Background/Mod philosophy
Should be on the [Mod Page](https://steamcommunity.com/sharedfiles/filedetails/?id=2952980917)

### How to contribute
If you know your way around git. Then create a branch and open a pull request with the desired changes.
Otherwise let me know via Steam via comment.

### [Exhaustive list of featured default syncretic cultures] (#CultureList)
| Syncretic Culture | Base Cultures | Optional Cultures |
| ----------------- | ------------- | ----------------- |
| Modern French | [french, occitan] | [wallonian, breton] |
| Chinese | [min, han, yue, manchu, hakka] | [] |
| Italian | [south_italian, maltese, north_italian] | [corsican] |
| Rus | [ukrainian, russian, byelorussian] | [] |
| Yugoslavian | [serb, slovene, croat, bulgarian, bosniak] | [] |
| West Slavic | [sorb, slovak, polish, czech] | [] |
| Arabian | [mashriqi, maghrebi, somali, yemenite, sudanese, bedouin, misri, berber] | [] |
| Netherlandic | [dutch, boer, flemish] | [wallonian] |
| Anglophone | [yankee, anglo_canadian, australian, british, scottish, dixie, welsh] | [afro_american, afro_caribbean] |
| British | [british, scottish] | [irish, welsh] |
| US American | [yankee, dixie] | [afro_american, cajun] |
| Canadian | [anglo_canadian, franco_canadian] | [] |
| Iberic | [spanish, catalan, brazilian, north_andean, platinean, caribeno, central_american, south_andean, portuguese, basque, mexican, galician] | [afro_caribeno, afro_brazilian] |
| Hispanic | [spanish, north_andean, platinean, caribeno, central_american, south_andean, mexican] | [catalan, afro_caribeno, basque, galician] |
| Latino | [north_andean, platinean, caribeno, central_american, south_andean, mexican] | [afro_caribeno] |
| Iberian | [spanish, catalan, portuguese, basque, galician] | [] |
| Modern Spanish | [spanish, catalan] | [basque, galician] |
| Porto-Brazilian | [brazilian, portuguese, galician] | [afro_brazilian] |
| Modern Portuguese | [portuguese, galician] | [] |
| Modern Japanese | [ainu, japanese] | [korean] |
| Scandinavian | [swedish, icelandic, danish, norwegian] | [finnish, sami] |
| Finnic | [finnish, ugrian, estonian, sami] | [] |
| Baltic | [estonian, lithuanian, latvian] | [] |
| Turkic | [yakut, turkish, kirgiz, tatar, hazara, azerbaijani, uzbek, tuvan, uighur, turkmen, kazak] | [] |
| German | [south_german, north_german] | [ashkenazi, slovene, swiss, czech] |
| Germanic | [dutch, swedish, icelandic, danish, south_german, boer, north_german, swiss, flemish, norwegian] | [ashkenazi, british] |
| Israeli | [sephardic, ashkenazi] | [] |
