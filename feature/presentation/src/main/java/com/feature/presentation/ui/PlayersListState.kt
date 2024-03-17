package com.feature.presentation.ui

import com.feature.domain.model.Player

data class PlayersListState(
    var players: List<Player> = emptyList(),
    var errorMessage: String = ""
)