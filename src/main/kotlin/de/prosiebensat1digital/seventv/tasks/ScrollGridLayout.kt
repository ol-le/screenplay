package de.prosiebensat1digital.seventv.tasks

import de.prosiebensat1digital.seventv.base.Constants.GRID_RECYCLE_RESOURCE_ID
import de.prosiebensat1digital.seventv.base.Constants.PACKAGE_ID
import de.prosiebensat1digital.seventv.interactions.ScrollScrollable
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks
import net.thucydides.core.annotations.Step

open class ScrollGridLayout : Task {
    @Step("{0} scrolls the grid layout screen down")
    override fun <T : Actor> performAs(actor: T) {
        actor.attemptsTo(ScrollScrollable.forwardShort("$PACKAGE_ID:id/$GRID_RECYCLE_RESOURCE_ID"))
    }

    companion object {
        fun down(): Performable {
            return Tasks.instrumented(ScrollGridLayout::class.java)
        }
    }
}