package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import de.prosiebensat1digital.seventv.tasks.ScrollGridLayout
import net.serenitybdd.core.Serenity
import net.serenitybdd.screenplay.*
import org.openqa.selenium.WebElement

class GridLayoutHasMoreThan20Cards : Question<Boolean> {

    override fun answeredBy(actor: Actor): Boolean {
        var result = getContentDescList(Targets.GRID_RECYCLER_VIEW_ITEM.resolveAllFor(actor)).toSet()
        while (result.size < 20) {
            actor.attemptsTo(SilentTask.where(ScrollGridLayout.down()))
            val scrolledList = getContentDescList(Targets.GRID_RECYCLER_VIEW_ITEM.resolveAllFor(actor)).toSet()
            if (result.containsAll(scrolledList))
                return false
            else {
                result = result.union(scrolledList)
            }
        }
        Serenity.recordReportData().withTitle("Found Cards Titles").andContents(
            result.toTypedArray().contentToString()
        )
        return true
    }

    private fun getContentDescList(elements: List<WebElement>): List<String> {
        return elements.map { (it::getAttribute)("content-desc") }
    }

    fun <T> mergeSets(first: Set<T>, second: Set<T>): HashSet<T> {
        return object : HashSet<T>() {
            init {
                addAll(first)
                addAll(second)
            }
        }
    }
}