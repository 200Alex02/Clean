package com.feature.presentation.viewModels


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feature.domain.use_case.GetAnalyticsListPlayers
import com.feature.domain.use_case.GetPlayersUseCase
import com.feature.presentation.R
import com.feature.presentation.ui.PlayersListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListPlayersViewModel @Inject constructor(
    application: Application,
    getPlayersUseCase: GetPlayersUseCase,
    private val getAnalyticsListPlayers: GetAnalyticsListPlayers
) : ViewModel() {

    private val _state = MutableStateFlow(PlayersListState())
    val state: StateFlow<PlayersListState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value.players = getPlayersUseCase.execute().toMutableList()
            if (_state.value.players.isEmpty()) {
                _state.value.errorMessage = application.resources.getString(R.string.error_message)
            }
        }
    }

    fun getAnalytics(countPlayers: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getAnalyticsListPlayers.getAnalytics(countPlayers)
        }
    }
}