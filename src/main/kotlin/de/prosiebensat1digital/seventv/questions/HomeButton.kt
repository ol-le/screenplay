package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject
import net.serenitybdd.screenplay.questions.Attribute

@Subject("Home Button is selected")
class HomeButton {
    companion object {
        fun selected(): Question<Boolean> {
            return Attribute.of(Targets.HOME_BUTTON)
                .named("selected")
                .describedAs("Home Screen Home Button is selected")
                .asABoolean()
        }
    }
}