package de.prosiebensat1digital.seventv.questions

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject
import net.serenitybdd.screenplay.targets.Target
import org.openqa.selenium.Point
import org.openqa.selenium.Rectangle
import org.openqa.selenium.WebElement


@Subject("The '#targetElement' is overlapped by '#overlappingElement'")
class ElementIsOverlappedBy(val targetElement: Target, val overlappingElement : Target) : Question<Boolean> {

    override fun answeredBy(actor: Actor): Boolean {
        val targetElement: WebElement = targetElement.resolveFor(actor).element
        val overlappingElement: WebElement = overlappingElement.resolveFor(actor).element
        return (isOverlapping(targetElement.rect, overlappingElement.rect))
    }

    private fun isOverlapping(rect1: Rectangle, rect2: Rectangle): Boolean {
        val l1 = Point(rect1.getX(), rect1.getY() + rect1.getHeight())
        val r1 = Point(rect1.getX() + rect1.getWidth(), rect1.getY())
        val l2 = Point(rect2.getX(), rect2.getY() + rect2.getHeight())
        val r2 = Point(rect2.getX() + rect2.getWidth(), rect2.getY())
        if (l1.x > r2.x || l2.x > r1.x) return false
        return !(l1.y < r2.y || l2.y < r1.y)
    }

}