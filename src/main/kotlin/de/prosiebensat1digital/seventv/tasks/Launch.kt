package de.prosiebensat1digital.seventv.tasks

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks.instrumented
import net.thucydides.core.annotations.Step


open class Launch : Task {
    @Step("{0} launches the Joyn app")
    override fun <T : Actor> performAs(actor: T) {
    }

    companion object {
        fun theApp(): Performable {
            return instrumented(Launch::class.java)
        }
    }
}
