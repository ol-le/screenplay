package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class TrackingIs {
    companion object {
        fun on(): Question<Boolean> {
            return Attribute.of(Targets.TRACKING_ON)
                .named("checked")
                .describedAs("Tracking ON is checked")
                .asABoolean()
        }

        fun off(): Question<Boolean> {
            return Attribute.of(Targets.TRACKING_OFF)
                .named("checked")
                .describedAs("Tracking OFF is checked")
                .asABoolean()
        }
    }

}