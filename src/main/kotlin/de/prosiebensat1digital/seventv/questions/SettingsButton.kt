package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class SettingsButton {
    companion object {
        fun isDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.SETTINGS_BUTTON)
                .named("displayed")
                .describedAs("Settings button is displayed")
                .asABoolean()
        }
    }
}