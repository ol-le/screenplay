package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class LoginButton {
    companion object {
        fun isDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.LOGIN_BUTTON)
                .named("displayed")
                .describedAs("Login button is displayed")
                .asABoolean()
        }
    }
}