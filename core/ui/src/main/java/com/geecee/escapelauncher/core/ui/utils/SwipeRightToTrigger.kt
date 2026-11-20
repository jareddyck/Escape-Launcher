package com.geecee.escapelauncher.core.ui.utils

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Fires [onTrigger] once a rightward drag starting on this element crosses [threshold]. Built on
 * [detectHorizontalDragGestures], which only commits to a horizontal drag once touch slop
 * resolves it as horizontal - a vertical drag is left alone, so this doesn't fight an ancestor's
 * vertical scrolling (e.g. the LazyColumn this is used inside on the home screen/apps list).
 */
fun Modifier.swipeRightToTrigger(
    enabled: Boolean,
    threshold: Dp = 50.dp,
    onTrigger: () -> Unit
): Modifier = if (!enabled) this else composed {
    val thresholdPx = with(LocalDensity.current) { threshold.toPx() }
    pointerInput(onTrigger, thresholdPx) {
        var dragged = 0f
        var triggered = false
        detectHorizontalDragGestures(
            onDragStart = {
                dragged = 0f
                triggered = false
            },
            onHorizontalDrag = { change, dragAmount ->
                if (triggered) {
                    change.consume()
                    return@detectHorizontalDragGestures
                }
                dragged += dragAmount
                if (dragged > thresholdPx) {
                    triggered = true
                    onTrigger()
                    change.consume()
                }
            }
        )
    }
}
