package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class AccountSection {
    companion object {
        fun loginButtonIsDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.LOGIN_BUTTON)
                .named("displayed")
                .describedAs("Login button is displayed")
                .asABoolean()
        }

        fun settingsButtonIsDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.SETTINGS_BUTTON)
                .named("displayed")
                .describedAs("Settings button is displayed")
                .asABoolean()
        }

        fun helpAndContactButtonIsDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.HELP_AND_CONTACT_BUTTON)
                .named("displayed")
                .describedAs("Settings button is displayed")
                .asABoolean()
        }

        fun legalButtonIsDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.LEGAL_BUTTON)
                .named("displayed")
                .describedAs("Legal button is displayed")
                .asABoolean()
        }

        fun feedBackButtonIsDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.SEND_FEEDBACK_BUTTON)
                .named("displayed")
                .describedAs("Feedback button is displayed")
                .asABoolean()
        }
    }
}