package de.prosiebensat1digital.seventv.tasks

import de.prosiebensat1digital.seventv.interactions.TapOn
import de.prosiebensat1digital.seventv.targets.Targets
import net.serenitybdd.core.steps.Instrumented
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.targets.Target
import net.thucydides.core.annotations.Step


open class Go(var targetToTap: Target) : Task {
    @Step("{0} goes to #targetToTap")
    override fun <T : Actor> performAs(actor: T) {
        actor.attemptsTo(TapOn.the(targetToTap))
    }

    companion object {
        fun toHomeScreen(): Performable {
            return Instrumented.instanceOf(Go::class.java).withProperties(Targets.HOME_BUTTON)
        }

        fun toAccount(): Performable? {
            return Instrumented.instanceOf(Go::class.java).withProperties(Targets.ACCOUNT_LOGO)
        }

        fun toWorthKnowingAll(): Performable? {
            return Instrumented.instanceOf(Go::class.java).withProperties(Targets.WISSENSWERTES_ALL)
        }

        fun toLegal(): Performable? {
            return Instrumented.instanceOf(Go::class.java).withProperties(Targets.LEGAL_BUTTON)
        }

        fun toPrivacyPolicy(): Performable? {
            return Instrumented.instanceOf(Go::class.java).withProperties(Targets.PRIVACY_POLICY)
        }
    }
}
