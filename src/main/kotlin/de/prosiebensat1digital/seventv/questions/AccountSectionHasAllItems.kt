package de.prosiebensat1digital.seventv.questions

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question

class AccountSectionHasAllItems : Question<Boolean> {

    override fun answeredBy(actor: Actor): Boolean {
        return (LoginButton.isDisplayed().answeredBy(actor))
                && (SettingsButton.isDisplayed().answeredBy(actor))
                && (HelpAndContactButton.isDisplayed().answeredBy(actor))
                && (LegalButton.isDisplayed().answeredBy(actor))
                && (FeedbackButton.isDisplayed().answeredBy(actor))
    }
}