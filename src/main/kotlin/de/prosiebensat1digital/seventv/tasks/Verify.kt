package de.prosiebensat1digital.seventv.tasks

import de.prosiebensat1digital.seventv.base.Constants
import de.prosiebensat1digital.seventv.interactions.ScrollScrollable
import de.prosiebensat1digital.seventv.questions.GridLayoutHasMoreThan20Cards
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks
import net.thucydides.core.annotations.Step
import org.junit.Assert

open class Verify : Task {
    @Step("{0} Verify that number of cards is more than 20")
    override fun <T : Actor> performAs(actor: T) {
        Assert.assertTrue(GridLayoutHasMoreThan20Cards().answeredBy(actor))
    }

    companion object {

        fun numberOfCardsIsMoreThan20(): Performable {
            return Tasks.instrumented(Verify::class.java)
        }
    }
}
