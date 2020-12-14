package de.prosiebensat1digital.seventv.targets

import de.prosiebensat1digital.seventv.base.ScrollDirection
import de.prosiebensat1digital.seventv.base.ScrollOrientation
import io.appium.java_client.MobileBy
import net.serenitybdd.screenplay.targets.Target

class Utils {

    companion object {
        fun buildScrollToTextTarget(
            scrollableId: String,
            text : String,
            scrollOrientation: ScrollOrientation
        ): Target {
            val scrollOrientationMethod = getScrollOrientationMethod(scrollOrientation);
           return Target.the("Scroll to $text in $scrollableId $scrollOrientation")
                .located(
                    MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"$scrollableId\"))$scrollOrientationMethod.setSwipeDeadZonePercentage(0.15).setMaxSearchSwipes(20).scrollIntoView(new UiSelector().text(\"$text\"));"
                    )
                )!!
        }

        fun buildScrollScrollableTarget(
            scrollableId: String,
            scrollOrientation: ScrollOrientation,
            scrollDirection: ScrollDirection,
            deadZonePercentage: String
        ): Target {
            val scrollDirectionMethod = getScrollDirectionMethod(scrollDirection);
            val scrollOrientationMethod = getScrollOrientationMethod(scrollOrientation);
            return Target.the("Scroll $scrollableId $scrollDirection")
                .located(
                    MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"$scrollableId\"))$scrollOrientationMethod.setSwipeDeadZonePercentage($deadZonePercentage)$scrollDirectionMethod;"
                    )
                )!!
        }


        private fun getScrollOrientationMethod(scrollOrientation: ScrollOrientation): String {
            return when (scrollOrientation) {
                ScrollOrientation.VERTICAL -> ".setAsVerticalList()"
                ScrollOrientation.HORIZONTAL -> ".setAsHorizontalList()"
            }
        }

        private fun getScrollDirectionMethod(scrollDirection: ScrollDirection): String {
            return when (scrollDirection) {
                ScrollDirection.FORWARD -> ".scrollForward()"
                ScrollDirection.BACKWARD -> ".scrollBackward()"
            }
        }
    }
}