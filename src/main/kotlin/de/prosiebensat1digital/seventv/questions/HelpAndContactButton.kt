package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class HelpAndContactButton{
    companion object{
        fun isDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.HELP_AND_CONTACT_BUTTON)
                .named("displayed")
                .describedAs("Settings button is displayed")
                .asABoolean()
        }
    }
}