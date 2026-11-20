package com.geecee.escapelauncher.core.model

import androidx.annotation.StringRes

/**
 * Action that can be shown in the bottom sheet or other menus.
 *
 * @param label Literal string label (used for system shortcuts).
 * @param labelRes String resource ID label (used for standard actions).
 * @param isVisible A lambda to determine if this action should be shown for a specific item.
 * @param onClick The callback to execute when the action is clicked.
 * @param onLongPressOrSwipeRight Optional secondary callback (long-press, or swipe-right when
 * that gesture is configured to open item menus) - used by related item rows to drill into that
 * item's own popup instead of launching it, which [onClick] still does.
 */
data class AppAction(
    val label: String? = null,
    @StringRes val labelRes: Int? = null,
    val isVisible: (LauncherItem) -> Boolean = { true },
    val onClick: (LauncherItem) -> Unit,
    val onLongPressOrSwipeRight: ((LauncherItem) -> Unit)? = null
)
