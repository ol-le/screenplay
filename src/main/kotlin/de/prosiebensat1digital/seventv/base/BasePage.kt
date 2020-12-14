package de.prosiebensat1digital.seventv.base

import io.appium.java_client.pagefactory.AppiumFieldDecorator
import net.thucydides.core.pages.PageObject
import net.thucydides.core.webdriver.WebDriverFacade
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import java.time.Duration


open class BasePage(driver : WebDriver) : PageObject() {

    init {
        PageFactory.initElements(
            AppiumFieldDecorator(
                (driver as WebDriverFacade).proxiedDriver,
                Duration.ofSeconds(20)
            ), this)
    }
}