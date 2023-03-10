package org.hyperskill.columnrowbox

import androidx.compose.ui.Alignment
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.input.PasswordVisualTransformation
import org.hyperskill.columnrowbox.components.foundation.ColumnRowBox.semContentAlignmentKey
import org.hyperskill.columnrowbox.components.semStringKey
import org.hyperskill.columnrowbox.components.semTextFieldValueKey
import org.hyperskill.columnrowbox.components.semVisualTransformationKey
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class PasswordFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun testTail() {
        composeTestRule.setContent {
            Tail()
        }

        composeTestRule.onRoot().printToLog("BOX")
        setUp()


        composeTestRule.onNodeWithTag("TailTitle").onSiblings().assertAny(hasTestTag("TailBackground"))
        composeTestRule.onNodeWithTag("TailTitle").onParent().assert(SemanticsMatcher.expectValue(
            semContentAlignmentKey, Alignment.BottomEnd)
        )

    }


}