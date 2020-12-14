package de.prosiebensat1digital.seventv.interactions

import net.serenitybdd.core.steps.Instrumented
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Interaction
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.SilentTask
import net.serenitybdd.screenplay.actions.Click
import net.serenitybdd.screenplay.targets.Target
import net.thucydides.core.annotations.Step


open class TapOn(var targetToTap: Target) : Interaction {
    @Step("{0} taps on #targetToTap")
    override fun <T : Actor> performAs(actor: T) {
        actor.attemptsTo(SilentTask.where(Click.on(targetToTap)))
    }

    companion object {
        fun the(targetToTap: Target): Performable {
            return Instrumented.instanceOf(TapOn::class.java).withProperties(targetToTap)
        }
    }
}