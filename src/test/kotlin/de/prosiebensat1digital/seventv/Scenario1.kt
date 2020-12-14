package de.prosiebensat1digital.seventv

import de.prosiebensat1digital.seventv.abilities.UseAMobileDevice
import de.prosiebensat1digital.seventv.base.BaseTest
import de.prosiebensat1digital.seventv.base.Constants.ORIGINALS_AND_EXCLUSIVES
import de.prosiebensat1digital.seventv.base.Constants.WISSENSWERTES
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
        givenThat(user).wasAbleTo(Launch.theApp())
        then(user).should(seeThat(HomeScreen.displayed(), `is`(true)))
        then(user).attemptsTo(ScrollHomeScreen.down())
        givenThat(user).wasAbleTo(Go.toHomeScreen())
        then(user).should(seeThat(HomeButton.selected(), `is`(true)))
        givenThat(user).attemptsTo(ScrollToLane.called(ORIGINALS_AND_EXCLUSIVES))
        then(user).should(seeThat(OriginalsAndExclusives.displayed(), `is`(true)))
        givenThat(user).wasAbleTo(ScrollToLane.called(WISSENSWERTES))
        then(user).attemptsTo(Go.toWissenswertesAll())
        then(user).should(seeThat(GridTitle.text(), `is`(WISSENSWERTES)))
        then(user).attemptsTo(Verify.numberOfCardsIsMoreThan20())
    }
}