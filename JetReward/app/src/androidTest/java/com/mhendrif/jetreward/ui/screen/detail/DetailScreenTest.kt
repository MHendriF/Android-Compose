package com.mhendrif.jetreward.ui.screen.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.mhendrif.jetreward.R
import com.mhendrif.jetreward.model.OrderReward
import com.mhendrif.jetreward.model.Reward
import com.mhendrif.jetreward.onNodeWithStringId
import com.mhendrif.jetreward.ui.theme.JetRewardTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeOrderReward = OrderReward(
        reward = Reward(4, R.drawable.reward_4, "Jaket Hoodie Dicoding", 7500),
        count = 0
    )

    @Before
    fun setUp() {
        composeTestRule.setContent {
            JetRewardTheme {
                DetailContent(
                    fakeOrderReward.reward.image,
                    fakeOrderReward.reward.title,
                    fakeOrderReward.reward.requiredPoint,
                    fakeOrderReward.count,
                    onBackClick = {},
                    onAddToCart = {}
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun detailContent_isDisplayed() {
        composeTestRule.onNodeWithText(fakeOrderReward.reward.title).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.required_point,
                fakeOrderReward.reward.requiredPoint
            )
        ).assertIsDisplayed()
    }

    @Test
    fun increaseProduct_buttonEnabled() {
        composeTestRule.onNodeWithContentDescription("Order Button").assertIsNotEnabled()
        composeTestRule.onNodeWithStringId(R.string.plus_symbol).performClick()
        composeTestRule.onNodeWithContentDescription("Order Button").assertIsEnabled()
    }
}