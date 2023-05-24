package org.victoria_3_syncretic_cultures_creator.creators

import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.utils.format
import org.victoria_3_syncretic_cultures_creator.utils.printFileWithoutBom
import org.victoria_3_syncretic_cultures_creator.utils.readFileAsText

fun createLocalization(syncreticCultures: List<SyncreticCulture>) {
        val textOfFile = readFileAsText("src/main/resources/templates/GenericLocalization.yml")

        val localizations = listOf("braz_por", "english", "french", "german", "japanese", "korean", "polish", "russian", "simp_chinese", "spanish", "turkish")

        localizations.forEach { localization ->
                var text = textOfFile
                text = text.replace("<localization_key>", localization)

                syncreticCultures.forEach {
                        val cultureNameKey = it.syncreticCultureName
                        val cultureNameLocalization = it.localization
                        text += format(0," ${cultureNameKey}:0 \"${cultureNameLocalization}\"" ,1)
                        text += format(0," standardize_${cultureNameKey}_decision_var_custom_tooltip:0 \"Has made the decision to develop the $cultureNameLocalization culture\"" ,1)
                        text += format(0," standardize_${cultureNameKey}_decision_not_var_custom_tooltip:0 \"Has not yet made the decision to develop the $cultureNameLocalization culture\"" ,1)
                        text += format(0," standardize_${cultureNameKey}_decision:0 \"Develop the ${cultureNameLocalization} Culture\"" ,1)
                        text += format(0," standardize_${cultureNameKey}_decision_desc:0 \"Prepare plans to eventually manifest this culture.\"" ,1)
                        text += format(0," je_standardize_${cultureNameKey}:0 \"Develop ${cultureNameLocalization}\"" ,1)
                        text += format(0," je_standardize_${cultureNameKey}_reason:0 \"With every new generation and every annual graduation of fresh minds from our schools our newly hatched syncretic culture will venture into the world. After 30 years we shall be reviewing the new status quo!\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.1.t:0 \"Emerging $cultureNameLocalization Culture\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.1.f:0 \"By geographically uniting the many different cultures with each other it is now time to enter the next chapter that continues the integration of our people with each other. Be it orthography, festivities, customs or other good things that make us special, by sharing the beneficial and standardizing that which slows us down we can only multiply the great things we already have. And so, one sweet day, our people will look past the regional differences of old and first and foremost consider themselves as ${cultureNameLocalization}.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.1.a:0 \"And so it shall be.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.2.t:0 \"Yearly graduation\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.2.f:0 \"New graduates.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.2.a:0 \"Nice.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.3.t:0 \"A Noticeable Cultural Change\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.3.f:0 \"It has been many years since we have started a process that still continues in our hearts and minds. This process has changed the way we perceive ourselves and others. Each day we define ourselves less with our region and more with our great fatherland. Even better, this development has ushered in a new leading culture, a shining light, that burns especially bright in the cities.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.3.a:0 \"A sign of progress.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.3.b:0 \"Perhaps we should hold onto the old ways a little while longer.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.3.c:0 \"We should push harder!\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.4.t:0 \"Welcome To The Fold\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.4.f:0 \"Although these regions have not been part of our transformative process from the start, now that they are part of it, we are eager to offer them the same prosperous future!\" " ,1)
                        text += format(0," standardize_${cultureNameKey}.4.a:0 \"All I see is family!\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.5.t:0 \"(Hidden) Yearly Conversion Event\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.5.f:0 \"New graduates.\" " ,1)
                        text += format(0," standardize_${cultureNameKey}.5.a:0 \"Nice.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.6.t:0 \"\$${cultureNameKey}\$ Debug Menu\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.6.f:0 \"While the yearly pop conversion does not take up much computational power, the added pops from the syncretic culture can. To combat the dreaded Pop-Fragmentation aka having many different culture pops in your game that cause a slow game, you can use the last option of this event to immediately convert all pops that match the criteria to \$${cultureNameKey}\$. Every subsequent yearly tick event will also have a 100% conversion rate. This will only affect this country. If you want to use it for a syncretic culture you picked for an AI you can access this menu for the other culture via the respective culture debug menu by switching to said country. This action can not be undone for this play through! However choosing this will make the game run faster than Vanilla as you effectively eliminate a lot of pop fragments.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.6.a:0 \"Keep me around, just in case.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.6.b:0 \"Hide this menu and decision forever.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.6.c:0 \"Trigger an additional yearly conversion tick right now.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.6.d:0 \"Trigger the 30/50/70 year milestone event now.\"" ,1)
                        text += format(0," standardize_${cultureNameKey}.6.e:0 \"Convert all eligible pops to \$${cultureNameKey}\$.\"" ,1)
                        text += format(0," complete_${cultureNameKey}_decision_not_var_custom_tooltip:0 \"Has not decided to set \$${cultureNameKey}\$ conversion to 100%\"" ,1)
                        text += format(0," complete_${cultureNameKey}_decision_var_custom_tooltip:0 \"Has decided to set \$${cultureNameKey}\$ conversion to 100%\"" ,1)
                        text += format(0," hide_${cultureNameKey}_debug_menu_var_custom_tooltip:0 \"Will remove the debug menu and decision to open it\"" ,1)
                        text += format(0," complete_${cultureNameKey}_decision:0 \"Open Performance Helper Menu\"" ,1)
                        text += format(0," complete_${cultureNameKey}_decision_desc:0 \"If you have performance issues or want to fast track the 30/50/70 year milestone event.\"" ,1)

                        it.optionalCultures.forEach { addonCulture ->
                                text += format(0," standardize_${cultureNameKey}_addon_${addonCulture}.1.t:0 \"What about \$$addonCulture\$?\"" ,1)
                                text += format(0," standardize_${cultureNameKey}_addon_${addonCulture}.1.f:0 \"Some of our advisors say that the \$$addonCulture\$ culture should not be made part of our plans, be it for historical, linguistic, cultural or other reasons.\" " ,1)
                                text += format(0," standardize_${cultureNameKey}_addon_${addonCulture}.1.a:0 \"We will include them!\"" ,1)
                                text += format(0," standardize_${cultureNameKey}_addon_${addonCulture}.1.b:0 \"Perhaps its better to exclude them.\"" ,1)
                                text += format(0," standardize_${cultureNameKey}_addon_${addonCulture}_var_custom_tooltip:0 \"Has decided to include the \$$addonCulture\$.\"" ,1)
                                text += format(0," standardize_${cultureNameKey}_addon_${addonCulture}_not_var_custom_tooltip:0 \"Has not yet decided to include the \$$addonCulture\$ culture.\"" ,1)
                        }
                }

                printFileWithoutBom("/localization/$localization/", "syncretic_cultures_l_" + localization + ".yml", text)
        }
    }
