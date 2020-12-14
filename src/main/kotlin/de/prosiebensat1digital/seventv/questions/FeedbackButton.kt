package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Attribute

class FeedbackButton {
    companion object {
        fun isDisplayed(): Question<Boolean> {
            return Attribute.of(Targets.SEND_FEEDBACK_BUTTON)
                .named("displayed")
                .describedAs("Feedback button is displayed")
                .asABoolean()
        }
    }
}