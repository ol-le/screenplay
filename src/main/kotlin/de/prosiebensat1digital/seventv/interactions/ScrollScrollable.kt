package de.prosiebensat1digital.seventv.interactions

import de.prosiebensat1digital.seventv.base.ScrollDirection
import de.prosiebensat1digital.seventv.base.ScrollOrientation
import de.prosiebensat1digital.seventv.targets.Utils
import net.serenitybdd.core.steps.Instrumented
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Interaction
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady
import net.thucydides.core.annotations.Step


open class ScrollScrollable(
    var scrollableId: String,
    var scrollDirection: ScrollDirection,
    var scrollOrientation: ScrollOrientation,
    var deadZonePercentage : String
) :
    Interaction {

    @Step("{0} Scrolls the #scrollableId with #scrollOrientation and #scrollDirection")
    override fun <T : Actor> performAs(actor: T) {
        val targetText = Utils.buildScrollScrollableTarget(scrollableId, scrollOrientation, scrollDirection, deadZonePercentage)
        actor.attemptsTo(WaitUntilTargetIsReady((targetText), WebElementStateMatchers.isVisible()))
    }

    companion object {
        fun forward(scrollableId: String): Performable {
            return Instrumented.instanceOf(ScrollScrollable::class.java)
                .withProperties(scrollableId, ScrollDirection.FORWARD, ScrollOrientation.VERTICAL, "0.15")
        }

        fun forwardShort(scrollableId: String): Performable {
            return Instrumented.instanceOf(ScrollScrollable::class.java)
                .withProperties(scrollableId, ScrollDirection.FORWARD, ScrollOrientation.VERTICAL, "0.30")
        }

    }
}