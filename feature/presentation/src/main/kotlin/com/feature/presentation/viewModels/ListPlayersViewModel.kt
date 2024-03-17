package com.feature.presentation.viewModels


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feature.domain.use_case.GetPlayersUseCase
import com.feature.domain.use_case.SendAnalyticsListPlayersUseCase
import com.feature.presentation.R
import com.feature.presentation.ui.PlayersListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListPlayersViewModel @Inject constructor(
    context: Context,
    private val getPlayersUseCase: GetPlayersUseCase,
    private val sendAnalyticsListPlayersUseCase: SendAnalyticsListPlayersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PlayersListState())
    val state: StateFlow<PlayersListState> = _state

    init {
        getListPlayers(context)
    }

    fun getListPlayers(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { playersListState -> playersListState.copy(isLoading = true) }

            val players = getPlayersUseCase.execute().toMutableList()
            delay(1000)
            _state.update { playersListState -> playersListState.copy(players = players) }
            clearErrorMessage()

            if (players.isEmpty()) {
                _state.update { playersListState ->
                    playersListState.copy(
                        errorMessage = context.resources.getString(
                            R.string.error_message
                        )
                    )
                }
            }
            _state.update { playersListState -> playersListState.copy(isLoading = false) }
        }
    }

    private fun clearErrorMessage() {
        _state.update { playersListState -> playersListState.copy(errorMessage = "") }
    }

    fun sendAnalytics(countPlayers: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            sendAnalyticsListPlayersUseCase.sendAnalytics(countPlayers)
        }
    }
}