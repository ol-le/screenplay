package de.prosiebensat1digital.seventv.tasks

import de.prosiebensat1digital.seventv.base.Constants.HOME_SCREEN_RESOURCE_ID
import de.prosiebensat1digital.seventv.base.Constants.PACKAGE_ID
import de.prosiebensat1digital.seventv.interactions.ScrollScrollable
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks
import net.thucydides.core.annotations.Step


open class ScrollHomeScreenDown() : Task {
    @Step("{0} scrolls home screen down")
    override fun <T : Actor> performAs(actor: T) {
       actor.attemptsTo(ScrollScrollable.forward("$PACKAGE_ID:id/$HOME_SCREEN_RESOURCE_ID"))
    }
}
