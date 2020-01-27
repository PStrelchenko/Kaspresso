@file:Suppress("unused")
package com.kaspersky.components.kautomator.dsl.common.assertions

import com.google.common.truth.Truth.assertThat
import com.kaspersky.components.kautomator.intercepting.delegate.UiObjectDelegate
import com.kaspersky.components.kautomator.intercepting.operation.UiOperationType

/**
 * Base interface for asserting UiAutomator views
 *
 * Provides basic assertions that can be performed on any view
 *
 * @see com.kaspersky.components.kautomator.dsl.text.UiTextViewAssertions
 */
interface UiBaseAssertions {
    val view: UiObjectDelegate

    /**
     * Checks if the view is completely displayed
     */
    fun isDisplayed() {
        view.check(DisplayedObjectAssertion.assertDisplayed())
    }

    /**
     * Checks if the view is not completely displayed
     */
    fun isNotDisplayed() {
        // TODO: use interceptors
        assertThat(view.loadView()).isFalse()
    }

    /**
     * Checks if the view is selected
     */
    fun isSelected() {
        view.check(BaseAssertionType.IS_SELECTED) { assertThat(isSelected).isTrue() }
    }

    /**
     * Checks if the view is not selected
     */
    fun isNotSelected() {
        view.check(BaseAssertionType.IS_NOT_SELECTED) { assertThat(isSelected).isFalse() }
    }

    /**
     * Checks if the view is focused
     */
    fun isFocused() {
        view.check(BaseAssertionType.IS_FOCUSED) { assertThat(isFocused).isTrue() }
    }

    /**
     * Checks if the view is not focused
     */
    fun isNotFocused() {
        view.check(BaseAssertionType.IS_NOT_FOCUSED) { assertThat(isFocused).isFalse() }
    }

    /**
     * Checks if the view is focusable
     */
    fun isFocusable() {
        view.check(BaseAssertionType.IS_FOCUSABLE) { assertThat(isFocusable).isTrue() }
    }

    /**
     * Checks if the view is not focusable
     */
    fun isNotFocusable() {
        view.check(BaseAssertionType.IS_NOT_FOCUSABLE) { assertThat(isFocusable).isFalse() }
    }

    /**
     * Checks if the view is clickable
     */
    fun isClickable() {
        view.check(BaseAssertionType.IS_CLICKABLE) { assertThat(isClickable).isTrue() }
    }

    /**
     * Checks if the view is not clickable
     */
    fun isNotClickable() {
        view.check(BaseAssertionType.IS_NOT_CLICKABLE) { assertThat(isClickable).isFalse() }
    }

    /**
     * Checks if the view is enabled
     */
    fun isEnabled() {
        view.check(BaseAssertionType.IS_ENABLED) { assertThat(isEnabled).isTrue() }
    }

    /**
     * Checks if the view is disabled
     */
    fun isDisabled() {
        view.check(BaseAssertionType.IS_DISABLED) { assertThat(isEnabled).isFalse() }
    }

    enum class BaseAssertionType : UiOperationType {
        IS_SELECTED,
        IS_NOT_SELECTED,
        IS_FOCUSED,
        IS_NOT_FOCUSED,
        IS_FOCUSABLE,
        IS_NOT_FOCUSABLE,
        IS_CLICKABLE,
        IS_NOT_CLICKABLE,
        IS_ENABLED,
        IS_DISABLED
    }
}