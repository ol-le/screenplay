package de.prosiebensat1digital.seventv

import de.prosiebensat1digital.seventv.abilities.UseAMobileDevice
import de.prosiebensat1digital.seventv.base.BaseTest
import de.prosiebensat1digital.seventv.questions.AccountSection
import de.prosiebensat1digital.seventv.questions.HomeScreen
import de.prosiebensat1digital.seventv.questions.TrackingIs
import de.prosiebensat1digital.seventv.tasks.*
import net.serenitybdd.junit.runners.SerenityRunner
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.GivenWhenThen.*
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(SerenityRunner::class)
class Scenario2 : BaseTest() {
    private val user = Actor.named("Sam")

    @Before
    fun samCanUseAMobileDevice() {
        user.can(UseAMobileDevice.with(driver))
    }

    @Test
    fun should_save_tracking_toggle_after_restart() {
        givenThat(user).wasAbleTo(Launch.theApp())
        navigateToTracking()
        then(user).should(seeThat(TrackingIs.on(), Matchers.`is`(true)))
        then(user).attemptsTo(
            SetTrackingTo.off(),
            Confirm.trackingDisabling()
        )
        then(user).should(seeThat(TrackingIs.off(), Matchers.`is`(true)))
        givenThat(user).attemptsTo(Restart.theApp())
        navigateToTracking()
        then(user).should(seeThat(TrackingIs.off(), Matchers.`is`(true)))
    }

    private fun navigateToTracking() {
        then(user).should(seeThat(HomeScreen.displayed(), Matchers.`is`(true)))
        givenThat(user).attemptsTo(Go.toAccount())
        then(user).should(seeThat(AccountSection.loginButtonIsDisplayed(), Matchers.`is`(true)))
        and(user).should(seeThat(AccountSection.settingsButtonIsDisplayed(), Matchers.`is`(true)))
        and(user).should(seeThat(AccountSection.helpAndContactButtonIsDisplayed(), Matchers.`is`(true)))
        and(user).should(seeThat(AccountSection.legalButtonIsDisplayed(), Matchers.`is`(true)))
        and(user).should(seeThat(AccountSection.feedBackButtonIsDisplayed(), Matchers.`is`(true)))
        givenThat(user).wasAbleTo(Go.toLegal())
        then(user).attemptsTo(Go.toPrivacyPolicy())
    }
}