package de.prosiebensat1digital.seventv.tasks

import de.prosiebensat1digital.seventv.base.Constants.PACKAGE_ID
import io.appium.java_client.android.AndroidDriver
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.thucydides.core.annotations.Step
import net.thucydides.core.webdriver.WebDriverFacade

open class Restart : Task {
    @Step("{0} Restarts the app")
    override fun <T : Actor> performAs(actor: T) {
        val driver = ((BrowseTheWeb.`as`(actor).driver as WebDriverFacade).proxiedDriver as AndroidDriver<*>)
        driver.terminateApp(PACKAGE_ID)
        driver.activateApp(PACKAGE_ID)
    }

    companion object {
        fun theApp(): Performable {
            return Tasks.instrumented(Restart::class.java)
        }
    }
}