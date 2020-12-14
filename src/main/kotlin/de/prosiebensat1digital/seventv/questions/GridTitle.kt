package de.prosiebensat1digital.seventv.questions

import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject
import net.serenitybdd.screenplay.questions.Attribute

@Subject("Grid title is ")
class GridTitle {
    companion object {
        fun text(): Question<String> {
            return Attribute.of(Targets.GRID_TITLE)
                .named("text")
                .describedAs("Grid title text")
                .asAString()
        }
    }
}