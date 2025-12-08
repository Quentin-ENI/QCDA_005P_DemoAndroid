package com.example.module05demo03

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class PasswordFieldTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testPasswordTextFieldIsWorking() {
        composeTestRule.setContent {
            PasswordTextField()
        }

        // Test de l'existence du composant
        composeTestRule
            .onNodeWithTag("ptf")
            .assertExists("TextField introuvable")

        // Actions
        composeTestRule
            .onNodeWithTag("ptf")
            .performTextInput("1234")

        composeTestRule
            .onNodeWithContentDescription("Show password")
            .assertHasClickAction()
            .performClick()

        composeTestRule
            .onNodeWithTag("ptf")
            .assertTextContains("1234")
    }
}