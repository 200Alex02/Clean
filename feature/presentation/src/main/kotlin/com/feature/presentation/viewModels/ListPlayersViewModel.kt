package com.feature.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feature.domain.use_case.GetPlayersUseCase
import com.feature.domain.use_case.SendAnalyticsListPlayersUseCase
import com.feature.domain.util.Resource
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
    private val getPlayersUseCase: GetPlayersUseCase,
    private val sendAnalyticsListPlayersUseCase: SendAnalyticsListPlayersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PlayersListState())
    val state: StateFlow<PlayersListState> = _state

    init {
        getListPlayers()
    }

    fun getListPlayers() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { playersListState -> playersListState.copy(isLoading = true) }

            val result = getPlayersUseCase.execute()
            delay(1000)

            when (result) {
                is Resource.Success -> {
                    _state.update { playersListState ->
                        playersListState.copy(
                            players = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    clearErrorMessage()
                }

                is Resource.Error -> {
                    _state.update { playersListState ->
                        playersListState.copy(
                            errorMessage = result.errorMessage.toString(),
                            isLoading = false
                        )
                    }
                }
            }
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