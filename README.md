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
- mutuallyExclusiveWith: those syncretic cultures you have created go here if they overlap with another created one as by design the player should only be able to form one syncretic culture over the span of the playthrough
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
| Syncretic Culture | Base Cultures | Optional Cultures |
| ----------------- | ------------- | ----------------- |
| Modern French | French and Occitan | Wallonian, Francoprovencal and Breton |
| Chinese | Min, Han, Yue and Hakka | Mongol, Vietnamese, Manchu, Korean and Tibetan |
| Italian | South Italian and North Italian | Corsican and Maltese |
| Swiss | Alemannic and Francoprovencal | North Italian |
| Romance | Spanish, Corsican, Francoprovencal, Maltese, Occitan, Wallonian, Catalan, South Italian, Portuguese, Romanian, Galician, French and North Italian |  |
| Rus | Ukrainian, Russian and Byelorussian |  |
| Yugoslavian | Serb, Slovene, Croat, Bulgarian and Bosniak |  |
| West Slavic | Sorb, Slovak, Polish and Czech |  |
| Polish-Lithuanian | Lithuanian and Polish | Ukrainian, Byelorussian and Latvian |
| Czechoslovakian | Slovak and Czech |  |
| Arab | Mashriqi, Maghrebi, Somali, Yemenite, Sudanese, Bedouin, Misri and Berber | Haratin, Tuareg and Bidan |
| Netherlandic | Dutch, Boer and Flemish | Wallonian |
| Anglophone | Yankee, Anglo Canadian, Australian, British, Scottish, Dixie and Welsh | Afro American and Afro Caribbean |
| British | British and Scottish | Irish and Welsh |
| US American | Yankee and Dixie | Afro American and Cajun |
| Canadian | Anglo Canadian and Franco Canadian |  |
| Iberic | Spanish, Catalan, Brazilian, North Andean, Platinean, Caribeno, Central American, South Andean, Portuguese, Basque, Mexican and Galician | Afro Caribeno and Afro Brazilian |
| Hispanic | Spanish, North Andean, Platinean, Caribeno, Central American, South Andean and Mexican | Catalan, Afro Caribeno, Basque and Galician |
| Hispanic American | North Andean, Platinean, Caribeno, Central American, South Andean and Mexican | Afro Caribeno |
| Iberian | Spanish, Catalan, Portuguese, Basque and Galician |  |
| Modern Spanish | Spanish and Catalan | Basque and Galician |
| Gran-Colombian | North Andean and Central American | Muisca, Afro Caribeno, Quechua, Miskito, South Andean, Amazonian, Cariban and Guajiro |
| Modern Mexican | Zapotec, Tarascan, Oodham, Mixtec, Nahua, Mexican and Mayan | Afro Caribeno, Central American and Miskito |
| Porto-Brazilian | Brazilian, Portuguese and Galician | Afro Brazilian |
| Modern Brazilian | Tupinamba, Brazilian, Guarani, Amazonian and Afro Brazilian |  |
| Modern Portuguese | Portuguese and Galician |  |
| European American | Yankee, Anglo Canadian, Brazilian, Cajun, North Andean, Platinean, Caribeno, Central American, Franco Canadian, South Andean, Mexican and Dixie | Afro American, Afro Antillean, Afro Caribeno and Afro Brazilian |
| Native American | Tarascan, Comanche, Caddoan, Guarani, Patagonian, Miskito, Nez Perce, Siouan, Tupinamba, Muisca, Apache, Algonquian, Nahua, Amazonian, Pueblo, Hokan, Cariban, Inuit, Navajo, Cree, Dakota, Athabaskan, Oodham, Muskogean, Salish, Metis, Paiute, Aimara, Zapotec, Iroquoian, Mixtec, Quechua, Guajiro, Cherokee and Mayan |  |
| Modern Japanese | Ainu and Japanese | Korean |
| Goryeo | Korean and Manchu |  |
| Scandinavian | Swedish, Icelandic, Danish and Norwegian | Finnish and Sami |
| Finnic | Finnish, Ugrian, Estonian and Sami |  |
| Baltic | Estonian, Lithuanian and Latvian |  |
| Turkic | Yakut, Turkish, Kirgiz, Tatar, Hazara, Azerbaijani, Uzbek, Tuvan, Uighur, Turkmen and Kazak | Persian |
| Byzantine | Greek and Turkish | Serb, Tatar, Armenian, Albanian, Bulgarian, Croat, Circassian, North Caucasian, Bosniak and Georgian |
| Afghan | Pashtun and Tajik | Hazara and Baluchi |
| German | South German and North German | Ashkenazi, Alemannic, Slovene and Czech |
| Germanic | Dutch, Swedish, Icelandic, Danish, South German, Boer, Alemannic, North German, Flemish and Norwegian | Ashkenazi and British |
| Austro-Hungarian | South German and Hungarian | Ukrainian, Slovene, Serb, North German, Slovak, Croat, Polish, Romanian, North Italian, Czech and Bosniak |
| Israeli | Sephardic and Ashkenazi |  |
| Tai | Shan, Thai, Lao and Zhuang | Khmu, Khmer and Mon |
| Modern Burmese | Karen, Burmese, Kachin and Zhuang |  |
| Malayan | Balinese, Moluccan, Filipino, Dayak, Sumatran, Moro, Malay, Batak, Bornean and Javan | Malagasy, Aborigine and Melanesian |
| Polynesian | Micronesian, Melanesian, Polynesian, Maori and Hawaiian | Aborigine |
| Iranian | Pashtun, Kurdish, Baluchi, Persian and Tajik | Azerbaijani |
| Caucasian | Armenian, Circassian, North Caucasian and Georgian | Azerbaijani |
| West-Aryan | Marathi, Rajput, Sindi and Gujarati |  |
| East-Aryan | Bihari, Bengali and Oriya | Manipuri, Nepali, Tibetan and Assamese |
| Hindustani | Panjabi, Kanauji, Kashmiri and Avadhi |  |
| Indo-Aryan | Bihari, Panjabi, Rajput, Gujarati, Avadhi, Marathi, Kanauji, Sindi, Bengali, Kashmiri, Nepali, Sinhala and Oriya |  |
| Indian | Bihari, Panjabi, Rajput, Manipuri, Gujarati, Kannada, Avadhi, Telegu, Assamese, Marathi, Tamil, Malayalam, Kanauji, Sindi, Bengali, Kashmiri, Nepali, Sinhala and Oriya | Pashtun, Karen, Shan, Burmese, Kachin, Zhuang, Baluchi and Tibetan |
| Dravidian | Tamil, Malayalam, Kannada and Telegu | Sinhala |
| Ethiopian | Amhara, Tigray, Sidama, Afar and Oromo | Somali |
| Southern African | Ovimbundu, Tswana, Xhosa, Yao, Shona, Chewa, Khoisan, Nguni, Makua, Sena, Herero, Kavango Bantu, Sotho, Tonga, Zulu and Lomwe |  |
| Central African | Mongo, Bakongo, Kanuri, Baguirmi, Fluvian Bantu, Sara, Teda, Luba, Lunda, Fang and Equatorial Bantu |  |
| Eastern African | Sukuma, Somali, Amhara, Fur, Luo, Nuer, Sudanese, Maasai, Lacustrine Bantu, Ruanda, Azande, Dinka, Rundi, Nilotic, Tigray, Baganda, Beja, Kikuyu, Sidama, Nuba, Afar, Swahili, Unyamwezi and Oromo | Malagasy |
| Western African | Tiv, Senufo, Fon, Tuareg, Bambara, Wolof, Dyula, Hausa, Songhai, Kru, Bassa, Edo, Ewe, Haratin, Mossi, Fulbe, Yoruba, Mande, Ibo, Akan, Ibibio, Bidan and Kissi |  |
| Sub-Saharan African | Sukuma, Fur, Tswana, Tuareg, Luo, Nuer, Khoisan, Lacustrine Bantu, Ruanda, Hausa, Makua, Nilotic, Herero, Mossi, Kavango Bantu, Yoruba, Beja, Sidama, Sotho, Teda, Fang, Equatorial Bantu, Tiv, Senufo, Amhara, Baguirmi, Fluvian Bantu, Malagasy, Sudanese, Nguni, Wolof, Dinka, Rundi, Sena, Edo, Tigray, Haratin, Kanuri, Luba, Afar, Zulu, Swahili, Unyamwezi, Lomwe, Mongo, Fon, Xhosa, Sara, Chewa, Dyula, Azande, Songhai, Bakongo, Fulbe, Ibibio, Oromo, Ovimbundu, Somali, Yao, Shona, Bambara, Maasai, Lunda, Kru, Bassa, Ewe, Baganda, Kikuyu, Nuba, Mande, Ibo, Akan, Tonga, Bidan and Kissi | Afro American, Afro Caribbean, Afro Antillean, Afro Caribeno and Afro Brazilian |

###Default Countries used if immersive cultures game rule was chosen:
| Syncretic Culture | Required | Cultures |
| ----------------- | ---------------------- | ------------- |
| Modern French | ANY | French and Occitan |
| Chinese | ANY | Min, Han, Yue and Hakka |
| Italian | ALL | South Italian and North Italian |
| Rus | ANY | Ukrainian, Russian and Byelorussian |
| British | ANY | British and Scottish |
| US American | ALL | Yankee and Dixie |
| Canadian | ANY | Anglo Canadian and Franco Canadian |
| Modern Spanish | ANY | Spanish and Catalan |
| Modern Mexican | ANY | Zapotec, Tarascan, Oodham, Mixtec, Nahua, Mexican and Mayan |
| Modern Brazilian | ANY | Tupinamba, Brazilian, Guarani, Amazonian and Afro Brazilian |
| Modern Japanese | ANY | Ainu and Japanese |
| Scandinavian | ALL | Swedish, Icelandic, Danish and Norwegian |
| German | ALL | South German and North German |
