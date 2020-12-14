package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class OriginalsAndExclusives {
    companion object {
        fun isDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.ORIGINALS_AND_EXCLUSIVES_TITLE)
                .named("displayed")
                .describedAs("Originals & Exclusives is displayed")
                .asABoolean()
        }
    }
}