package de.prosiebensat1digital.seventv.abilities

import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import org.openqa.selenium.WebDriver

class UseAMobileDevice(webDriver: WebDriver) : BrowseTheWeb(webDriver) {
    override fun toString(): String {
        return "Use a Mobile device"
    }

    companion object {
        fun with(webDriver: WebDriver) = UseAMobileDevice(webDriver)
    }
}