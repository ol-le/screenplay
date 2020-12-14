package de.prosiebensat1digital.seventv.base

import net.serenitybdd.junit.runners.SerenityRunner
import net.thucydides.core.annotations.Managed
import org.junit.After
import org.junit.runner.RunWith
import org.openqa.selenium.WebDriver

@RunWith(SerenityRunner::class)
open class BaseTest {

    @Managed(driver = "appium")
    lateinit var driver: WebDriver

    @After
    open fun quit() {
        driver.quit()
    }
}
