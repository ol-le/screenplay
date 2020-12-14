package de.prosiebensat1digital.seventv.tasks

import de.prosiebensat1digital.seventv.interactions.TapOn
import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.core.steps.Instrumented
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.targets.Target
import net.thucydides.core.annotations.Step

open class SetTrackingTo(var trackingButton : Target) : Task {
    @Step("{0} sets updates tracking by clicking #trackingButton")
    override fun <T : Actor> performAs(actor: T) {
        actor.attemptsTo(TapOn(trackingButton))
    }

    companion object {
        fun off(): Performable {
            return Instrumented.instanceOf(SetTrackingTo::class.java).withProperties(Targets.TRACKING_OFF)
        }
    }
}