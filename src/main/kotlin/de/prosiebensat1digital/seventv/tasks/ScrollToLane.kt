package de.prosiebensat1digital.seventv.tasks

import de.prosiebensat1digital.seventv.base.Constants.HOME_SCREEN_RESOURCE_ID
import de.prosiebensat1digital.seventv.base.Constants.PACKAGE_ID
import de.prosiebensat1digital.seventv.base.ScrollOrientation
import de.prosiebensat1digital.seventv.interactions.ScrollScrollableToText
import de.prosiebensat1digital.seventv.targets.Targets
import de.prosiebensat1digital.seventv.targets.Utils
import io.appium.java_client.MobileBy
import net.serenitybdd.core.steps.Instrumented
import net.serenitybdd.screenplay.*
import net.serenitybdd.screenplay.GivenWhenThen.seeThat
import net.serenitybdd.screenplay.targets.Target
import net.thucydides.core.annotations.Step
import org.hamcrest.Matchers
import java.lang.Exception

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