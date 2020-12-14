package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import de.prosiebensat1digital.seventv.tasks.ScrollGridLayoutDown
import net.serenitybdd.core.Serenity
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.SilentTask
import org.openqa.selenium.WebElement

class GridLayoutHasMoreThan20Cards : Question<Boolean> {

    override fun answeredBy(actor: Actor): Boolean {
        var result = getContentDescList(Targets.GRID_RECYCLER_VIEW_ITEM.resolveAllFor(actor)).toSet()
        while (result.size < 21) {
            actor.attemptsTo(SilentTask.where(ScrollGridLayoutDown()))
            val scrolledList = getContentDescList(Targets.GRID_RECYCLER_VIEW_ITEM.resolveAllFor(actor)).toSet()
            if (result.containsAll(scrolledList))
                return false
            else {
                result += result.union(scrolledList)
            }
        }
        Serenity.recordReportData().withTitle("Found Cards Titles").andContents(
            printSetWithIndexes(result)
        )
        return true
    }

    private fun getContentDescList(elements: List<WebElement>): List<String> {
        return elements.map { (it::getAttribute)("content-desc") }
    }

    private fun printSetWithIndexes(set: Set<String>): String {
        var res = ""
        set.forEachIndexed { index, element ->
            res += "$index.$element\n"
        }
        return res
    }
}