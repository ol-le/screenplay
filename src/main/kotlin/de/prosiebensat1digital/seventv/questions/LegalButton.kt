package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class LegalButton {
    companion object{
        fun isDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.LEGAL_BUTTON)
                .named("displayed")
                .describedAs("Legal button is displayed")
                .asABoolean()
        }
    }
}