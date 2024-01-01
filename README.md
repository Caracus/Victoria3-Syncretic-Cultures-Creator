# Victoria 3 Syncretic Culture Creator

<!-- ABOUT THE PROJECT -->
### What does this do?
## Automates the creation of Syncretic Cultures
####aswell as the needed events, journal entries and decisions to make them appear organically like in the "Syncretic Cultures" mod on the steam workshop for Victoria 3


### Built With
- Kotlin
- Maven
- IntelliJ IDEA (any other compatible IDEA will do just fine)

## How to use it
1. Start under src/main/kotlin/./CreateSyncreticCultures.kt which orchestrates all the main functions
2. Pressing the green icon or starting it will launch the program and create the mod files under target/generated-mod-files
3. If you just want to add a new culture you will have to adjust the config in the resources and add a name list for the new culture

4. Example for a new configuration as json: 
```
[
  {
        "syncreticCultureName": "latino",
        "baseCultures": ["mexican", "central_american", "north_andean", "south_andean", "platinean", "caribeno"],
        "formabilityCriteria": "ANY",
        "optionalCultures": ["afro_caribeno"],
        "mutuallyExclusiveWith": ["hispanic"],
        "defaultCulture": false,
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
- mutuallyExclusiveWith: those syncretic cultures you have created go here if they overlap with another created one as by design the player should only be able to form one syncretic culture over the span of the playthrough, the baseline for exclusive cultures is calculated codewise, manual exclusions can be added here
- defaultCulture: true if the AI should be able to form the syncretic culture if the game rule allows the AI to do so
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
| Syncretic Culture | Base Cultures | Optional Cultures | Tag Limitation |
| ----------------- | ------------- | ----------------- | -------------- |
| Afghan | Pashtun and Tajik | Hazara and Baluchi |  |
| Afrikaner | Boer and British |  |  |
| Anglophone | Yankee, Anglo Canadian, Australian, British, Scottish, Dixie and Welsh | Afro American and Afro Caribbean |  |
| Arab | Mashriqi, Maghrebi, Somali, Yemenite, Sudanese, Bedouin, Misri and Berber | Haratin, Tuareg and Bidan |  |
| Danubian | South German and Hungarian | Ukrainian, Slovene, Serb, North German, Slovak, Croat, Polish, Romanian, North Italian, Czech and Bosniak |  |
| Baltic | Estonian, Lithuanian and Latvian |  |  |
| Byzantine | Greek and Turkish | Serb, Tatar, Armenian, Albanian, Bulgarian, Croat, Circassian, North Caucasian, Bosniak and Georgian |  |
| Canadian | Anglo Canadian, Franco Canadian and British |  |  |
| Caucasian | Armenian, Circassian, North Caucasian and Georgian | Azerbaijani |  |
| Celtic | Irish, Welsh and Breton | Scottish |  |
| Central African | Mongo, Bakongo, Kanuri, Baguirmi, Fluvian Bantu, Sara, Teda, Luba, Lunda, Fang and Equatorial Bantu |  |  |
| Chinese | Min, Han, Yue and Hakka | Mongol, Vietnamese, Manchu, Korean and Tibetan | CHI, TPG |
| Czechoslovakian | Slovak and Czech |  |  |
| Dravidian | Tamil, Malayalam, Kannada and Telegu | Sinhala |  |
| East-Aryan | Bihari, Bengali and Oriya | Manipuri, Nepali, Tibetan and Assamese | MUG, HND |
| Eastern African | Sukuma, Somali, Amhara, Fur, Luo, Nuer, Sudanese, Maasai, Lacustrine Bantu, Ruanda, Azande, Dinka, Rundi, Nilotic, Tigray, Baganda, Beja, Kikuyu, Sidama, Nuba, Afar, Swahili, Unyamwezi and Oromo | Malagasy |  |
| Ethiopian | Amhara, Tigray, Sidama, Afar and Oromo | Somali |  |
| European American | Colombian, Paraguayan, Yankee, Nordestino, Cajun, Platinean, Mexican, Uruguayan, Chilean, Anglo Canadian, Brazilian, Amazonic, Ecuadorian, Venezuelan, Paulista, Sulista, North Andean, Caribeno, Argentine, Central American, Franco Canadian, South Andean and Dixie | Afro American, Afro Antillean, Afro Caribeno and Afro Brazilian |  |
| European | Ukrainian, Corsican, Ashkenazi, British, Mexican, Scottish, Norwegian, Welsh, Dutch, Boer, Caribeno, Argentine, Flemish, Romanian, French, Czech, Georgian, Swedish, Yankee, Russian, North German, Platinean, Armenian, Francoprovencal, Breton, Ugrian, Anglo Canadian, Brazilian, Venezuelan, Serb, Sorb, Franco Canadian, Croat, Bulgarian, Colombian, Paraguayan, Icelandic, South German, Nordestino, Alemannic, Cajun, Irish, Australian, Slovak, Hungarian, North Caucasian, Byelorussian, Occitan, Wallonian, Estonian, Amazonic, Ecuadorian, Paulista, Sulista, Slovene, Central American, Portuguese, Circassian, Dixie, Sami, Greek, Spanish, Danish, Basque, Lithuanian, Albanian, Uruguayan, Maltese, Finnish, Chilean, Catalan, Sephardic, North Andean, South Italian, South Andean, Polish, Galician, Bosniak, North Italian and Latvian |  |  |
| Finnic | Finnish, Ugrian, Estonian and Sami |  |  |
| German | South German, Ashkenazi, Alemannic and North German | Slovene, Sorb and Czech | GER |
| Germanic | Dutch, Swedish, Icelandic, Danish, South German, Boer, Alemannic, North German, Flemish and Norwegian | Ashkenazi and British |  |
| Gran-Colombian | Colombian, Ecuadorian, Venezuelan, North Andean and Central American | Paraguayan, Chilean, Muisca, Afro Caribeno, Quechua, Argentine, Miskito, South Andean, Amazonian, Cariban, Uruguayan and Guajiro |  |
| Hindustani | Panjabi, Kanauji, Kashmiri and Avadhi |  | MUG, HND |
| Hispanic | Colombian, Paraguayan, Spanish, Platinean, Mexican, Uruguayan, Chilean, Ecuadorian, Venezuelan, North Andean, Caribeno, Argentine, Central American and South Andean | Catalan, Afro Caribeno, Basque and Galician |  |
| Iberian | Spanish, Catalan, Portuguese, Basque and Galician |  |  |
| Iberic | Colombian, Paraguayan, Spanish, Nordestino, Platinean, Basque, Mexican, Uruguayan, Chilean, Catalan, Brazilian, Amazonic, Ecuadorian, Venezuelan, Paulista, Sulista, North Andean, Caribeno, Argentine, Central American, South Andean, Portuguese and Galician | Afro Caribeno and Afro Brazilian |  |
| Indian | Bihari, Panjabi, Rajput, Manipuri, Gujarati, Kannada, Avadhi, Telegu, Assamese, Marathi, Tamil, Malayalam, Kanauji, Sindi, Bengali, Kashmiri, Nepali, Sinhala and Oriya | Pashtun, Karen, Shan, Burmese, Kachin, Zhuang, Baluchi and Tibetan | MUG, HND |
| Indo-Aryan | Bihari, Panjabi, Rajput, Gujarati, Avadhi, Marathi, Kanauji, Sindi, Bengali, Kashmiri, Nepali, Sinhala and Oriya |  | MUG, HND |
| Iranian | Pashtun, Kurdish, Baluchi, Persian and Tajik | Azerbaijani |  |
| Israeli | Sephardic and Ashkenazi |  |  |
| Italian | South Italian and North Italian | Corsican and Maltese | ITA |
| Hispanic American | Colombian, Paraguayan, Platinean, Mexican, Uruguayan, Chilean, Ecuadorian, Venezuelan, North Andean, Caribeno, Argentine, Central American and South Andean | Afro Caribeno |  |
| Malayan | Balinese, Moluccan, Filipino, Dayak, Sumatran, Moro, Malay, Batak, Bornean and Javan | Malagasy, Aborigine and Melanesian | IDN |
| Brazilian | Nordestino, Brazilian, Amazonic, Paulista and Sulista | Tupinamba, Guarani, Amazonian and Afro Brazilian |  |
| British | British and Scottish | Irish and Welsh |  |
| Burmese | Karen, Burmese, Kachin and Zhuang | Shan |  |
| French | Francoprovencal, French and Occitan | Wallonian, Alemannic and Breton |  |
| Japanese | Ainu and Japanese | Korean | JAP |
| Goryeo | Korean and Manchu | Japanese |  |
| Mexican | Zapotec, Tarascan, Oodham, Mixtec, Nahua, Mexican and Mayan | Afro Caribeno, Central American and Miskito |  |
| Portuguese | Portuguese and Galician |  |  |
| Spanish | Spanish and Catalan | Basque and Galician | SPA |
| Native American | Tarascan, Comanche, Caddoan, Guarani, Patagonian, Miskito, Nez Perce, Siouan, Tupinamba, Muisca, Apache, Algonquian, Nahua, Amazonian, Pueblo, Hokan, Cariban, Inuit, Navajo, Cree, Dakota, Athabaskan, Oodham, Muskogean, Salish, Metis, Paiute, Aimara, Zapotec, Iroquoian, Mixtec, Quechua, Guajiro, Cherokee and Mayan |  |  |
| Netherlandic | Dutch, Boer and Flemish | Wallonian |  |
| Slavic | Ukrainian, Russian, Serb, Slovene, Sorb, Slovak, Croat, Bulgarian, Polish, Byelorussian, Czech and Bosniak |  |  |
| Polish-Lithuanian | Lithuanian and Polish | Ukrainian, Byelorussian and Latvian |  |
| Polynesian | Micronesian, Melanesian, Polynesian, Maori and Hawaiian | Aborigine |  |
| Porto-Brazilian | Nordestino, Brazilian, Amazonic, Paulista, Sulista, Portuguese and Galician | Afro Brazilian |  |
| Romance | Spanish, Corsican, Francoprovencal, Maltese, Occitan, Wallonian, Catalan, South Italian, Portuguese, Romanian, Galician, French and North Italian |  |  |
| Rus | Ukrainian, Russian and Byelorussian |  | RUS |
| Scandinavian | Swedish, Icelandic, Danish and Norwegian | Finnish and Sami | SCA |
| Southern African | Ovimbundu, Tswana, Xhosa, Yao, Shona, Chewa, Khoisan, Nguni, Makua, Sena, Herero, Kavango Bantu, Sotho, Tonga, Zulu and Lomwe |  |  |
| Sub-Saharan African | Sukuma, Fur, Tswana, Tuareg, Luo, Nuer, Khoisan, Lacustrine Bantu, Ruanda, Hausa, Makua, Nilotic, Herero, Mossi, Kavango Bantu, Yoruba, Beja, Sidama, Sotho, Teda, Fang, Equatorial Bantu, Tiv, Senufo, Amhara, Baguirmi, Fluvian Bantu, Malagasy, Sudanese, Nguni, Wolof, Dinka, Rundi, Sena, Edo, Tigray, Haratin, Kanuri, Luba, Afar, Zulu, Swahili, Unyamwezi, Lomwe, Mongo, Fon, Xhosa, Sara, Chewa, Dyula, Azande, Songhai, Bakongo, Fulbe, Ibibio, Oromo, Ovimbundu, Somali, Yao, Shona, Bambara, Maasai, Lunda, Kru, Bassa, Ewe, Baganda, Kikuyu, Nuba, Mande, Ibo, Akan, Tonga, Bidan and Kissi | Afro American, Afro Caribbean, Afro Antillean, Afro Caribeno and Afro Brazilian |  |
| Swiss | Alemannic and Francoprovencal | North Italian |  |
| Tai | Shan, Thai, Lao and Zhuang | Khmu, Khmer and Mon |  |
| Taiwanese | Yuanzhumin and Hakka |  |  |
| Turkic | Yakut, Turkish, Kirgiz, Tatar, Hazara, Azerbaijani, Uzbek, Tuvan, Uighur, Turkmen and Kazak | Persian |  |
| US American | Yankee and Dixie | Afro American and Cajun |  |
| West-Aryan | Marathi, Rajput, Sindi and Gujarati |  | MUG, HND |
| West Slavic | Sorb, Slovak, Polish and Czech |  |  |
| Western African | Tiv, Senufo, Fon, Tuareg, Bambara, Wolof, Dyula, Hausa, Songhai, Kru, Bassa, Edo, Ewe, Haratin, Mossi, Fulbe, Yoruba, Mande, Ibo, Akan, Ibibio, Bidan and Kissi |  |  |
| Yugoslavian | Serb, Slovene, Croat, Bulgarian and Bosniak |  |  |

###Default Countries used if immersive cultures game rule was chosen:
| Syncretic Culture | Tag Limitation | Base Cultures | AI Allowed Addon Subset |
| ----------------- | -------------- | ------------- | ----------------------- |
| Canadian | CAN | Anglo Canadian, Franco Canadian and British |  |
| Chinese | CHI, TPG | Min, Han, Yue and Hakka |  |
| German | GER | South German, Ashkenazi, Alemannic and North German | Sorb |
| Italian | ITA | South Italian and North Italian | Corsican and Maltese |
| Brazilian | BRZ | Nordestino, Brazilian, Amazonic, Paulista and Sulista | Tupinamba, Guarani, Amazonian and Afro Brazilian |
| British |  | British and Scottish | Welsh |
| Burmese |  | Karen, Burmese, Kachin and Zhuang |  |
| French | FRA | Francoprovencal, French and Occitan | Wallonian and Breton |
| Japanese | JAP | Ainu and Japanese |  |
| Mexican | MEX | Zapotec, Tarascan, Oodham, Mixtec, Nahua, Mexican and Mayan |  |
| Portuguese | POR | Portuguese and Galician |  |
| Spanish | SPA | Spanish and Catalan | Basque and Galician |
| Rus | RUS | Ukrainian, Russian and Byelorussian |  |
| Scandinavian | SCA | Swedish, Icelandic, Danish and Norwegian |  |
| United Statian |  | Yankee and Dixie |  |

###Pending suggestion dump
Gaul or Gallia (Base: French/Breton/Occitan/Wallonian/Franco-Provençal/Alemanic, Optional: North Italian/Flemish)
Occitano-Romance (Occitan/Catalan/Franco-Provençal)
North Asian (Base: Siberian/Yakut/Ainu/Tuvan/Ugrian/Tatar, Optional: Mongol, Manchu, Inuit)
Uralic (Finnish/Ugrian/Estonian/Sami/Hungarian)
European culture