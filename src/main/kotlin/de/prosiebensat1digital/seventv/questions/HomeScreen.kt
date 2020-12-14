package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class HomeScreen {
    companion object {
        fun displayed(): Question<Boolean> {
            return Attribute.of(Targets.SUSHI_BAR_RECYCLE_VIEW)
                .named("displayed")
                .describedAs("Home Screen is displayed")
                .asABoolean()
        }
    }
}