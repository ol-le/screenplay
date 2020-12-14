package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import io.appium.java_client.android.AndroidDriver
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.targets.Target
import org.openqa.selenium.*
import kotlin.NoSuchElementException


class ElementIsOnScreen(private val element: Target) : Question<Boolean> {
    override fun answeredBy(actor: Actor): Boolean {
        val itemToSearch: WebElement = element.resolveFor(actor).element
        val driver = BrowseTheWeb.`as`(actor).driver
        return isOnscreen(itemToSearch,  driver)
    }


    private fun isOnscreen(element : WebElement, driver: WebDriver) : Boolean{
        return try {
            val elementRectangle =  element.rect
            val screenRectangle = Rectangle(Point(0, 0), driver.manage().window().size)
            elementRectangle.getX() >= screenRectangle.getX()
                    && elementRectangle.getY() >= screenRectangle.getY()
                    && elementRectangle.getX() + elementRectangle.getWidth() <= screenRectangle.getX() + screenRectangle.getWidth()
                    && elementRectangle.getY() + elementRectangle.getHeight() <= screenRectangle.getY() + screenRectangle.getHeight()
        } catch (e: NoSuchElementException) {
            false
        } catch (e: StaleElementReferenceException) {
            false
        }
    }
}