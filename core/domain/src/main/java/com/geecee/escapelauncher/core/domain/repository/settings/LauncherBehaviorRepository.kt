package com.geecee.escapelauncher.core.domain.repository.settings

import com.geecee.escapelauncher.core.model.SwipeRightAction
import kotlinx.coroutines.flow.Flow

interface LauncherBehaviorRepository {
    val hapticFeedBackEnabled: Flow<Boolean>
    suspend fun setHapticFeedback(enabld: Boolean)
    val doubleTapToLock: Flow<Boolean>
    suspend fun setDoubleTapToLock(enabled: Boolean)
    val swipeRightAction: Flow<SwipeRightAction>
    suspend fun setSwipeRightAction(action: SwipeRightAction)
    val allowAnalyitics: Flow<Boolean>
    suspend fun setAllowAnalytics(value: Boolean)
    val hidePrivateSpace: Flow<Boolean>
    suspend fun setHidePrivateSpace(enabled: Boolean)
}
