package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class Tracking {
    companion object {
        fun isOn(): Question<Boolean> {
            return Attribute.of(Targets.TRACKING_ON)
                .named("checked")
                .describedAs("Tracking ON is checked")
                .asABoolean()
        }

        fun isOff(): Question<Boolean> {
            return Attribute.of(Targets.TRACKING_OFF)
                .named("checked")
                .describedAs("Tracking OFF is checked")
                .asABoolean()
        }
    }

}