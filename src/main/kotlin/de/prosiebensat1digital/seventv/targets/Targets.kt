package de.prosiebensat1digital.seventv.targets

import de.prosiebensat1digital.seventv.base.BasePage
import de.prosiebensat1digital.seventv.base.Constants.ALLE
import de.prosiebensat1digital.seventv.base.Constants.HOME_SCREEN_RESOURCE_ID
import de.prosiebensat1digital.seventv.base.Constants.ORIGINALS_AND_EXCLUSIVES
import de.prosiebensat1digital.seventv.base.Constants.PACKAGE_ID
import de.prosiebensat1digital.seventv.base.Constants.WISSENSWERTES
import de.prosiebensat1digital.seventv.base.ScrollOrientation
import io.appium.java_client.MobileBy
import net.serenitybdd.screenplay.targets.Target
import org.openqa.selenium.WebDriver

class Targets(driver: WebDriver) : BasePage(driver) {

    companion object {

        val SUSHI_BAR_RECYCLE_VIEW = Target.the("Home Screen Sushi Bar Recycler View")
            .located(MobileBy.id(HOME_SCREEN_RESOURCE_ID))!!

        val HOME_BUTTON = Target.the("Home Button")
            .located(MobileBy.id("action_home"))!!

        val ORIGINALS_AND_EXCLUSIVES_TITLE =
            Utils.buildScrollToTextTarget(HOME_SCREEN_RESOURCE_ID, ORIGINALS_AND_EXCLUSIVES, ScrollOrientation.VERTICAL)

        val WISSENSWERTES_ALL = Target.the("Wissenswertes Alle")
            .located(MobileBy.AndroidUIAutomator("new UiSelector().text(\"$WISSENSWERTES\").fromParent(new UiSelector().text(\"$ALLE\"));"))!!

        val GRID_TITLE = Target.the("Grid Title").located(MobileBy.id("toolbar_title"))

        val PLUS_BUTTON = Target.the("Plus button").located(MobileBy.id("action_premium"))

        val GRID_RECYCLER_VIEW_ITEM = Target.the("Grid Recycler View Item")
            .located(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"$PACKAGE_ID:id/series_item_container_new_metadata\");"))

        val ACCOUNT_LOGO = Target.the("Account")
            .located(MobileBy.AndroidUIAutomator("new UiSelector().description(\"account_icon_top_left\")"))!!

        val LOGIN_BUTTON = Target.the("Login")
            .located(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Login\")"))!!

        val SETTINGS_BUTTON = Target.the("Settings")
            .located(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Einstellungen\")"))!!

        val HELP_AND_CONTACT_BUTTON = Target.the("Help and contact")
            .located(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Hilfe & Kontakt\")"))!!

        val LEGAL_BUTTON = Target.the("Legal")
            .located(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Rechtliches\")"))!!

        val SEND_FEEDBACK_BUTTON = Target.the("Feedback")
            .located(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Feedback senden\")"))!!

        val PRIVACY_POLICY = Target.the("Privacy Policy")
            .located(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Datenschutz\")"))!!

        val TRACKING_ON = Target.the("Tracking On")
            .located(MobileBy.id("view_switch_on"))!!

        val TRACKING_OFF = Target.the("Tracking Off")
            .located(MobileBy.id("view_switch_off"))!!

        val TRACKING_OFF_CONFIRMATION_BUTTON = Target.the("Confirm tracking disabling Button")
            .located(MobileBy.id("info_dialog_negative_btn"))
    }
}