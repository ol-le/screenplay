package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.base.Constants.HOME_SCREEN_RESOURCE_ID
import de.prosiebensat1digital.seventv.base.ScrollOrientation
import de.prosiebensat1digital.seventv.targets.Targets
import de.prosiebensat1digital.seventv.targets.Utils
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class OriginalsAndExclusives {
    companion object {
        fun displayed(): Question<Boolean> {
            return Attribute.of(Targets.ORIGINALS_AND_EXCLUSIVES_TITLE)
                .named("displayed")
                .describedAs("Originals & Exclusives is displayed")
                .asABoolean()
        }
    }
}