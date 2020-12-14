package de.prosiebensat1digital.seventv.tasks

import de.prosiebensat1digital.seventv.base.Constants.HOME_SCREEN_RESOURCE_ID
import de.prosiebensat1digital.seventv.base.Constants.PACKAGE_ID
import de.prosiebensat1digital.seventv.interactions.ScrollScrollableToText
import net.serenitybdd.core.steps.Instrumented
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.thucydides.core.annotations.Step

open class ScrollToLane(var laneName: String) : Task {
    @Step("{0} Scrolls to lane: #laneName")
    override fun <T : Actor> performAs(actor: T) {
        actor.attemptsTo(ScrollScrollableToText.called("$PACKAGE_ID:id/$HOME_SCREEN_RESOURCE_ID", laneName))
    }

    companion object {
        fun called(laneName: String): Performable {
            return Instrumented.instanceOf(ScrollToLane::class.java).withProperties(laneName)
        }
    }
}