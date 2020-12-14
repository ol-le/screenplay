package de.prosiebensat1digital.seventv.interactions

import de.prosiebensat1digital.seventv.base.ScrollDirection
import de.prosiebensat1digital.seventv.base.ScrollOrientation
import de.prosiebensat1digital.seventv.questions.ElementIsOnScreen
import de.prosiebensat1digital.seventv.questions.ElementIsOverlappedBy
import de.prosiebensat1digital.seventv.targets.Targets
import de.prosiebensat1digital.seventv.targets.Utils
import io.appium.java_client.MobileBy
import net.serenitybdd.core.steps.Instrumented
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.GivenWhenThen.seeThat
import net.serenitybdd.screenplay.Interaction
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.targets.Target
import net.thucydides.core.annotations.Step
import org.hamcrest.Matchers.`is`
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.FluentWait
import java.time.Duration
import java.util.concurrent.atomic.AtomicBoolean


open class ScrollScrollableToText(
    var scrollableId: String,
    var text: String,
    var scrollOrientation: ScrollOrientation
) :
    Interaction {

    @Step("{0} Scrolls the #scrollableId to the text #text")
    override fun <T : Actor> performAs(actor: T) {
        val target = Utils.buildScrollToTextTarget(scrollableId, text, scrollOrientation)
        if (ElementIsOverlappedBy(target, Targets.HOME_BUTTON).answeredBy(actor)
            and ElementIsOverlappedBy(target, Targets.PLUS_BUTTON).answeredBy(actor)
        )
            actor.attemptsTo(ScrollScrollable.forwardShort(scrollableId))
    }


    companion object {

        fun called(scrollableId: String, text: String): Performable {
            return Instrumented.instanceOf(ScrollScrollableToText::class.java)
                .withProperties(scrollableId, text, ScrollOrientation.VERTICAL)
        }

    }

}