package de.prosiebensat1digital.seventv.tasks

import de.prosiebensat1digital.seventv.interactions.TapOn
import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks
import net.thucydides.core.annotations.Step

open class Confirm: Task {
    @Step("{0} confirms tracking disabling")
    override fun <T : Actor> performAs(actor: T) {
        actor.attemptsTo(TapOn(Targets.TRACKING_OFF_CONFIRMATION_BUTTON))
    }

    companion object {
        fun trackingDisabling(): Performable {
            return Tasks.instrumented(Confirm::class.java)
        }
    }
}