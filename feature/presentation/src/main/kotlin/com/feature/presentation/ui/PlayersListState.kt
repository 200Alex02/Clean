package com.feature.presentation.ui

import androidx.compose.runtime.Immutable
import com.feature.domain.model.Player

@Immutable
data class PlayersListState(
    val players: List<Player> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = false
)