package de.prosiebensat1digital.seventv

import de.prosiebensat1digital.seventv.abilities.UseAMobileDevice
import de.prosiebensat1digital.seventv.base.BaseTest
import de.prosiebensat1digital.seventv.base.Constants.ORIGINALS_AND_EXCLUSIVES
import de.prosiebensat1digital.seventv.base.Constants.WORTH_KNOWING
import de.prosiebensat1digital.seventv.questions.*
import de.prosiebensat1digital.seventv.tasks.*
import net.serenitybdd.junit.runners.SerenityRunner
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.GivenWhenThen.*
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(SerenityRunner::class)
class Scenario1 : BaseTest() {

    private val user = Actor.named("James")

    @Before
    fun jamesCanUseAMobileDevice() {
        user.can(UseAMobileDevice.with(driver))
    }


    @Test
    fun should_display_more_than_20_cards_in_a_gridview() {
        givenThat(user).wasAbleTo(LaunchTheApp())
        then(user).should(seeThat(HomeScreen.isDisplayed(), `is`(true)))
        then(user).attemptsTo(ScrollHomeScreenDown())
        givenThat(user).wasAbleTo(Go.toHomeScreen())
        then(user).should(seeThat(HomeButton.isSelected(), `is`(true)))
        givenThat(user).attemptsTo(ScrollToLane.called(ORIGINALS_AND_EXCLUSIVES))
        then(user).should(seeThat(OriginalsAndExclusives.isDisplayed(), `is`(true)))
        givenThat(user).wasAbleTo(ScrollToLane.called(WORTH_KNOWING))
        then(user).attemptsTo(Go.toWorthKnowingAll())
        then(user).should(seeThat(GridTitle.hasText(), `is`(WORTH_KNOWING)))
        then(user).should(seeThat(GridLayoutHasMoreThan20Cards(), `is`(true)))
    }
}